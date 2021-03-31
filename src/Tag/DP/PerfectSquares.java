package Tag.DP;

import java.util.Arrays;

public class PerfectSquares {
	
	/*
	 * 279. Perfect Squares (Medium)
	 * 
	 * https://leetcode.com/problems/perfect-squares/
	 * 
	 * solution: https://leetcode.com/problems/perfect-squares/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=KaXeidsmvVQ&ab_channel=happygirlzt
	 * 
	 * Runtime: 33 ms, faster than 62.50% of Java online submissions for Perfect Squares.
	 * Memory Usage: 37.8 MB, less than 85.53% of Java online submissions for Perfect Squares.
	 * 
	 * Time complexity: O(N*N^0.5)
	 * Space complexity: O(N)
	 * 
	 */
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, n);
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j * j <= i; j++) {

				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);

			}

		}

		return dp[n];
	}
}
