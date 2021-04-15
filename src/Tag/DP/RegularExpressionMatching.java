package Tag.DP;

public class RegularExpressionMatching {
	
	/*
	 * DFS
	 * 
	 * 10. Regular Expression Matching (Hard)
	 * 
	 * https://leetcode.com/problems/regular-expression-matching/
	 * 
	 * solution: https://leetcode.com/problems/regular-expression-matching/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=EdWzV-9lQMw&ab_channel=happygirlzt
	 * 
	 * Runtime: 69 ms, faster than 7.94% of Java online submissions for Regular Expression Matching.
	 * Memory Usage: 39.3 MB, less than 26.65% of Java online submissions for Regular Expression Matching.
	 * 
	 */
	public boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;

		boolean firstMatch = s.length() > 0
				&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

		if (p.length() >= 2 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2))
					|| (firstMatch && isMatch(s.substring(1), p));
		} else {
			return firstMatch && isMatch(s.substring(1), p.substring(1));
		}
	}
}
