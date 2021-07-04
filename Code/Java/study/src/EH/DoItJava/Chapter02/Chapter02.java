package EH.DoItJava.Chapter02;

import java.util.*;
import java.io.*;
public class Chapter02 {
	
	public static void main(String[] args) throws IOException {
		int[] a = {5, 10, 73, 2, -5, 42};
		int[] b = new int[a.length];
		char[] d = new char[20];
		
		//reverse(a);
		// for(int num : a) System.out.println(num);
		String str = "b";
		str = "cd";
		
		//System.out.println(cardConvR(5,16,d));
		
		// inputNum();
		
		/*
		copy(a,b);	// copy 메서드에서만 a배열을 clone
		printArr(a,"copy 메서드 내 clone 후 배열 a :::");
		printArr(b,"copy 메서드 내 clone 후 배열 b :::");		
		reverse(a); // 메서드 내에서 a의 배열에 변경이 생겼다면 배열 본체의 변화가 생긴다. 그래서 다음 구성 요소에 영향을 줌
		printArr(a,"reverse 메서드 후 배열 a :::");
		printArr(b,"reverse 메서드 후 배열 b :::");
		rcopy(a,b);
		printArr(a,"rcopy 메서드 후 배열 a :::");
		printArr(b,"rcopy 메서드 후 배열 b :::");
		*/
	}
	
	static void inputNum() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			double num = Double.parseDouble(st.nextToken());
			if(num > 0 && num <= 1) continue;
			int check = searchPrime(num);
			if(check == 0) continue;
			System.out.println(check);
		}
	}
	
	static int searchPrime(double num) {		
		if(num == 2.0) return (int) num;
		int primeRange = (int) Math.sqrt(num);		
		for(int i = 2; i <= primeRange; i++) {
			if(num % i == 0) return 0;
		}
		return (int) num;		
	}
	
	// 16진수로 변환
	static char[] cardConvR(int x, int y, char[] d) {
		int digits = 0;
		String dChar = "0123456789ABCDEF";
		while(x > 0) {
			d[digits++] = dChar.charAt(x%y);
			x /= y;
		}
		d[digits++] = 'x';
		d[digits++] = '0';
		reverse(d);
		return d;
	}
	
	static void printArr(int[] a, String arrName) {
		System.out.print(arrName);
		for(int num : a) System.out.print(" " + num);
		System.out.println();
	}
	
	static void reverse(char[] a) {
		for(int i = 0; i < a.length/2;i++) {
			char tmp = a[(a.length-(i+1))];
			a[(a.length-(i+1))] = a[i];
			a[i]   = tmp;
		}
	}
	
	static void reverse(int[] a) {
		for(int i = 0; i < a.length/2;i++) {
			// System.out.println("a["+i+"]과(와) a["+(a.length-(i+1))+"]를 교환합니다.");
			int tmp = a[(a.length-(i+1))];
			a[(a.length-(i+1))] = a[i];
			a[i]   = tmp;
			// System.out.println(a[i] + " " + a[(a.length-(i+1))]);
		}
	}
	
	static int sumOf(int[] a) {
		int sum = 0;
		for(int num : a) sum += num;
		return sum;
	}
	
	static void copy(int[] c, int[] d) {
		/* 파라미터 a,b는 main의 인자 배열 a,b의 참조값을 받는다. 
		   copy에서는 새롭게 stack에 c와 d라는 참조 변수를 생성한다. 
		   c는 배열 a의 참조값을 d는 b의 참조값을 가지고 있다. 
		   d배열(b의 참조값)에 c배열(a의 참조값)의 복제하지만 main에서는 변화가 없다.
		   왜냐하면 copy라는 메서드가 종료 될 때 stack에 쌓여 있던 배열 c,d는 없어지기 때문에 
		   c배열(a의 참조값)의 복제가 담긴  d배열은 없어지게 된다(stack에서 d가 사라지게 됨) 		    
		  */ 
		d = c.clone();		
		// System.out.println("copy ::: " + sumOf(b));		
	}
	
	static void rcopy(int[] a, int[] b) {
		for(int i = 0; i < a.length/2;i++) {
			// System.out.println("b["+i+"]과(와) b["+(a.length-(i+1))+"]를 교환합니다.");
			int tmp = a[(a.length-(i+1))];
			b[(a.length-(i+1))] = a[i];
			b[i]   = tmp;
			// System.out.println(b[i] + " " + b[(a.length-(i+1))]);
		}		
	}
}
