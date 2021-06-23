package EH.BaekJoon.Array;

import java.io.*;
import java.util.*;
public class MusicalScales {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String chkStr = "";
		int current = 0;
		int next    = 0;
		outter : while(st.hasMoreTokens()){						
			switch(chkStr) {
				case "ascending" :
					current = next;
					next    = Integer.parseInt(st.nextToken());
					if(current > next) {
						chkStr = "mixed";
						break outter;
					}
					break;
				case "descending" :
					current = next;
					next    = Integer.parseInt(st.nextToken());
					if(current < next) {
						chkStr = "mixed";
						break outter;
					}
					break;								
				default :
					current = Integer.parseInt(st.nextToken());
					next    = Integer.parseInt(st.nextToken());
					if(current < next) chkStr = "ascending";
					if(current > next) chkStr = "descending";
					break;
			}		
		}
		System.out.println(chkStr);
	}
}
