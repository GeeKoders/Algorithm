package Tag.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinaGridwithObstaclesElimination {
	
	
	
	/*
	 * 1293. Shortest Path in a Grid with Obstacles Elimination (Hard)
	 * 
	 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
	 * 
	 * reference: https://www.youtube.com/watch?v=yW0AQReDOgQ&ab_channel=happygirlzt
	 * 
	 * Runtime: 7 ms, faster than 91.01% of Java online submissions for Shortest Path in a Grid with Obstacles Elimination.
	 * Memory Usage: 38.4 MB, less than 89.21% of Java online submissions for Shortest Path in a Grid with Obstacles Elimination.
	 * 
	 * 
	 */
	private static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int shortestPath(int[][] grid, int k) {

		int m = grid.length, n = grid[0].length;
		int[][] seen = new int[m][n];

		for (int i = 0; i < m; i++) {
			Arrays.fill(seen[i], Integer.MAX_VALUE);
		}

		seen[0][0] = 0;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0 });
		int steps = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int row = cur[0];
				int col = cur[1];

				if (row == m - 1 && col == n - 1) {
					return steps;
				}

				for (int[] d : dirs) {

					int r = d[0] + row, c = d[1] + col;

					if (r >= 0 && r < m && c >= 0 && c < n) {
						int o = cur[2] + grid[r][c];
						if (o >= seen[r][c] || o > k)
							continue;

						seen[r][c] = 0;
						q.offer(new int[] { r, c, o });

					}

				}

			}

			steps++;
		}

		return -1;
	}
}
