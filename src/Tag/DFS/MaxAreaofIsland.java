package Tag.DFS;

public class MaxAreaofIsland {

	/*
	 * 695. Max Area of Island (Medium) 
	 * 
	 * https://leetcode.com/problems/max-area-of-island/
	 * 
	 * solution: https://leetcode.com/problems/max-area-of-island/solution/
	 * 
	 * Runtime: 5 ms, faster than 20.17% of Java online submissions for Max Area of Island.
	 * Memory Usage: 44.7 MB, less than 6.57% of Java online submissions for Max Area of Island.
	 * 
	 * Time complexity: O(R*C)
	 * Space complexity: O(R*C)
	 * 
	 */
	public int maxAreaOfIsland(int[][] grid) {

		int[][] visited = new int[grid.length][grid[0].length];
		int res = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == 1) {
					res = Math.max(res, dfs(grid, visited, i, j));
				}

			}

		}

		return res;

	}

	private int dfs(int[][] grid, int[][] visited, int i, int j) {

		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1
				|| grid[i][j] == 0 || visited[i][j] == 1)
			return 0;

		visited[i][j] = 1;
		return 1 + dfs(grid, visited, i + 1, j) + dfs(grid, visited, i - 1, j)
				+ dfs(grid, visited, i, j + 1) + dfs(grid, visited, i, j - 1);

	}
}
