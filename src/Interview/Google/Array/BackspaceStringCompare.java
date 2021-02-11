package Interview.Google.Array;

import java.util.Stack;

public class BackspaceStringCompare {

	
	/*
	 * 844. Backspace String Compare (Easy)
	 * 
	 * https://leetcode.com/problems/backspace-string-compare/
	 * 
	 * https://leetcode.com/problems/backspace-string-compare/solution/
	 * 
	 * Your runtime beats 40.08 % of java submissions.
	 * Your memory usage beats 26.23 % of java submissions.
	 * 
	 * Time complexity: O(M+N)
	 * Space complexity: O(M+N)
	 * 
	 */
	public boolean backspaceCompare(String S, String T) {

		if ((S == null || S.length() == 0) && (T == null || T.length() == 0))
			return true;

		return stackBuild(S).equals(stackBuild(T));

	}

	private String stackBuild(String text) {

		Stack<Character> stack = new Stack<>();

		for (char item : text.toCharArray()) {

			if (item != '#') {
				stack.push(item);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}

		}

		return String.valueOf(stack);

	}

}
