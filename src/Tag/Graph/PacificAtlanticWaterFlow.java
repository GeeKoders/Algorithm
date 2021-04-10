package Tag.Graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
	
	/*
	 * 417. Pacific Atlantic Water Flow (Medium)
	 * 
	 * https://leetcode.com/problems/pacific-atlantic-water-flow/
	 * 
	 * solution: https://leetcode.com/problems/pacific-atlantic-water-flow/solution/
	 *
	 * reference: https://www.youtube.com/watch?v=blOc3KlAR2I&ab_channel=happygirlzt
	 * 
	 * Runtime: 3 ms, faster than 96.14% of Java online submissions for Pacific Atlantic Water Flow.
	 * Memory Usage: 39.9 MB, less than 93.31% of Java online submissions for Pacific Atlantic Water Flow.
	 * 
	 * 
	 */
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> res = new ArrayList<>();
		int m = heights.length;
		if (m == 0)
			return res;
		int n = heights[0].length;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];

		// top and bottom

		for (int col = 0; col < n; col++) {

			dfs(heights, 0, col, heights[0][col], pacific);
			dfs(heights, m - 1, col, heights[m - 1][col], atlantic);

		}

		// left and right
		for (int row = 0; row < m; row++) {
			dfs(heights, row, 0, heights[row][0], pacific);
			dfs(heights, row, n - 1, heights[row][n - 1], atlantic);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (pacific[i][j] && atlantic[i][j]) {
					List<Integer> cur = new ArrayList<>();
					cur.add(i);
					cur.add(j);
					res.add(cur);
				}

			}
		}
		return res;
	}

	private void dfs(int[][] heights, int r, int c, int preHeight,
			boolean[][] ocean) {

		if (r > heights.length - 1 || r < 0 || c > heights[0].length - 1
				|| c < 0 || heights[r][c] < preHeight || ocean[r][c])
			return;

		ocean[r][c] = true;
		dfs(heights, r + 1, c, heights[r][c], ocean);
		dfs(heights, r - 1, c, heights[r][c], ocean);
		dfs(heights, r, c + 1, heights[r][c], ocean);
		dfs(heights, r, c - 1, heights[r][c], ocean);

	}
}
