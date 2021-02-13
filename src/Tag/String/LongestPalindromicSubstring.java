package Tag.String;

public class LongestPalindromicSubstring {

	
	/*
	 * 5. Longest Palindromic Substring (Medium)
	 * 
	 * https://leetcode.com/problems/longest-palindromic-substring/
	 * 
	 * solution: https://leetcode.com/problems/longest-palindromic-substring/solution/
	 * 
	 * discuss:
	 * 
	 * https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution
	 * 
	 * Runtime: 26 ms, faster than 63.36% of Java online submissions for Longest Palindromic Substring.
	 * 
	 * Memory Usage: 39.7 MB, less than 43.72% of Java online submissions for Longest Palindromic Substring.
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity: O(1)
	 * 
	 */
	public String longestPalindrome(String s) {

		String res = "";
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			int left = i;
			int right = i;

			while (left >= 0 && s.charAt(left) == c) {
				left--;
			}

			while (right < s.length() && s.charAt(right) == c) {
				right++;
			}

			while (left >= 0 && right < s.length()) {

				if (s.charAt(left) != s.charAt(right)) {
					break;
				}

				left--;
				right++;

			}

			if (s.substring(left + 1, right).length() >= max) {
				res = s.substring(left + 1, right);
				max = Math.max(max, res.length());
			}

		}

		return res;

	}
}
