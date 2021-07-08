package EH.DoItJava.Chapter06;

import java.io.*;
import java.util.*;
public class BubleSort {
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
		
		buble3();
		print();
	}
	
	public static void print(){
		for(int num : arr) {
			System.out.println(num);
		}
	}
	
	public static void buble() {
		for(int i = 0; i < cnt; i++) {
			for(int j = cnt-1; j > i; j--) {
				if(arr[j] < arr[j-1]) {
					int tmp  = arr[j];
					arr[j]   = arr[j-1];
					arr[j-1] = tmp;					
				}
			}
			System.out.println(arr[i]);
		}
	}
	
	public static void buble2() {		
		for(int i = 0; i < cnt; i++) {
			boolean bool = true;
			for(int j = cnt-1; j > i; j--) {				
				if(arr[j] < arr[j-1]) {
					int tmp  = arr[j];
					arr[j]   = arr[j-1];
					arr[j-1] = tmp;
					bool = false;
				}				
			}
			if(bool) break;
		}
	}
	
	public static void buble3() {		
		for(int i = 0; i < cnt; i++) {
			int last = cnt;
			for(int j = cnt-1; j > i; j--) {				
				if(arr[j] < arr[j-1]) {
					int tmp  = arr[j];
					arr[j]   = arr[j-1];
					arr[j-1] = tmp;
					last     = j-1;
				}				
			}
			i = last;
		}
	}
	
}
