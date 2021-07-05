package EH.DoItJava.Chapter05;

import java.util.*;

public class Recur {

	public static void recur(int n) {
		if(n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
		}
	}
	
	public static void removeTailRecur(int n) {
		while(n > 0) {
			recur(n-1);
			System.out.println(n);
			n = n - 2;
		}
	}
	
	public static void newRecur(int n) {
		Stack<Integer> st = new Stack<>();
		while(true) {
			if(n > 0) {
				st.push(n);
				n = n - 1;				
				continue;
			}		
			if(!st.isEmpty()) {		
				n = st.pop();
				System.out.println(n);
				n = n - 2;
				continue;
			}
			break;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		newRecur(scan.nextInt());	
	}

}
