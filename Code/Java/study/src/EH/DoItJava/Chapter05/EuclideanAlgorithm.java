package EH.DoItJava.Chapter05;

import java.util.*;
public class EuclideanAlgorithm {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		
		System.out.println("최대 공약수는 " + gcd(scan.nextInt(),scan.nextInt()) + "입니다.");
	}
	
	public static int gcd(int max, int min) {				
		if(min == 0)
			return max;
		else 
			return gcd(min,max%min);
	}
}
