package Tag.DP;

public class ClimbingStairs {
	/*
	 * 70. Climbing Stairs (Easy)
	 * 
	 * https://leetcode.com/problems/climbing-stairs/
	 * 
	 * solution: https://leetcode.com/problems/climbing-stairs/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
	 * Memory Usage: 35.7 MB, less than 48.84% of Java online submissions for Climbing Stairs.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public int climbStairs(int n) {

		if (n == 1)
			return n;

		int[] dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];

	}
}
