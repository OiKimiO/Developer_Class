package EH.DoItJava.Chapter05;

import java.util.Scanner;

public class EightQueen {
	static int[] arr;
	static boolean[] visitRow, visitdiagonal1, visitdiagonal2;
	static int cnt,N,endIdx;
	
	public static void print() {
		for(int num : arr) System.out.print(num + " ");
		System.out.println();
		cnt++;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		endIdx         = N - 1;
		arr            = new int[N];
		visitRow       = new boolean[N];
		visitdiagonal1 = new boolean[(N*2)-1];
		visitdiagonal2 = new boolean[(N*2)-1];
		
		set(0);
		System.out.println(cnt);
	}
	
	public static void set(int col) {		
		for(int row = 0; row < N; row++) {
			if(!visitRow[row] && !visitdiagonal1[row + col] && !visitdiagonal2[col - row + endIdx]) {
				arr[col] = row;
				
				if(col == endIdx) print();
				else{				
					visitRow[row] = true;
					visitdiagonal1[row + col] = true;
					visitdiagonal2[col - row + endIdx] = true;
					set(col + 1);
					visitRow[row] = false;
					visitdiagonal1[row + col] = false;
					visitdiagonal2[col - row + endIdx] = false;
				}
			}			
		}		
	}

}
