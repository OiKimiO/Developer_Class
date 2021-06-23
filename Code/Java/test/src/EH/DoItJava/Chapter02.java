package EH.DoItJava;

public class Chapter02 {
	
	public static void main(String[] args) {
		int[] a = {5, 10, 73, 2, -5, 42};
		int[] b = new int[a.length];
		char[] d = new char[20];
		System.out.println(cardConvR(5,16,d));
		
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
	
	static void copy(int[] a, int[] b) {
		b = a.clone();
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
