package YE.Prime;

public class SearchPrimeAnswer {
	public static void main(String[] args) {
		
        int answer = 0;
        int sum    = 0;        
        int[] nums = {1,2,3,4,5,6,7,8,9}; 
        int cnt    = 0;
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i + 1; j < nums.length - 1 ; j++){
                for(int k = j + 1; k < nums.length ; k++){
                	System.out.print("i ::: " + i);
                    System.out.print(" j ::: " + j);
                    System.out.print(" k ::: " + k);
                    System.out.println();
                	
                	boolean bool = true;
                    sum = nums[i] + nums[j] + nums[k];
                    System.out.println(sum);
                    cnt++;
                    for(int num = 2; num < sum; num++){
                        if(sum % num == 0){
                            bool = false;
                            break;
                        }                        
                    }
                    if(bool) answer++;                      
                }
            }
        }
        System.out.println(cnt);
		System.out.println(answer);
	}
}
