package Tag.DP;

public class BurstBalloons {
	
	/*
	 * 312. Burst Balloons (Hard)
	 * 
	 * https://leetcode.com/problems/burst-balloons/
	 * 
	 * solution: https://leetcode.com/problems/burst-balloons/solution/
	 * 
	 * Runtime: 59 ms, faster than 97.90% of Java online submissions for Burst Balloons.
	 * Memory Usage: 38.4 MB, less than 71.04% of Java online submissions for Burst Balloons.
	 * 
	 */
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int len = n + 2;
		int[] a = new int[len];
		System.arraycopy(nums, 0, a, 1, n);
		a[0] = 1;
		a[len - 1] = 1;
		int[][] dp = new int[len][len];

		// dp[i][j] = max coins i ~ j

		for (int gap = 2; gap < len; gap++) {

			for (int left = 0; left < len - gap; left++) {

				int right = left + gap;
				int cur = 0;
				for (int i = left + 1; i < right; i++) {
					cur = Math.max(cur, dp[left][i] + dp[i][right] + a[i]
							* a[left] * a[right]);
				}

				dp[left][right] = cur;
			}

		}

		return dp[0][len - 1];

	}
}
