package Tag.DP;

public class LongestCommonSubsequence {
	
	/*
	 * 1143. Longest Common Subsequence (Medium)
	 * 
	 * https://leetcode.com/problems/longest-common-subsequence/
	 * 
	 * soltuion: https://leetcode.com/problems/longest-common-subsequence/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=Dumq-rceuac&ab_channel=happygirlzt
	 * 
	 * Runtime: 17 ms, faster than 20.75% of Java online submissions for Longest Common Subsequence.
	 * Memory Usage: 42.8 MB, less than 42.75% of Java online submissions for Longest Common Subsequence.
	 * 
	 * 
	 */
	public int longestCommonSubsequence(String text1, String text2) {

		int m = text1.length(), n = text2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				char c1 = text1.charAt(i), c2 = text2.charAt(j);

				if (c1 == c2) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}

			}

		}

		return dp[m][n];

	}
}
