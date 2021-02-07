package Interview.Google.Array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

	
	/*
	 * 159. Longest Substring with At Most Two Distinct Characters (Mdeium)
	 * 
	 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/solution/
	 * 
	 * Runtime: 9 ms, faster than 43.53% of Java online submissions for Longest Substring with At Most Two Distinct Characters.
	 * 
	 * Memory Usage: 39.1 MB, less than 59.07% of Java online submissions for Longest Substring with At Most Two Distinct Characters.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 * 
	 */
	public int lengthOfLongestSubstringTwoDistinct(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		int maxLength = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<>();

		while (right < s.length()) {

			map.put(s.charAt(right), right);

			if (map.size() == 3) {
				int smallestIndex = findSmallestIndex(map);
				map.remove(s.charAt(smallestIndex));
				left = smallestIndex + 1;
			}

			maxLength = Math.max(maxLength, right - left + 1);
			right++;

		}

		return maxLength;

	}

	private int findSmallestIndex(Map<Character, Integer> map) {

		int smallestIndex = Integer.MAX_VALUE;

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {

			smallestIndex = Math.min(smallestIndex, entry.getValue());
		}

		return smallestIndex;

	}

}
