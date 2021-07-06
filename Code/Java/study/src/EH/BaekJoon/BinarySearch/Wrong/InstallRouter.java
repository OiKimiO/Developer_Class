package EH.BaekJoon.BinarySearch.Wrong;
import java.util.*;

public class InstallRouter {
    static int N;
	static long C, findNum;
    static long[] homeArr;
    public static void main(String[] args) {    	
		Scanner scan = new Scanner(System.in);
    	N = scan.nextInt();
    	C = scan.nextInt();  
        homeArr = new long[N];
    	for(int i = 0; i < N;i++) homeArr[i] = scan.nextInt();
        Arrays.sort(homeArr);
        
        binarySearch(1,homeArr[N-1]-1);
        System.out.println(findNum);
    }
	
	public static void binarySearch(long start, long end) {
		if(start > end) return;
		long mid      = (start + end) / 2;
		long distance = homeArr[0];
		int cnt       = 1;
		
		for(int i = 0; i < N-1; i++) {						
			if(distance + mid <= homeArr[i+1]) {
				distance = homeArr[i+1];
				cnt++;
			}
		}		
		
		if(cnt >= C) {
			findNum = mid;
			binarySearch(mid+1,end);
		}else binarySearch(start,mid-1);
		
		return;
	}
	
}