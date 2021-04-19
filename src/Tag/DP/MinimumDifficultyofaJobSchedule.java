package Tag.DP;

public class MinimumDifficultyofaJobSchedule {
	
	/*
	 * 1335. Minimum Difficulty of a Job Schedule (Hard)
	 * 
	 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
	 * 
	 * reference: https://www.youtube.com/watch?v=HnIpmSBmGj0&ab_channel=happygirlzt
	 * 
	 * Runtime: 5 ms, faster than 99.10% of Java online submissions for Minimum Difficulty of a Job Schedule.
	 * Memory Usage: 36.8 MB, less than 57.14% of Java online submissions for Minimum Difficulty of a Job Schedule.
	 * 
	 */
	public int minDifficulty(int[] jobs, int d) {

		int n = jobs.length;
		if (d > n)
			return -1;
		int[][] dp = new int[d][n];

		int maxAll = 0;
		for (int i = 0; i < n; i++) {
			maxAll = Math.max(maxAll, jobs[i]);
			dp[0][i] = maxAll;

		}

		for (int i = 1; i < d; i++) {
			// dp[i][j] = dp[i-1][k-1] (0~k-1) , dp[i][j] (k~j)
			for (int j = 1; j < n; j++) {

				int min = dp[i - 1][j - 1] + jobs[j];
				int max = jobs[j];
				for (int k = j; k >= i; k--) {

					max = Math.max(max, jobs[k]);
					min = Math.min(min, dp[i - 1][k - 1] + max);

				}

				dp[i][j] = min;

			}

		}

		return dp[d - 1][n - 1];

	}
}
