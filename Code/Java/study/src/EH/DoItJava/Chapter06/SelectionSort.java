package EH.DoItJava.Chapter06;

import java.io.*;
import java.util.*;

public class SelectionSort {
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
		select();	
	}
	
	public static void select() {
		for(int i = 0; i < cnt; i++) {
			for(int j = i; j < cnt-1; j++) {
				if(arr[i] > arr[j+1]) {
					int tmp  = arr[i];
					arr[i]   = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			System.out.println(arr[i]);
		}
	}

}
