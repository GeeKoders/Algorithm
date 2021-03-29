package Tag.DP;

public class UniquePathsII {
	
	/*
	 * 63. Unique Paths II (Medium)
	 * 
	 * https://leetcode.com/problems/unique-paths-ii/
	 * 
	 * solution: https://leetcode.com/problems/unique-paths-ii/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
	 * Memory Usage: 36.9 MB, less than 93.42% of Java online submissions for Unique Paths II.
	 * 
	 * Time complexity: O(M*N)
	 * Space complexity: O(1)
	 * 
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int r = obstacleGrid.length;
		int c = obstacleGrid[0].length;

		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		obstacleGrid[0][0] = 1;

		for (int i = 1; i < r; i++) {
			obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1
					: 0;
		}

		for (int i = 1; i < c; i++) {
			obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1
					: 0;
		}

		for (int i = 1; i < r; i++) {

			for (int j = 1; j < c; j++) {

				if (obstacleGrid[i][j] == 0) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j]
							+ obstacleGrid[i][j - 1];
				} else {
					obstacleGrid[i][j] = 0;
				}

			}

		}

		return obstacleGrid[r - 1][c - 1];
	}
}
