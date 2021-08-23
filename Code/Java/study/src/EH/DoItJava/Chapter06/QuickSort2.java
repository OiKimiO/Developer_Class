package EH.DoItJava.Chapter06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

// 비재귀 퀵정렬, 요솟수가 작은 것을 먼저 처리한다.
public class QuickSort2 {
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
		Stack<Integer> lstack = new Stack();
		Stack<Integer> rstack = new Stack();
		lstack.push(left);
		rstack.push(right);
		
		while(!lstack.isEmpty()) {
			int pl = left  = lstack.pop();
			int pr = right = rstack.pop();
			int mid = arr[(pl+pr)/2];
			
			do {
				while(arr[pl] < mid) pl++;
				while(arr[pr] > mid) pr--;
				if(pl <= pr)swap(pl++,pr--);
			}while(pl <= pr);
			
			if(right - pl < pr - left) {
				int tmp = pl;
				pl = left;
				left = tmp;
				tmp = pr;
				pr  = right;
				right = pr;
			}
			
			if(pl < right) {
				lstack.push(pl);
				rstack.push(right);
			}
			
			if(left < pr) {
				lstack.push(left);
				rstack.push(pr);
			}
			
		}		
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
