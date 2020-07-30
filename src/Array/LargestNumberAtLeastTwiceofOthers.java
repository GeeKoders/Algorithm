package Array;

import java.util.Arrays;

public class LargestNumberAtLeastTwiceofOthers {

	/*
	 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
	 * 
	 * 
	 * solution: https://leetcode.com/articles/largest-number-at-least-twice-of-others/
	 * 
	 * 
	 * In a given integer array nums, there is always exactly one largest element.
	 * 
	 * 
	 * Find whether the largest element in the array is at least twice as much
	 * as every other number in the array.
	 * 
	 * If it is, return the index of the largest element, otherwise return -1.
	 * 
	 * Example 1:
	 * Input: nums = [3, 6, 1, 0]
	 * Output: 1
	 * Explanation: 6 is the largest integer, and for every other number in the array x,
	 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
	 * 
	 * Example 2:
	 * Input: nums = [1, 2, 3, 4]
	 * Output: -1
	 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
	 * 
	 * Note:
	 * 1. nums will have a length in the range [1, 50].
	 * 2. Every nums[i] will be an integer in the range [0, 99].
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int dominantIndex(int[] nums) {
        
        if(nums.length <1) return -1 ;
        if(nums.length == 1) return 0 ;
        
        int [] arr = nums.clone() ;
        
        Arrays.sort(nums) ;
        
        int lastIndex = nums.length - 1 ;
        
        if(nums[lastIndex -1]*2 <= nums[lastIndex]){
            for(int i=0; i<arr.length; i++){
                if(nums[lastIndex] == arr[i]){
                    return i ;
                }
            }
        }
        
        return -1 ;
        
    }
	
	public int dominantIndex2(int[] nums) {
        
        if(nums.length <1) return -1 ;
        if(nums.length == 1) return 0 ;
        
        int maxIndex = 0 ;
        for(int i=0; i<nums.length; i++){
        	if(nums[i] > nums[maxIndex]){
        		maxIndex = i ;
        	}
        }
        
        for(int i=0; i<nums.length; i++){
        	if(maxIndex!=i && nums[maxIndex] < nums[i] * 2  ){
        		return -1 ;
        	}
        }
        
        return maxIndex ;
        
    }

}
