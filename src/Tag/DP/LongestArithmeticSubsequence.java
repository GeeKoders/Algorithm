package Tag.DP;

import java.util.Arrays;

public class LongestArithmeticSubsequence {
	
	/*
	 * 1027. Longest Arithmetic Subsequence (Medium)
	 * 
	 * https://leetcode.com/problems/longest-arithmetic-subsequence/
	 * 
	 * reference: https://www.youtube.com/watch?v=VJbky8pzRJY&ab_channel=happygirlzt
	 * 
	 * Runtime: 98 ms, faster than 82.98% of Java online submissions for Longest Arithmetic Subsequence.
	 * Memory Usage: 104.5 MB, less than 6.31% of Java online submissions for Longest Arithmetic Subsequence.
	 * 
	 * 
	 */
	public int longestArithSeqLength(int[] A) {
		int n = A.length;
		int[][] dp = new int[n][n];
		int[] index = new int[20001];
		Arrays.fill(index, -1);

		int max = 2;
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], 2);

			for (int j = i + 1; j < n; j++) {
				int first = A[i] * 2 - A[j];
				if (first < 0 || index[first] == -1)
					continue;

				dp[i][j] = dp[index[first]][i] + 1;
				max = Math.max(max, dp[i][j]);
			}

			index[A[i]] = i;
		}

		return max;
	}
}
