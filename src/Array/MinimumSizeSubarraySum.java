package Array;

public class MinimumSizeSubarraySum {

	
	/*
	 * https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
	 * 
	 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of
	 * which the sum ≥ s. If there isn't one, return 0 instead.
	 * 
	 * Example: 
	 * Input: s = 7, nums = [2,3,1,2,4,3]
	 * Output: 2
	 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
	 * 
	 * Follow up:
	 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
	 *
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int minSubArrayLen(int s, int[] nums) {
		
		int result = Integer.MAX_VALUE ;
		
		int left = 0 ;
		int sum = 0 ;
		
		for(int i=0; i<nums.length; i++){
			
			sum +=  nums[i] ;
			
			while(sum >= s){
				
				result = Math.min(result, i + 1 - left) ;
				sum -= nums[left] ;
				left++ ;
			}
			
		}
		
		return (result != Integer.MAX_VALUE) ?  result : 0;
	      
	}

}
