package Tag.String;

public class CountandSay {

	/*
	 * 38. Count and Say (Medium)
	 * 
	 * https://leetcode.com/problems/count-and-say/
	 * 
	 * solution: https://leetcode.com/problems/count-and-say/solution/
	 * 
	 * Runtime: 1 ms, faster than 99.61% of Java online submissions for Count and Say.
	 * Memory Usage: 36.2 MB, less than 99.18% of Java online submissions for Count and Say.
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=-wB1xj-kOe0&ab_channel=AmellPeralta
	 * 
	 */
	public String countAndSay(int n) {
		if (n <= 0)
			return "";

		String res = "1";

		for (int i = 2; i <= n; i++) {
			res = f(res);
		}

		return res;

	}

	private String f(String res) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < res.length(); i++) {
			int count = 1;
			while (i + 1 < res.length() && res.charAt(i) == res.charAt(i + 1)) {

				count++;
				i++;

			}

			sb.append(count).append(res.charAt(i));

		}

		res = sb.toString();
		return res;
	}
}
