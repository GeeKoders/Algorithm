package Tag.Stack;

import java.util.Stack;

public class MaximalRectangle {
	
	/*
	 * 85. Maximal Rectangle (Hard)
	 * 
	 * https://leetcode.com/problems/maximal-rectangle/
	 * 
	 * solution: https://leetcode.com/problems/maximal-rectangle/solution/
	 * 
	 * reference: 
	 * 
	 * 84 https://www.youtube.com/watch?v=KkJrGxuQtYo&ab_channel=basketwangCoding
	 * 85 https://www.youtube.com/watch?v=2Yk3Avrzauk&ab_channel=basketwangCoding
	 * 
	 * Runtime: 7 ms, faster than 66.30% of Java online submissions for Maximal Rectangle.
	 * Memory Usage: 41.8 MB, less than 81.14% of Java online submissions for Maximal Rectangle.
	 * 
	 * Time complexity : O(NM). Running leetcode84 on each row takes M (length of each row) time. This is done N times for O(NM).
	 * Space complexity : O(M). We allocate an array the size of the the number of columns to store our widths at each row.
	 * 
	 */
	public int maximalRectangle(char[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int row = matrix.length;
		int col = matrix[0].length;
		int[] heights = new int[col];
		int max = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (matrix[i][j] == '1') {
					heights[j]++;
				} else {
					heights[j] = 0;
				}

			}
			int area = largestRectangleArea(heights);
			max = Math.max(max, area);

		}

		return max;

	}

	private int largestRectangleArea(int[] heights) {

		if (heights == null || heights.length == 0)
			return 0;
		int max = 0;
		Stack<Integer> stack = new Stack<>();

		for (int curr = 0; curr < heights.length; curr++) {

			if (stack.isEmpty() || heights[curr] >= heights[stack.peek()]) {
				stack.push(curr);
			} else {

				int right = curr;
				int index = stack.pop();

				while (!stack.isEmpty()
						&& heights[index] == heights[stack.peek()]) {
					index = stack.pop();
				}

				int leftMost = (stack.isEmpty()) ? -1 : stack.peek();

				max = Math.max(max, (right - leftMost - 1) * heights[index]);

				curr--;

			}

		}

		int rightMost = stack.peek() + 1;
		while (!stack.isEmpty()) {

			int index = stack.pop();
			int left = (stack.isEmpty()) ? -1 : stack.peek();
			max = Math.max(max, (rightMost - left - 1) * heights[index]);

		}

		return max;

	}
}
