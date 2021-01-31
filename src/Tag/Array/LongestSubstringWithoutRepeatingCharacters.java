package Tag.Array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	
	
	/*
	 * 3. Longest Substring Without Repeating Characters (Medium)
	 * 
	 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
	 * 
	 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
	 * 
	 * Runtime: 180 ms, faster than 7.74% of Java online submissions for Longest Substring Without Repeating Characters.
	 * 
	 * Memory Usage: 114.7 MB, less than 5.05% of Java online submissions for Longest Substring Without Repeating Characters.
	 * 
	 * Brute Force
	 * 
	 * Time complexity: O(N^3)
	 * Space complexity: O(k), k is the size of the Set
	 * 
	 */
	public int lengthOfLongestSubstring(String s) {

		int count = 0;
		int max = 0;

		Set<Character> set = new HashSet();

		for (int i = 0; i < s.length(); i++) {

			for (int j = i; j < s.length(); j++) {
				if (!set.contains(s.charAt(j))) {
					set.add(s.charAt(j));
					count++;
				} else {
					break;
				}
			}
			max = Math.max(max, count);
			count = 0;
			set.clear();

		}

		return max;
	}

}
