package Tag.Array;

public class MaximumSubarray {

	
	/*
	 * 53. Maximum Subarray (Easy)
	 * 
	 * https://leetcode.com/problems/maximum-subarray/
	 * 
	 * https://leetcode.com/problems/maximum-subarray/solution/
	 * 
	 * Runtime: 1 ms, faster than 47.83% of Java online submissions for Maximum Subarray.
	 * Memory Usage: 38.7 MB, less than 75.14% of Java online submissions for Maximum Subarray.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 * 
	 */
	public int maxSubArray(int[] nums) {

		int currSum = nums[0];
		int maxSum = nums[0];

		for (int i = 1; i < nums.length; i++) {

			currSum = Math.max(nums[i], currSum + nums[i]);
			maxSum = Math.max(maxSum, currSum);

		}

		return maxSum;

	}
}
