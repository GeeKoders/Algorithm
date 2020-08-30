package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class SearchforaRange {

	
	/*
	 * https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/
	 * solution: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/
	 * 
	 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * If the target is not found in the array, return [-1, -1].
	 * 
	 * Example 1:
	 * Input: nums = [5,7,7,8,8,10], target = 8
	 * Output: [3,4]
	 * 
	 * Example 2:
	 * Input: nums = [5,7,7,8,8,10], target = 6
	 * Output: [-1,-1]
	 * 
	 * Constraints:
	 * 0 <= nums.length <= 10^5
	 * -10^9 <= nums[i] <= 10^9
	 * nums is a non decreasing array.
	 * -10^9 <= target <= 10^9
	 * 
	 */
	public static void main(String[] args) {

	}

	// time limit exceeded
	public int[] searchRange(int[] nums, int target) {

		 if(nums == null || nums.length == 0) return new int[]{-1, -1} ;
	        
	        int left = 0 ;
	        int right = nums.length - 1 ;
	        
	        int res [] = {-1, -1} ;
	        
	        while(left < right){
	            
	            int mid = left + (right - left) / 2 ;
	            int count = 0 ;
	            if(nums[mid] == target){
	                res[count++] = mid ;
	            }
	            
	            if(nums[mid] > target){
	                right = mid - 1 ;
	            }
	            
	            if(nums[mid] < target){
	                left = mid + 1 ;
	            }
	            
	        }
	        
	        return res ;

	}
	
	
	public int[] searchRange2(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstLast(nums, target, true);
        result[1] = findFirstLast(nums, target, false);
        return result;
    }
    
    private int findFirstLast(int[] nums, int target, boolean first) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid] || (first && target == nums[mid])) { 
                end = mid-1;
            }
            else {
                start = mid+1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
	
	

}
