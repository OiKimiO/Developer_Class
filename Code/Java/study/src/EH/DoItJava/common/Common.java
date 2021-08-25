package EH.DoItJava.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Common {
	public static int[] sortWrite(int[] arr) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[Integer.parseInt(st.nextToken())];
		int cnt = 0;
		while(st.hasMoreTokens()) arr[cnt++] = Integer.parseInt(st.nextToken());
		return arr;
	}
	
	public static void print(int[] arr) {
		for(int num : arr) System.out.print(num + " ");
	}
	
	
}
