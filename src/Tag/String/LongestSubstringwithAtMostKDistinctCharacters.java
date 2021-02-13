package Tag.String;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

	/*
	 * 340. Longest Substring with At Most K Distinct Characters (Medium)
	 * 
	 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
	 * 
	 * solution: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/solution/
	 * 
	 * reference: 
	 * 
	 * https://www.youtube.com/watch?v=KqXKT-QlCwY&ab_channel=happygirlzt
	 * 
	 * Runtime: 8 ms, faster than 44.12% of Java online submissions for Longest Substring with At Most K Distinct Characters.
	 * Memory Usage: 39 MB, less than 67.64% of Java online submissions for Longest Substring with At Most K Distinct Characters.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {

		if (s == null || s.length() == 0)
			return 0;

		Map<Character, Integer> map = new HashMap<>();
		int left = 0, right = 0;
		int res = Integer.MIN_VALUE;
		int n = s.length();
		while (right < n) {

			char c = s.charAt(right);
			map.put(c, map.getOrDefault(c, 0) + 1);

			while (map.size() > k) {

				if (left <= right && map.get(s.charAt(left)) > 0) {
					map.put(s.charAt(left),
							map.getOrDefault(s.charAt(left), 0) - 1);
				}

				if (map.get(s.charAt(left)) == 0) {
					map.remove(s.charAt(left));
				}

				left++;
			}

			right++;

			res = Math.max(res, right - left);

		}

		return res;

	}

}
