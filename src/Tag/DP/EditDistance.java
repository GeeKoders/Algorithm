package Tag.DP;

import java.util.Arrays;

public class EditDistance {
	
	
	/*
	 * 72. Edit Distance (Hard)
	 * 
	 * https://leetcode.com/problems/edit-distance/
	 * 
	 * solution: https://leetcode.com/problems/edit-distance/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=c4LG9k9ZErM&ab_channel=happygirlzt
	 * 
	 * Runtime: 5 ms, faster than 56.24% of Java online submissions for Edit Distance.
	 * Memory Usage: 38.7 MB, less than 96.09% of Java online submissions for Edit Distance.
	 * 
	 */
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[i][0] = i;
		}

		for (int j = 0; j <= n; j++) {
			dp[0][j] = j;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				char c1 = word1.charAt(i);
				char c2 = word2.charAt(j);

				if (c1 == c2) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					dp[i + 1][j + 1] = Math.min(dp[i + 1][j],
							Math.min(dp[i][j + 1], dp[i][j])) + 1;
				}

			}

		}

		return dp[m][n];

	}
}
