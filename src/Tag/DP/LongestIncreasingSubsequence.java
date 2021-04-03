package Tag.DP;

public class LongestIncreasingSubsequence {
	
	/*
	 * 300. Longest Increasing Subsequence (Medium)
	 * 
	 * https://leetcode.com/problems/longest-increasing-subsequence/
	 * 
	 * solution: https://leetcode.com/problems/longest-increasing-subsequence/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=5rfZ4WnNKBk&ab_channel=happygirlzt
	 * 
	 * Runtime: 52 ms, faster than 67.84% of Java online submissions for Longest Increasing Subsequence.
	 * Memory Usage: 38.8 MB, less than 37.77% of Java online submissions for Longest Increasing Subsequence.
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public int lengthOfLIS(int[] nums) {

		int n = nums.length;

		int[] dp = new int[n];

		int maxLen = 0;

		for (int i = 0; i < n; i++) {

			int len = 1;
			for (int j = 0; j < i; j++) {

				if (nums[j] < nums[i]) {
					len = Math.max(len, dp[j] + 1);
				}

			}

			dp[i] = len;

			if (dp[i] > maxLen) {
				maxLen = dp[i];
			}

		}

		return maxLen;

	}
}
