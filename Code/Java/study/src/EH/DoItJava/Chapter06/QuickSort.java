package EH.DoItJava.Chapter06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 제귀적 퀵정렬
public class QuickSort {
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
		
		quick(0,arr.length - 1);
		print();
	}
	
	public static void quick(int left, int right) {
		int pl = left;
		int pr = right;
		int mid = arr[(pl+pr)/2];
		
		do {
			while(arr[pl] < mid) pl++;
			while(arr[pr] > mid) pr--;
			if(pl <= pr)swap(pl++,pr--);
		}while(pl <= pr);
		
		if(left < pr) quick(left,pr);
		if(pl < right) quick(pl,right);
	}
	
	public static void swap(int pl, int pr){
		int tmp = arr[pl];
		arr[pl] = arr[pr];
		arr[pr] = tmp;
	}
	
	public static void print(){
		for(int num : arr) {
			System.out.println(num);
		}
	}
}
