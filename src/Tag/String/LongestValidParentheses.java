package Tag.String;

import java.util.Stack;

public class LongestValidParentheses {

	/*
	 * 32. Longest Valid Parentheses (Hard)
	 * 
	 * https://leetcode.com/problems/longest-valid-parentheses/
	 * 
	 * solution: https://leetcode.com/problems/longest-valid-parentheses/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=AIhyd8lMpIo&ab_channel=GeeksforGeeks
	 * 
	 * Runtime: 2 ms, faster than 72.58% of Java online submissions for Longest Valid Parentheses.
	 * Memory Usage: 39.2 MB, less than 33.50% of Java online submissions for Longest Valid Parentheses.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					res = Math.max(res, i - stack.peek());
				}

			}

		}

		return res;
	}

}
