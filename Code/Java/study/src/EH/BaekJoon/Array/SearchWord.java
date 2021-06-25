package EH.BaekJoon.Array;

import java.io.*;
import java.util.Arrays;

public class SearchWord {

	public static void main(String[] args) throws IOException {						
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int[] arrWord  = new int[26];
		char[] arrChar = br.readLine().toCharArray();
		Arrays.fill(arrWord, -1);
		for(int i = 0; i < arrChar.length; i++) {						
			int idx = arrChar[i] - 'a';
			if(arrWord[idx] == -1 ) arrWord[idx] = i;						
		}
		for(int num : arrWord) System.out.print(num + " ");
	}

}
