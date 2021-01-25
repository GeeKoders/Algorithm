package Array;

import java.util.Arrays;

public class ThirdMaxiumNumber {

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

		ThirdMaxiumNumber thirdMaxiumNumber = new ThirdMaxiumNumber() ;
		int[] nums = {3, 2, 1} ;
//		int result = thirdMaxiumNumber.solution1(nums) ;
		int result = thirdMaxiumNumber.solution2(nums) ;
		System.out.println("resutl:" + result);
	}
	// waste to much time and hard to understand
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
	//better solution
	public int solution2(int[] nums) {
		
		  	Integer max = null;
	        Integer second_max = null;
	        Integer third_max = null;
	        
	        for (Integer num : nums) {
	            if(num.equals(max) || num.equals(second_max) || num.equals(third_max)) {
	                continue;
	            }
	            
	            if (max == null || num > max) {
	                third_max = second_max;
	                second_max = max;
	                max = num;
	            } else if (second_max == null || num > second_max) {
	                third_max = second_max;
	                second_max = num;
	            } else if (third_max == null || num > third_max) {
	                third_max = num;
	            }
	        }
	        
	        if (third_max == null)
	        {
	            return max;
	        }
	        
	        return third_max;
	    }
		
}
