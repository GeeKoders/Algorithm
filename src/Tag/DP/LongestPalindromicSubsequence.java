package Tag.DP;

public class LongestPalindromicSubsequence {
	
	/*
	 * Longest Palindromic Subsequence (Medium)
	 * 
	 * https://leetcode.com/problems/longest-palindromic-subsequence/
	 * 
	 * reference: https://www.youtube.com/watch?v=tiKT7U8aF_4&ab_channel=happygirlzt
	 * 
	 * Runtime: 34 ms, faster than 72.33% of Java online submissions for Longest Palindromic Subsequence.
	 * Memory Usage: 48.9 MB, less than 73.82% of Java online submissions for Longest Palindromic Subsequence.
	 * 
	 * 
	 */
	public int longestPalindromeSubseq(String s) {

		int n = s.length();

		int[][] dp = new int[n][n];

		for (int i = n - 1; i >= 0; i--) {

			dp[i][i] = 1;

			for (int j = i + 1; j < n; j++) {

				if (s.charAt(i) == s.charAt(j)) {

					dp[i][j] = dp[i + 1][j - 1] + 2;

				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}

			}

		}

		return dp[0][n - 1];

	}
}
