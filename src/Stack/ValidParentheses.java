package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/
 * 
 * solution: https://leetcode.com/problems/valid-parentheses/solution/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1.Open brackets must be closed by the same type of brackets.
 * 2.Open brackets must be closed in the correct order.
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * Input: "()"
 * Output: true
 * 
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: "(]"
 * Output: false
 * 
 * Example 4:
 * Input: "([)]"
 * Output: false
 * 
 * Example 5:
 * Input: "{[]}"
 * Output: true
 * 
 */

public class ValidParentheses {

	private Map<Character, Character> mappings;

	public ValidParentheses() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put('(', ')');
		this.mappings.put('[', ']');
		this.mappings.put('{', '}');
	}

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (stack.isEmpty()) {
				stack.push(c);
			} else {

				if (this.mappings.containsKey(c)) {
					stack.push(c);
				} else {
					char topElement = stack.peek();

					if(this.mappings.get(topElement) == null) return false ;
					
					if (this.mappings.get(topElement) == c) {
						stack.pop();
					} else {
						return false;
					}

				}

			}

		}

		return stack.isEmpty();

	}

	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses() ;
		System.out.println(validParentheses.isValid(")}{({))[{{[}"));
	}

}
