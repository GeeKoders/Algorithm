package Tag.Array;

public class RunningSumof1dArray {

	
	/*
	 * 1480. Running Sum of 1d Array (Easy)
	 * 
	 * https://leetcode.com/problems/running-sum-of-1d-array/
	 * 
	 * Runtime: 3 ms, faster than 7.74% of Java online submissions for Running Sum of 1d Array.
	 * Memory Usage: 39.5 MB, less than 23.95% of Java online submissions for Running Sum of 1d Array.
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public int[] runningSum(int[] nums) {

		int[] res = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = 0; j <= i; j++) {

				sum += nums[j];

			}

			res[i] = sum;

		}

		return res;
	}

}
