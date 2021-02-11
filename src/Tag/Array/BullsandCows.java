package Tag.Array;

public class BullsandCows {

	/*
	 * 299. Bulls and Cows (Medium)
	 * 
	 * https://leetcode.com/problems/bulls-and-cows/
	 * 
	 * solution: https://leetcode.com/problems/bulls-and-cows/solution/
	 * 
	 * Runtime: 11 ms, faster than 24.06% of Java online submissions for Bulls and Cows.
	 * Runtime: 11 ms, faster than 24.06% of Java online submissions for Bulls and Cows.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)to keep hashmap (or array) h which contains at most 10 elements.
	 * 
	 */
	public String getHint(String secret, String guess) {

		if (secret.length() != guess.length())
			throw new IllegalArgumentException();

		int bulls = 0;
		int cows = 0;

		int s[] = new int[10];
		int g[] = new int[10];

		for (int i = 0; i < secret.length(); i++) {

			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {

				s[secret.charAt(i) - '0']++;
				g[guess.charAt(i) - '0']++;
			}

		}

		for (int i = 0; i < s.length; i++) {

			cows = cows + Math.min(s[i], g[i]);

		}

		return String.format("%dA%dB", bulls, cows);
	}

}
