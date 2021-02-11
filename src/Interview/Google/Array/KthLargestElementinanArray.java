package Interview.Google.Array;

import java.util.Arrays;

public class KthLargestElementinanArray {

	
	/*
	 * 215. Kth Largest Element in an Array (Medium)
	 * 
	 * https://leetcode.com/problems/kth-largest-element-in-an-array/
	 * 
	 * solution: https://leetcode.com/problems/kth-largest-element-in-an-array/solution/
	 * 
	 * Your runtime beats 98.02 % of java submissions.
	 * Your memory usage beats 56.65 % of java submissions.
	 * 
	 * Time complexity: O(N*logN)
	 * Space complexity: O(1)
	 * 
	 * 
	 */
	public int findKthLargest(int[] nums, int k) {

		Arrays.sort(nums);

		int n = nums.length;

		return nums[n - k];

	}
}
