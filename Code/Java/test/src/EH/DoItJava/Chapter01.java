package EH.DoItJava;

public class Chapter01 {

	public static void main(String[] args) {
		System.out.println(max4(5,4,3,7));
		System.out.println(max4(8,4,6,7));
		System.out.println(min4(8,4,6,7));
		System.out.println(med3(4,6,6));
		System.out.println(GaussPlus(6));
		Multi();
		printPlus();
		square();
		triangle1();
		triangle2();
		triangle3();
		triangle4(4);
		pyramid(4);
	}
	
	static int max4(int a, int b, int c, int d) {
		int max = a;
		if(max < b) max = b;
		if(max < c) max = c;
		if(max < d) max = d;
		return max;
	}

	static int min4(int a, int b, int c, int d) {
		int min = a;
		if(min > b) min = b;
		if(min > c) min = c;
		if(min > d) min = d;
		return min;
	}
	
	static int med3(int a, int b, int c) {		
		int mid = 0;
		if(a > b) {
			if(b > c) return b;
			else return c;
		}else {
			if(a > c) return a;
			else return c;
		}
	}
	
	static int GaussPlus(int a) {		
		return (a * (a+1))/2;
	}
	
	static void Multi() {
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.print(" "+(i * j));
			}
			System.out.println();
		}
	}
	
	static void printPlus() {
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.print(" "+(i + j));
			}
			System.out.println();
		}
	}
	
	static void square() {
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangle1() {
		for(int i = 0; i < 5;i++) {
			for(int j = 0; j <= i; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangle2() {
		for(int i = 5; i > 0;i--) {
			for(int j = 0; j <= 5; j++ ) {
				if(i <= j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	static void triangle3() {
		for(int i = 0; i < 5;i++) {
			for(int j = 0; j < 5 - i; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangle4(int a) {		
		for(int i = 0; i < a;i++) {
			for(int j = 0; j <= ((2*a)-1); j++ ) {
				if(a + i >= j && a - i <= j ) {
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	static void pyramid(int a) {		
		for(int i = 0; i < a;i++) {
			for(int j = 0; j <= ((2*a)-1); j++ ) {
				if(a + i >= j && a - i <= j ) {
					System.out.print((i+1));
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
