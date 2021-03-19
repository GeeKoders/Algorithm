package Tag.Stack;

import java.util.Stack;

public class SimplifyPath {

	/*
	 * Simplify Path (Medium)
	 * 
	 * https://leetcode.com/problems/simplify-path/
	 * 
	 * solution: https://leetcode.com/problems/simplify-path/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=SxuGQnlsXcw&ab_channel=JacobHuang
	 * 
	 * Runtime: 8 ms, faster than 29.80% of Java online submissions for Simplify Path.
	 * Memory Usage: 39.2 MB, less than 44.01% of Java online submissions for Simplify Path.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public String simplifyPath(String path) {

		Stack<String> stack = new Stack<>();
		String[] arr = path.split("/");

		for (int i = 0; i < arr.length; i++) {

			String cur = arr[i].trim();
			if (cur == null || cur.length() == 0 || cur.equals("."))
				continue;

			if (cur.equals("..")) {

				if (!stack.isEmpty()) {
					stack.pop();
				}

			} else {
				stack.push(cur);
			}

		}

		String res = "";

		while (!stack.isEmpty()) {

			res = "/" + stack.pop() + res;

		}

		return res.length() == 0 ? "/" : res;

	}
}
