package Tag.String;

public class RansomNote {

	/*
	 * 383. Ransom Note (Easy)
	 * 
	 * https://leetcode.com/problems/ransom-note/
	 * 
	 * solution: https://leetcode.com/problems/ransom-note/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=HyXZefMXypU&feature=youtu.be&ab_channel=happygirlzt
	 * 
	 * Runtime: 2 ms, faster than 99.06% of Java online submissions for Ransom Note.
	 * Memory Usage: 39.3 MB, less than 68.76% of Java online submissions for Ransom Note.
	 * 
	 * Time complexity: O(m*n), where m is the length of the magazine, and n is the length of the ransom note.
	 * Space complexity: O(m)
	 * 
	 * 
	 */
	public boolean canConstruct(String ransomNote, String magazine) {

		int[] cs = new int[26];

		for (char c : magazine.toCharArray()) {
			cs[c - 'a']++;
		}

		for (char c : ransomNote.toCharArray()) {

			if (--cs[c - 'a'] < 0)
				return false;

		}

		return true;

	}
}
