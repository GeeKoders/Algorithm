package Tag.String;

import java.util.Arrays;

public class ValidAnagram {
	/*
	 * 242. Valid Anagram (Easy)
	 * 
	 * https://leetcode.com/problems/valid-anagram/
	 * 
	 * solution: https://leetcode.com/problems/valid-anagram/solution/
	 * 
	 * Runtime: 2 ms, faster than 94.57% of Java online submissions for Valid Anagram.
	 * Memory Usage: 39.7 MB, less than 28.11% of Java online submissions for Valid Anagram.
	 * 
	 * Time complexity: O(nlogn)
	 * Space complexity: O(1), ignore the function toCharArray()
	 * 
	 */
	public boolean isAnagram(String s, String t) {

		if (s.length() != t.length())
			return false;

		char[] sa = s.toCharArray();
		char[] ta = t.toCharArray();

		Arrays.sort(sa);
		Arrays.sort(ta);

		for (int i = 0; i < sa.length; i++) {
			if (sa[i] != ta[i]) {
				return false;
			}
		}

		return true;

	}
}
