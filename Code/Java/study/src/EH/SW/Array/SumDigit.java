package EH.SW.Array;

import java.io.*;
public class SumDigit {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums  = br.readLine();
        int sum        = 0;
        for(int i = 0; i < nums.length(); i++){
        	sum += (nums.charAt(i) - '0');            
        } 		
        System.out.print(sum);
	}
}
