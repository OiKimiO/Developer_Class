package EH.BaekJoon.Array;
import java.io.*;
import java.util.*;
public class My_AttachComplex {
	static int num, sum;
	static int[][] complex;
	static boolean[][] visit;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num               = Integer.parseInt(br.readLine());
		complex           = new int[num][num];
		visit             = new boolean[num][num];
		ArrayList<Integer> arrSum = new ArrayList<>();
		
		// O(n제곱)
		for(int i = 0; i < num; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				complex[i][j] = str.charAt(j) - '0'; 
			}
		}
		 
		// O(n제곱)
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				// 아파트 단지를 방문 한적 없고, 단지내 아파트가 있을 경우
				if(!visit[i][j] && complex[i][j] == 1) {
					sum = 0;
                    dfsSum(i,j);
					arrSum.add(sum);
				}				
			}
		}
		
		// 오름 차순 정렬
		Collections.sort(arrSum);
		
		// 출력
		System.out.println(arrSum.size());
		for(int sum : arrSum) System.out.println(sum);
		
	}
	
	public static void dfsSum(int row,int col) {		
		if(complex[row][col] == 1 && !visit[row][col]) {
			visit[row][col] = true;
			sum++;
			if(col + 1 <= (num -1)) dfsSum(row,col+1);
			if(col - 1 >= 0) dfsSum(row,col-1);
			if(row + 1 <= (num -1)) dfsSum(row+1,col);
			if(row - 1 >= 0) dfsSum(row-1,col);
		}
		
	}
}
