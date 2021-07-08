package EH.DoItJava.Chapter06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InsertSort {

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
		insertSort();
		print();
	}
	
	public static void insertSort() {
		for(int i = 1; i < cnt; i++) {
			int j;
			int tmp = arr[i];
			for(j = i; j > 0 && arr[j-1] > tmp; j--) 
				arr[j] = arr[j-1];
			arr[j] = tmp;
		}
	}
	
	public static void print(){
		for(int num : arr) {
			System.out.println(num);
		}
	}

}
