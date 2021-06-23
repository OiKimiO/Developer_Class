package EH.BaekJoon.Array;

import java.io.*;
import java.util.*;
public class Cook {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int max   = 0;
		int min   = 0;
		int index = 1;
		for(int i = 1; i <= 5; i++) {
			String str         = rd.readLine();
			StringTokenizer st = new StringTokenizer(str);
			min = 0;
			if(max == 0) {
				while(st.hasMoreTokens()) {
					max += Integer.parseInt(st.nextToken());
				}
				continue;
			}
			
			while(st.hasMoreTokens()) {
				min += Integer.parseInt(st.nextToken());
			}
			
			if(max < min) {
				max = min;
				index = i;
			}			
		}
		System.out.println(index + " " + max);
	}
}
