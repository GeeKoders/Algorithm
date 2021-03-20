package Tag.Stack;

import java.util.Stack;

public class BasicCalculator {

	
	/*
	 * Basic Calculator (Hard)
	 * 
	 * https://leetcode.com/problems/basic-calculator/
	 * 
	 * solution: https://leetcode.com/problems/basic-calculator/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=GpLJMW1IGbw&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
	 * 
	 * Runtime: 5 ms, faster than 88.75% of Java online submissions for Basic Calculator.
	 * Memory Usage: 38.9 MB, less than 85.31% of Java online submissions for Basic Calculator.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public int calculate(String s) {

		Stack<Integer> stack = new Stack<>();
		int number = 0;
		int sign = 1;
		int subsum = 0;

		int i = 0;
		while (i < s.length()) {

			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				number = 10 * number + (c - '0');
			} else if (c == '+') {
				subsum += number * sign;
				sign = 1;
				number = 0;
			} else if (c == '-') {
				subsum += number * sign;
				sign = -1;
				number = 0;
			} else if (c == '(') {
				stack.push(subsum);
				subsum = 0;
				number = 0;
				stack.push(sign);
				sign = 1;
			} else if (c == ')') {
				subsum += number * sign;
				number = 0;
				sign = 1;
				subsum *= stack.pop();
				subsum += stack.pop();

			}

			i++;
		}
		// test case: 5
		if (number != 0) {
			subsum += number * sign;
		}

		return subsum;

	}
}
