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
	
	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Backspace String Compare.
	 * Memory Usage: 37.5 MB, less than 34.22% of Java online submissions for Backspace String Compare.
	 * 
	 * Time complexity: O(M+N)
	 * Space complexity: O(1)
	 * 
	 */
	public boolean backspaceCompare2(String S, String T) {
        
	     int i = S.length() - 1, j = T.length() - 1;
	        int skipS = 0, skipT = 0;

	        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
	            while (i >= 0) { // Find position of next possible char in build(S)
	                if (S.charAt(i) == '#') {skipS++; i--;}
	                else if (skipS > 0) {skipS--; i--;}
	                else break;
	            }
	            while (j >= 0) { // Find position of next possible char in build(T)
	                if (T.charAt(j) == '#') {skipT++; j--;}
	                else if (skipT > 0) {skipT--; j--;}
	                else break;
	            }
	            // If two actual characters are different
	            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
	                return false;
	            // If expecting to compare char vs nothing
	            if ((i >= 0) != (j >= 0))
	                return false;
	            i--; j--;
	        }
	        return true;
	}

}
