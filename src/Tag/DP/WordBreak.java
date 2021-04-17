package Tag.DP;

import java.util.List;

public class WordBreak {
	
	/*
	 * 139. Word Break (Medium)
	 * 
	 * https://leetcode.com/problems/word-break/
	 * 
	 * solution: https://leetcode.com/problems/word-break/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=KppuKbiBX78&ab_channel=happygirlzt
	 * 
	 * https://leetcode.com/problems/word-break/solution/
	 * Memory Usage: 39 MB, less than 70.45% of Java online submissions for Word Break.
	 * 
	 */
	public boolean wordBreak(String s, List<String> wordDict) {

		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;

		for (int lo = 0; lo < n; lo++) {

			if (!dp[lo])
				continue;

			for (String word : wordDict) {

				int hi = lo + word.length();
				if (hi <= n && s.substring(lo, hi).equals(word)) {
					dp[hi] = true;
				}

			}

		}

		return dp[n];

	}
}
