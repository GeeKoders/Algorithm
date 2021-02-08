package Interview.Google.Array;

import java.util.Arrays;

public class FindAndReplaceinString {

	
	/*
	 * 833. Find And Replace in String (Medium)
	 * 
	 * https://leetcode.com/problems/find-and-replace-in-string/
	 * 
	 * solution: https://leetcode.com/problems/find-and-replace-in-string/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=XnvpeptOccQ&ab_channel=happygirlzt
	 * 
	 * Runtime: 1 ms, faster than 99.20% of Java online submissions for Find And Replace in String.
	 * Memory Usage: 38.5 MB, less than 99.02% of Java online submissions for Find And Replace in String.
	 * 
	 * Time conplexity:Time Complexity: O(NQ), where N is the length of S, and we have Q replacement operations.
	 * Space Complexity: O(N)O(N)
	 * 
	 */
	public String findReplaceString(String S, int[] indexes, String[] sources,
			String[] targets) {

		int n = S.length();
		int[] match = new int[S.length()];
		Arrays.fill(match, -1);

		for (int i = 0; i < indexes.length; i++) {

			if (S.substring(indexes[i], indexes[i] + sources[i].length())
					.equals(sources[i])) {
				match[indexes[i]] = i;
			}

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n;) {
			if (match[i] != -1) {
				sb.append(targets[match[i]]);
				i += sources[match[i]].length();

			} else {
				sb.append(S.charAt(i));
				i++;
			}
		}

		return sb.toString();

	}
}
