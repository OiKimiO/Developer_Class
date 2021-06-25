package EH.SW.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOdd {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        
        for(int i = 1; i <= n; i++){
        	int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
				int num = Integer.parseInt(st.nextToken());
                sum += num % 2 == 1 ? num : 0; 
            }
            System.out.println("#"+i + " " + sum);
        }

	}

}
