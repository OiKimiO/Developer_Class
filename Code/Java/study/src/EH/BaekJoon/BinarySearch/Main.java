package EH.BaekJoon.BinarySearch;
import java.util.Scanner;

public class Main {
    static long N,K,findNum;
    public static void main(String[] args) {
    	/*
  		   K를 이차원 배열인 A의 value값으로 잡을 수 있는 이유는 
  		   A 배열을 오름차순으로 정리했을 때 A배열의 value값이 K이하의 범위안에 반드시 속한다.
  		   그렇게 될 수 있는 근거는 배열 A와 배열 B인덱스의 시작이 1이기 때문이다. 
  		   아래의 예시를 보면 이해할 수 있다. 
 		  
 		  현재 예시의 구성
 		  A 배열(N*N배열)
 		  
 		  A 배열의 Value값을 일렬로 배치 
 		  B 인덱스 값 (인덱스가 1인 경우)
 		  B 인덱스 값 (인덱스가 0인 경우)
 		    		   
  		   1 2
  		   2 4
  		   
  		   1 2 2 4
  		   1 2 3 4
		   0 1 2 3
  		   -----------------------------
    	   
    	   1 2 3
    	   2 4 6
    	   3 6 9
    	   
    	   1 2 2 3 3 4 6 6 9
    	   1 2 3 4 5 6 7 8 9
    	   0 1 2 3 4 5 6 7 8
    	   -------------------------------------
    	   
    	   1 2  3  4 
    	   2 4  6  8
    	   3 6  9 12
    	   4 8 12 16
    	   
    	  1 2 2 3 3 4 4 4 6  6  8  8  9 12 12 16
    	  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16    	 
    	  0 1 2 3 4 5 6 7 8  9 10 11 12 13 14 15
    	  --------------------------------------------  
    	   
    	   1  2  3  4   5
    	   2  4  6  8  10
    	   3  6  9  12 15
    	   4  8  12 16 20
    	   5  10 15 20 25
    	 
    	 1 2 2 3 3 4 4 4 5  5  6  6  8  8  9 10 10 12 12 15 15 16 20 20 25
    	 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
    	 0 1 2 3 4 5 6 7 8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
    	 -------------------------------------------------------------------
    	 
    	 
    	 */
		Scanner scan = new Scanner(System.in);
    	N = scan.nextInt();
    	K = scan.nextInt();  
        
        binarySearch(1,K);
        System.out.println(findNum);
    }
	
	public static void binarySearch(long start, long end) {
		if(start > end) return;
		long mid = (start + end) / 2;
		long KIndex = 0;
		
		for(long i = 1; i <= N; i++) KIndex += Math.min(mid/i, N);
		
		System.out.println(start + " " + mid + " " + end + " " + KIndex);
		
		if(KIndex >= K) {			
			findNum = mid;
			binarySearch(start, mid - 1);			
		}else binarySearch(mid + 1, end);			
		return;	
	}
	
}