package Tag.DP;

import java.util.Arrays;

public class UniquePaths {

	
	/*
	 * 62. Unique Paths (Medium)
	 * 
	 * https://leetcode.com/problems/unique-paths/
	 * 
	 * solution: https://leetcode.com/problems/unique-paths/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
	 * Memory Usage: 35.6 MB, less than 72.67% of Java online submissions for Unique Paths.
	 * 
	 * Time complexity: O(N*M)
	 * Space complexity: O(N*M)
	 * 
	 */
	public int uniquePaths(int m, int n) {

		int[][] d = new int[m][n];

		for (int[] arr : d) {

			Arrays.fill(arr, 1);
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				d[i][j] = d[i][j - 1] + d[i - 1][j];
			}

		}

		return d[m - 1][n - 1];
	}
}
