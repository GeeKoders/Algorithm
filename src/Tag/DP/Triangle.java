package Tag.DP;

import java.util.List;

public class Triangle {
	
	/*
	 * 120. Triangle (Medium)
	 * 
	 * https://leetcode.com/problems/triangle/
	 * 
	 * reference: https://www.youtube.com/watch?v=p1LlPZYw42g&ab_channel=happygirlzt
	 * 
	 * Runtime: 1 ms, faster than 95.54% of Java online submissions for Triangle.
	 * Memory Usage: 39.3 MB, less than 25.97% of Java online submissions for Triangle.
	 * 
	 */
	public int minimumTotal(List<List<Integer>> triangle) {

		if (triangle == null || triangle.size() == 0)
			return 0;

		int rows = triangle.size();

		int[] dp = new int[rows + 1];

		for (int i = rows - 1; i >= 0; i--) {

			for (int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}

		}

		return dp[0];
	}
}
