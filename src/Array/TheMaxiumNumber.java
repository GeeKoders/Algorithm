package Array;

import java.util.Arrays;

public class TheMaxiumNumber {

	/*
	 * Given a non-empty array of integers, return the third maximum number in
	 * this array. If it does not exist, return the maximum number. The time
	 * complexity must be in O(n).
	 * 
	 * Example 1:
	 * Input: [3, 2, 1]
	 * Output: 1
	 * Explanation: The third maximum is 1.
	 * 
	 * Example 2:
	 * Input: [1, 2]
	 * Output: 2
	 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
	 * 
	 * Example 3:
	 * Input: [2, 2, 3, 1]
	 * Output: 1
	 * Explanation: Note that the third maximum here means the third maximum distinct number.
	 * Both numbers with value 2 are both considered as second maximum.
	 * 
	 */

	public static void main(String[] args) {

		TheMaxiumNumber theMaxiumNumber = new TheMaxiumNumber() ;
		int[] nums = {3, 2, 1} ;
		int result = theMaxiumNumber.solution1(nums) ;
		System.out.println("resutl:" + result);
	}
	
	public int solution1(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0 ;
        }
        int[] target = new int[nums.length] ;
        Arrays.sort(nums) ;
        
        if(nums.length < 3){
            return nums[nums.length - 1] ;
        }else{
            int count = 1 ;
            for(int i=1; i<nums.length; i++){
                if(nums[i-1] != nums[i]){
                    target[count++] = nums[i] ;
                }
            }
            
            target[0] = nums[0] ;
            
            for(int items: target){
                System.out.print("items:" + items + " ") ;
            }
            
            int counter = 0 ;  
            for(int i=0; i<target.length - 1; i++){
                
                if(target[i] < target[i+1]){
                    counter ++ ;
                }
            }
            
            if(counter >= 2){
                return target[counter - 2];
            }else{
                return target[counter] ;
            }
            
        }
        
    }

}
