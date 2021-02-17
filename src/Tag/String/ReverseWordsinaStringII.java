package Tag.String;

public class ReverseWordsinaStringII {

	
	/*
	 * 186. Reverse Words in a String II (Medium)
	 * 
	 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
	 * 
	 * https://leetcode.com/problems/reverse-words-in-a-string-ii/solution/
	 * 
	 * Runtime: 1 ms, faster than 99.70% of Java online submissions for Reverse Words in a String II.
	 * Memory Usage: 47 MB, less than 31.75% of Java online submissions for Reverse Words in a String II.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public void reverseWords(char[] s) {

		if (s == null || s.length == 0)
			return;

		int i = 0;
		int j = s.length - 1;

		while (i < j) {
			swap(s, i, j);
			i++;
			j--;
		}
		int left = 0;
		int right = 0;
		for (int n = 0; n < s.length; n++) {

			if (s[n] == ' ' || n == s.length - 1) {

				if (n == s.length - 1) {
					right = n;
				} else {
					right = n - 1;
				}
				while (left < right) {

					swap(s, left, right);
					left++;
					right--;
				}
				left = n + 1;
			}

		}
	}

	private void swap(char[] s, int i, int j) {

		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;

	}

}
