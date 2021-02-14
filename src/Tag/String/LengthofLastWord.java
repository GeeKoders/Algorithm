package Tag.String;

public class LengthofLastWord {

	
	/*
	 * 58. Length of Last Word (Easy)
	 * 
	 * https://leetcode.com/problems/length-of-last-word/
	 * 
	 * solution: https://leetcode.com/problems/length-of-last-word/solution/
	 * 
	 * Runtime: 1 ms, faster than 52.06% of Java online submissions for Length of Last Word.
	 * Memory Usage: 39.5 MB, less than 5.72% of Java online submissions for Length of Last Word.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public int lengthOfLastWord(String s) {

		int res = 0;

		if (s == null || s.length() == 0)
			return res;

		for (int i = s.trim().length() - 1; i >= 0; i--) {

			if (s.trim().charAt(i) != ' ') {
				res++;
			} else {
				break;
			}

		}

		return res;

	}
}
