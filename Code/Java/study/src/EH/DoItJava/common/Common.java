package EH.DoItJava.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.util.Formatter;
import java.util.Locale;
import java.util.Stack;
import java.util.StringTokenizer;


public class Common {
	
	public static int[] sortWrite(int[] arr) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>(); 			
		while(st.hasMoreTokens()) stack.push(Integer.parseInt(st.nextToken()));
		arr = new int[stack.size()];		
		while(stack.size() > 0) arr[stack.size() - 1] = stack.pop();		
		return arr;
	}
	
	public static void swap(int[] arr, int idx1, int idx2) {
		int tmp   = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;				
	}
	
	public static void arrPrint(int[] arr) {
		for(int num : arr) System.out.print(num + " ");		
		System.out.println();
	}
	
	public static void titleArrPrint(String title, int[] arr) {
		System.out.print(title);
		for(int num : arr) System.out.print(num + " ");		
		enter();
	}
	
	public static void enterPrint(int front, String str, int back) {
		String frontStr = "";
		String backStr  = "";
		for(int i = 1; i <= front; i++) frontStr += "\n";
		for(int i = 1; i <= back; i++)  backStr  += "\n";
		System.out.printf(frontStr+str+backStr);
	}
	
	public static void print(String str) {
		System.out.println(str);
	}
	
	public static void printf(String format, Object ... args) {
		System.out.printf(format ,args);
	}
	
	public static void printfln(String format, Object ... args) {
		System.out.printf(format + "\n" ,args);
	}
	
	public static void enter() {
		System.out.println();
	}
}
