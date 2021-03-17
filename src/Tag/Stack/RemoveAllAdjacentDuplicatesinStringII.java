package Tag.Stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII {

	/*
	 * 1209. Remove All Adjacent Duplicates in String II (Medium)
	 * 
	 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
	 * 
	 * solution: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=CyHKOQZgZ3I&ab_channel=happygirlzt
	 * 
	 * Runtime: 8 ms, faster than 73.35% of Java online submissions for Remove All Adjacent Duplicates in String II.
	 * Memory Usage: 39.6 MB, less than 53.84% of Java online submissions for Remove All Adjacent Duplicates in String II.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	class Node {
		char ch;
		int times;

		public Node(char c) {
			ch = c;
			times = 1;
		}
	}

	public String removeDuplicates(String s, int k) {

		int n = s.length();
		if (n < k)
			return s;
		Stack<Node> stack = new Stack<>();

		for (char c : s.toCharArray()) {

			if (stack.isEmpty() || c != stack.peek().ch) {
				stack.push(new Node(c));
			} else {
				int times = stack.peek().times;
				if (times + 1 == k) {
					stack.pop();
				} else {
					stack.peek().times++;
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {

			Node node = stack.pop();
			int times = node.times;
			for (int i = 0; i < times; i++) {
				sb.append(node.ch);
			}

		}

		return sb.reverse().toString();
	}
}
