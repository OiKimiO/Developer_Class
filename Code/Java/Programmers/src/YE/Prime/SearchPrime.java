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

    //(1)�־��� �迭���� 3���� ���� ����
    //(2)�Ҽ����� �Ǵ��ϱ�
	class Solution {
		
		
	    public boolean isPrimeNumber(int num){
	    	//�Ҽ� ����� ���� �ִ��� ������ ���� �ø� ó��
	        int sqrtMaxNum = (int) Math.ceil(Math.sqrt(num));
	        
	        for(int i = 2; i <= sqrtMaxNum; i++){
	            if(num % i == 0) return false;
	        }
	        
	        return true;
	    }
	    
	    public int solution(int[] nums) {
	        int answer = 0;
	        int cnt    = 0;
	      //3���� ���� ���� ���� �����ϴ� �ӽ� �迭 (�ߺ� ������ ���� ���)
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        
	        /* ������ : 
	           1. ���� �ٸ� ���ڸ� �̾ƾ� �ϴµ� ���� ���ڸ� �̰� �ȴ�.(��ü �迭�� �ߺ��� ����ϰ� ��) 
	                           ����) i ::: 0 j ::: 1 k ::: 2  --> 1 + 2 + 3
	        		 i ::: 2 j ::: 1 k ::: 0  --> 3 + 2 + 1
	           2. ���� �ٸ� ���� ���ؼ� ���� ���� ���� �� �ִµ�, �װ��� üũ���� ���Ѵ�. 
	             ����) i ::: 0 j ::: 1 k ::: 7 multiple ::: 11 --> 1 + 2 + 8
	                   i ::: 0 j ::: 2 k ::: 6 multiple ::: 11 --> 1 + 3 + 7
	            �ذ�  : ���� �ٸ� ���ڸ� ���� �� �ֵ��� �����Ѵ�. 
	                    �� �ε������� ���� ������ �ε����� ������ �ȵǱ� ������ 
	                    ���� �ʱⰪ�� i = 0; j = i + 1; k = j + 1;�� �����Ѵ�. 
	                    �� ���̰� 4�� ��� �� �ε����� �ݺ����� �ʾƾ� �ϱ� ������ 
	                    ���� �ݺ����� i < nums.length - 2; j < nums.length - 1; k < nums.length;�� �Ѵ�. 	                 
	             ����) i ::: 0 j ::: 1 k ::: 2
					   i ::: 0 j ::: 1 k ::: 3
					   i ::: 0 j ::: 2 k ::: 3
					   i ::: 1 j ::: 2 k ::: 3	            	                              
	        */
	        for(int i = 0; i < nums.length-2; i++){
	            for(int j = i+1; j < nums.length - 1; j++){
	                for(int k = j+1; k < nums.length; k++){
	                    //if(i != j && j != k && i != k){
	                	    // i, j, k�� ������ ���� �ƴ� ��� ���� ����Ѵ�.
	                        int multiple = nums[i] + nums[j] + nums[k];
	                        System.out.print("i ::: " + i);
	                        System.out.print(" j ::: " + j);
	                        System.out.print(" k ::: " + k);
	                        System.out.print(" multiple ::: " + multiple);
	                        System.out.println();	                        
	                        //���� 1�̰ų� 2�� �������� ���� ����
	                        if(multiple == 1) continue;
	                        else if(multiple % 2 == 0) continue;
	                        else{
	                        	temp.add(multiple);
	                        	// ���� ���� �ӽ� �迭�� ������ �迭�� ���Ѵ�.-->  
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