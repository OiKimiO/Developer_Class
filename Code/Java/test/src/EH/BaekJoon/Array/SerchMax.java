package EH.BaekJoon.Array;

import java.util.*;
public class SerchMax {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max   = 0;
		int index = 0;
		for(int i = 1; i <= 9; i++) {
			int num = scan.nextInt();
			if(max < num) {
				max   = num;
				index = i;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}

}
