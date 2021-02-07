package Interview.Google.Array;

public class ExpressiveWords {

	/*
	 * 809. Expressive Words (Medium)
	 * 
	 * https://leetcode.com/problems/expressive-words/
	 * 
	 * solution: https://leetcode.com/problems/expressive-words/solution/
	 * 
	 * reference:
	 * 
	 * Your runtime beats 99.07 % of java submissions.
	 * Your memory usage beats 78.65 % of java submissions.
	 * 
	 * https://www.youtube.com/watch?v=6o3-s1AC4es&t=580s&ab_channel=CatRacket
	 * 
	 * Time complexity: O(QK), where QQ is the length of words (at least 1), and KK is the maximum length of a word.
	 * Space complexity: O(1)
	 * 
	 */
	public int expressiveWords(String S, String[] words) {

		int count = 0;

		for (int i = 0; i < words.length; i++) {

			boolean res = wordsCompare(S, words[i]);

			if (res) {
				count++;
			}

		}

		return count;

	}

	private boolean wordsCompare(String S, String word) {

		int i = 0, j = 0;

		while (i < S.length() && j < word.length()) {

			char c1 = S.charAt(i);
			char c2 = word.charAt(j);

			if (c1 != c2)
				return false;

			int e1 = i;
			int e2 = j;

			while (e1 < S.length() && S.charAt(e1) == c1) {
				e1++;
			}

			while (e2 < word.length() && word.charAt(e2) == c2) {
				e2++;
			}

			int n1 = e1 - i;
			int n2 = e2 - j;

			if (n1 < n2 || (n1 < 3 && n1 != n2)) {
				return false;
			}

			i = e1;
			j = e2;

		}

		if (i == S.length() && j == word.length()) {
			return true;
		} else {
			return false;
		}

	}

}
