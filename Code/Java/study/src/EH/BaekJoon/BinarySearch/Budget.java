package EH.BaekJoon.BinarySearch;
import java.io.*;
import java.util.*;

public class Budget {
	static int N, M;
	static int[] arr;
	static int answer = 0;
	static int lastMargin = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {						
		int start = 1;
		int end   = 1;
		int cnt   = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(num > end) end = num;
			arr[cnt++] = num;
		}
		M = Integer.parseInt(br.readLine());
		
		binarySearch(start, end);
		System.out.println(answer);
	}

	public static void binarySearch(int start, int end) {
		if(start > end) return;
		int mid = (start + end) / 2;
		int sum = 0;		
		for(int i=0; i < N; i++) {
			if(mid > arr[i]) sum += arr[i];
			if(mid <= arr[i]) sum += mid;
		}		
		if((M - sum) >= 0 && (M - sum) < lastMargin) {
			lastMargin = (M - sum);
			answer = mid;
		}
		
		if(M > sum) binarySearch(mid+1,end);
		if(M < sum) binarySearch(start,mid-1);
		return;
	}
	
}
