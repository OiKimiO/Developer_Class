package EH.DoItJava.Chapter06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ShellSort {

	static int cnt;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);		
		arr = new int[scan.nextInt()];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			arr[cnt++] = Integer.parseInt(st.nextToken());
		}
		ShellSort2();
		print();
	}
	
	public static void print() {
		for(int num : arr) {
			System.out.println(num);
		}
	}
	
	public static void ShellSort() {		
		for(int i = cnt/2; i > 0; i/=2) { // 4 2 1
			for(int j = i; j < cnt; j++) { // 위의 i만큼만 돈다.				
				int tmp = arr[j];
				
				for(int k = j - i; k >= 0 && arr[k] > tmp; k -= i) {					
					arr[k+i] = arr[k];
					arr[k] = tmp;
				}
				
			}			
		}
	}
	
	public static void ShellSort2() {
		int i;
		for(i = 1; i <= cnt/9; i = (i * 3) + 1);
		
		for(; i>0; i /=3) {
			System.out.println(i);
			for(int j = i; j < cnt; j++) {
				int tmp = arr[j];
				for(int k = j-i; k >=0 && arr[k] > tmp; k -= i) {
					arr[k+i] = arr[k];
					arr[k] = tmp;
				}
			}
		}
	}
	

}
