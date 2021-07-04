package EH.BaekJoon.BinarySearch.Wrong;
import java.io.*;
import java.util.*;
public class WrongSliceTree {
	static int N,M;
	static long max_cut = 0;
	static long[] arrTree;
	public static void main(String[] args) throws IOException {								
		int end = 0, cnt = 0;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arrTree = new long[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());		
		while(st2.hasMoreTokens()){		
			int num = Integer.parseInt(st2.nextToken());
			arrTree[cnt++] = num;			
			end = end < num ? num : end;
			
		}
		
		binarySearch(0,end);		
		System.out.println(max_cut);
	}

	public static void binarySearch(long start, long end) {
		if(start > end) return;
		long mid = (start + end) / 2;
		long sumTree = 0;
		for(int i = 0; i < N; i++) {
			if(arrTree[i] > mid) {
				sumTree += (arrTree[i] - mid);
			}
		}
		
		if(sumTree >= M) {
			System.out.println("sumTree ::: " + sumTree + "mid ::: " + mid);
			max_cut = mid;
			binarySearch(mid+1, end);			
		}else {
			binarySearch(start, mid-1);
		}
		return;
	}
}
