package EH.BaekJoon.Array.Wrong;

import java.util.*;
public class Answer_AttachComplex {
	
	private static int dx[] = {0,0,1,-1}; // x1, x2, x3, x4 || x 좌표가 증가할 수 있는 범위
	private static int dy[] = {1,-1,0,0}; // y1, y2, y3, y4 || y 좌표가 증가할 수 있는 범위
	private static int[] aparts = new int [25*25];
	private static int n;
	private static int apartNum = 0; // 아파트 단지 번호의 수
	private static boolean[][] visited = new boolean[25][25];
	private static int[][] map = new int[25][25];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n   = scan.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		
		// 전체 사각형 입력 받기 O(n제곱)
		for(int i = 0; i < n; i++) {
			String input = scan.next();
			for(int j = 0; j < n; j++) {
				// char형태의 데이터를 인트로 변경하기 위해서는 0을 뺴준다.
				map[i][j] = input.charAt(j) - '0';			
			}
		}
		
		// 아파트 단지의 시작점을 설정한다. O(n제곱)
		// 현재의 좌표가 시작점이 되어 현재 좌표에 포함되는 루트만 카운트 한다.
		for(int i = 0; i < aparts.length; i++ ) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					apartNum++;
					dfs(i,j); 
				}
			}
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		aparts[apartNum]++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// x + x 증가값 , y + y 증가값 이 배열을 넘어설 수 도 있기 때문에 막음
			if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}		
	}
}
