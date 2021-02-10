package Interview.Google.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	
	/*
	 * 20. Valid Parentheses (Easy)
	 * 
	 * https://leetcode.com/problems/valid-parentheses/
	 * 
	 * solution: https://leetcode.com/problems/valid-parentheses/solution/
	 * 
	 * Your runtime beats 98.67 % of java submissions.
	 * Your memory usage beats 75.10 % of java submissions.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public boolean isValid(String s) {

		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			char element = s.charAt(i);

			if (map.containsKey(element)) {

				char popElement = stack.empty() ? '#' : stack.pop();

				if (map.get(element) != popElement) {
					return false;
				}

			} else {
				stack.push(element);
			}

		}

		return stack.empty();

	}
}
