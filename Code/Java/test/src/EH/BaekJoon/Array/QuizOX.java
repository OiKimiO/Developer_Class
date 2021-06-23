package EH.BaekJoon.Array;

import java.io.*;
public class QuizOX {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int sum   = 0;
			int index = 0;
			String str = br.readLine().toUpperCase();
			int strLength = str.length();
			for(int j = 0; j < strLength; j++) {
				if(str.charAt(j) == 'O') sum += ++index;
				else index = 0;				
			}
			System.out.println(sum);
		}
		
	}
}
