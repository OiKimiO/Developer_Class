package YE.Prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class SearchPrime {
	public static void main(String[] args) {
		Solution sl = new Solution();
		int[] arr1 = {1,2,3,4,5,6,7,8,9};
		sl.solution(arr1);
	}
}

    //(1)주어진 배열에서 3개의 수를 고르기
    //(2)소수인지 판단하기
	class Solution {
		
		
	    public boolean isPrimeNumber(int num){
	    	//소수 계산을 위한 최댓값의 제곱근 계산과 올림 처리
	        int sqrtMaxNum = (int) Math.ceil(Math.sqrt(num));
	        
	        for(int i = 2; i <= sqrtMaxNum; i++){
	            if(num % i == 0) return false;
	        }
	        
	        return true;
	    }
	    
	    public int solution(int[] nums) {
	        int answer = 0;
	        int cnt    = 0;
	      //3개의 수를 더한 값을 저장하는 임시 배열 (중복 방지를 위해 사용)
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        
	        /* 문제점 : 
	           1. 서로 다른 숫자를 뽑아야 하는데 같은 숫자를 뽑게 된다.(전체 배열의 중복을 허용하게 됨) 
	                           예시) i ::: 0 j ::: 1 k ::: 2  --> 1 + 2 + 3
	        		 i ::: 2 j ::: 1 k ::: 0  --> 3 + 2 + 1
	           2. 서로 다른 수를 더해서 같은 값이 나올 수 있는데, 그것을 체크하지 못한다. 
	             예시) i ::: 0 j ::: 1 k ::: 7 multiple ::: 11 --> 1 + 2 + 8
	                   i ::: 0 j ::: 2 k ::: 6 multiple ::: 11 --> 1 + 3 + 7
	            해결  : 서로 다른 숫자를 뽑을 수 있도록 변경한다. 
	                    각 인덱스들은 같은 숫자의 인덱스를 가지면 안되기 때문에 
	                    각각 초기값을 i = 0; j = i + 1; k = j + 1;로 설정한다. 
	                    총 길이가 4일 경우 각 인덱스가 반복되지 않아야 하기 때문에 
	                    각각 반복값을 i < nums.length - 2; j < nums.length - 1; k < nums.length;로 한다. 	                 
	             예시) i ::: 0 j ::: 1 k ::: 2
					   i ::: 0 j ::: 1 k ::: 3
					   i ::: 0 j ::: 2 k ::: 3
					   i ::: 1 j ::: 2 k ::: 3	            	                              
	        */
	        for(int i = 0; i < nums.length-2; i++){
	            for(int j = i+1; j < nums.length - 1; j++){
	                for(int k = j+1; k < nums.length; k++){
	                    //if(i != j && j != k && i != k){
	                	    // i, j, k가 동일한 값이 아닐 경우 합을 계산한다.
	                        int multiple = nums[i] + nums[j] + nums[k];
	                        System.out.print("i ::: " + i);
	                        System.out.print(" j ::: " + j);
	                        System.out.print(" k ::: " + k);
	                        System.out.print(" multiple ::: " + multiple);
	                        System.out.println();	                        
	                        //합이 1이거나 2로 나눠지는 경우는 제외
	                        if(multiple == 1) continue;
	                        else if(multiple % 2 == 0) continue;
	                        else{
	                        	temp.add(multiple);
	                        	// 계산된 합이 임시 배열에 없으면 배열에 더한다.-->  
	                            //if(!temp.contains(multiple)){
	                            //	cnt++;
	                            //	temp.add(multiple);
	                            //}
	                        }
	                    //}
	                }
	            }
	        }
	        System.out.println(cnt);
	        System.out.println("last temp : " + temp);
	        
	        for(int i = 0; i < temp.size(); i++){
	            if(isPrimeNumber(temp.get(i))) answer++;
	        }
	        
	        System.out.println("answer : " + answer);

	        return answer;
	    }
	}