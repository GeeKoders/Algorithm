package Tag.String;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
	
	
	/*
	 * 301. Remove Invalid Parentheses (Hard)
	 * 
	 * https://leetcode.com/problems/remove-invalid-parentheses/
	 * 
	 * solution: https://leetcode.com/problems/remove-invalid-parentheses/solution/
	 * 
	 * discuss:
	 * 
	 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
	 * 
	 * reference:
	 * 
	 * (java visualizer)
	 * https://www.youtube.com/watch?v=k4LX7OSl2bY&ab_channel=happygirlzt
	 * 
	 * Runtime: 1 ms, faster than 99.78% of Java online submissions for Remove Invalid Parentheses.
	 * Memory Usage: 39.3 MB, less than 55.83% of Java online submissions for Remove Invalid Parentheses.
	 * 
	 * Time complexity: 
	 * Space complexity: O(N)
	 * 
	 */
	public List<String> removeInvalidParentheses(String s) {

		List<String> res = new ArrayList<>();
		helper(s, 0, 0, res, new char[] { '(', ')' });
		return res;
	}

	private void helper(String s, int left, int right, List<String> res,
			char[] pars) {

		int stack = 0;
		int n = s.length();

		for (; right < n; right++) {

			char c = s.charAt(right);

			if (c == pars[0]) {
				stack++;
			} else {
				stack--;
			}

			if (stack < 0)
				break;
		}

		if (stack < 0) {
			for (; left <= right; left++) {

				char c = s.charAt(left);
				if (c != pars[1]) {
					continue;
				}

				if (left > 1 && s.charAt(left) == s.charAt(left - 1))
					continue;

				helper(s.substring(0, left) + s.substring(left + 1), left,
						right, res, pars);

			}
		} else if (stack > 0) {

			helper(new StringBuilder(s).reverse().toString(), 0, 0, res,
					new char[] { ')', '(' });

		} else {
			res.add(pars[0] == '(' ? s : new StringBuilder(s).reverse()
					.toString());
		}

	}
}
