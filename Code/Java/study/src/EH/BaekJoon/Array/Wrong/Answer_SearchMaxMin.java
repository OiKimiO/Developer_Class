package EH.BaekJoon.Array.Wrong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Answer_SearchMaxMin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int min = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());            
            if(max < num)max = num;
            if(min > num)min = num;
        }
        System.out.print(min + " " + max);
	}

}
