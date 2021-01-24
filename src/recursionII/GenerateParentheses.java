package recursionII;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	
	/*
	 * 22. Generate Parentheses (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2772/
	 * 
	 * solution: https://leetcode.com/problems/generate-parentheses/solution/
	 * 
	 * reference
	 * 
	 * https://www.youtube.com/watch?v=qBbZ3tS0McI&ab_channel=NickWhite
	 * 
	 * https://www.youtube.com/watch?v=sz1qaKt0KGQ&ab_channel=BackToBackSWE
	 * 
	 *  8 / 8 test cases passed.
		Status: Accepted
		Runtime: 1 ms (Your runtime beats 83.31 % of java submissions.)
		Memory Usage: 39.4 MB (Your memory usage beats 36.68 % of java submissions.)
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList();
		backtrack(result, "", 0, 0, n);
		return result;
	}

	private void backtrack(List<String> result, String curr_string, int open,
			int close, int max) {

		if (curr_string.length() == 2 * max) {
			result.add(curr_string);
			return;
		}

		if (open < max)
			backtrack(result, curr_string + "(", open + 1, close, max);
		if (close < open)
			backtrack(result, curr_string + ")", open, close + 1, max);

	}
}
