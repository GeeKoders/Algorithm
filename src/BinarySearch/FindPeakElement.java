package BinarySearch;

public class FindPeakElement {

	/*
	 * https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/
	 * solution: https://leetcode.com/problems/find-peak-element/solution/
	 * 
	 * A peak element is an element that is greater than its neighbors.
	 * 
	 * Given an input array nums, where nums[i] ¡Ú nums[i+1], find a peak element and return its index.
	 * 
	 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
	 * 
	 * You may imagine that nums[-1] = nums[n] = -¡Û.
	 * 
	 * Example 1:
	 * Input: nums = [1,2,3,1]
	 * Explanation: 3 is a peak element and your function should return the index number 2.
	 * Output: 2
	 * 
	 * Example 2:
	 * Input: nums = [1,2,1,3,5,6,4]
	 * Output: 1 or 5 
	 * Explanation: Your function can return either index number 1 where the peak element is 2,
	 * 				or index number 5 where the peak element is 6.
	 * 
	 * Follow up: Your solution should be in logarithmic complexity.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// time limit exceeded
	public int findPeakElement(int[] nums) {
	     
        if(nums == null || nums.length == 0) return -1 ;
        
        int start = 0;
        int end = nums.length - 1 ;
        int result = -1 ;
        while(start < end){
            if(nums[start] < nums[start + 1]){
                result = start + 1 ;
            }
        }
        
        return result ;
    }

}
