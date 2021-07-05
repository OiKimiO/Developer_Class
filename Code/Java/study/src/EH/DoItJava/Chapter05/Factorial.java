package EH.DoItJava.Chapter05;

import java.util.*;
public class Factorial {
	static int sum;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(fn_factorial(scan.nextInt()));
	}
	
	public static int fn_factorial(int num) {		
		if(num > 0) {
			return num * fn_factorial(--num);
		}else {
			return 1;
		}					
	}

}
