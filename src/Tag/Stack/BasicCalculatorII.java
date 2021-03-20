package Tag.Stack;

import java.util.Stack;

public class BasicCalculatorII {
	
	/*
	 * Basic Calculator II (Medium)
	 * 
	 * https://leetcode.com/problems/basic-calculator-ii/
	 * 
	 * solution: https://leetcode.com/problems/basic-calculator-ii/solution/
	 * 
	 * Runtime: 10 ms, faster than 57.77% of Java online submissions for Basic Calculator II.
	 * Memory Usage: 39 MB, less than 72.32% of Java online submissions for Basic Calculator II.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public int calculate(String s) {

		if (s == null || s.length() == 0)
			return 0;
		int i = 0;
		Stack<Integer> stack = new Stack<>();
		int number = 0;
		char operation = '+';
		while (i < s.length()) {

			char c = s.charAt(i);

			if (Character.isDigit(c)) {

				number = 10 * number + (c - '0');

			}

			if (!Character.isDigit(c) && !Character.isWhitespace(c)
					|| i == s.length() - 1) {
				if (operation == '+') {
					stack.push(number);

				} else if (operation == '-') {
					stack.push(-number);
				} else if (operation == '*') {
					stack.push(stack.pop() * number);
				} else if (operation == '/') {
					stack.push(stack.pop() / number);
				}
				operation = c;
				number = 0;

			}

			i++;
		}

		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}

		return res;
	}
}
