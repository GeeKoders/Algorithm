package Tag.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
	
	/*
	 * 472. Concatenated Words (Hard)
	 * 
	 * https://leetcode.com/problems/concatenated-words/
	 * 
	 * reference: https://www.youtube.com/watch?v=hoGGwExHnnQ&ab_channel=happygirlzt
	 * 
	 * Runtime: 651 ms, faster than 34.54% of Java online submissions for Concatenated Words.
	 * Memory Usage: 46.8 MB, less than 67.92% of Java online submissions for Concatenated Words.
	 * 
	 * Time complexity: O(N^2*M^2)
	 * Space complexity: O(N*M)
	 * 
	 * N: the longest word length in word list
	 * M: the size of word set
	 * 
	 */
	public List<String> findAllConcatenatedWordsInADict(String[] words) {

		List<String> res = new ArrayList<>();

		Set<String> set = new HashSet<>();

		for (String s : words) {
			set.add(s);
		}

		for (String s : words) {
			set.remove(s);

			if (canBreak(s, set)) {
				res.add(s);
			}

			set.add(s);

		}

		return res;

	}

	private boolean canBreak(String s, Set<String> set) {

		if (set.size() == 0)
			return false;

		int n = s.length();

		if (n == 0)
			return false;

		boolean[] dp = new boolean[n + 1];
		dp[0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {

				if (!dp[j])
					continue;

				if (set.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}

			}

		}

		return dp[n];

	}
}
