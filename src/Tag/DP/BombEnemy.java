package Tag.DP;

public class BombEnemy {
	
	/*
	 * 361. Bomb Enemy (Medium)
	 * 
	 * https://leetcode.com/problems/bomb-enemy/
	 * 
	 * solution: https://leetcode.com/problems/bomb-enemy/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=WWVQq_OrgQs&ab_channel=happygirlzt
	 * 
	 * Runtime: 4 ms, faster than 99.01% of Java online submissions for Bomb Enemy.
	 * Memory Usage: 42.5 MB, less than 91.70% of Java online submissions for Bomb Enemy.
	 * 
	 * 
	 * Time complexity: O(M*N)
	 * Space complexity: O(M)
	 * 
	 * 
	 */
	public int maxKilledEnemies(char[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length, n = grid[0].length;
		int max = 0;
		int[] cols = new int[n];

		for (int i = 0; i < m; i++) {
			int rows = 0;
			for (int j = 0; j < n; j++) {

				if (grid[i][j] == '0') {

					int total = rows + cols[j];

					for (int k = j + 1; k < n && grid[i][k] != 'W'; k++) {
						if (grid[i][k] == 'E')
							total++;
					}

					for (int k = i + 1; k < m && grid[k][j] != 'W'; k++) {

						if (grid[k][j] == 'E')
							total++;

					}

					max = Math.max(max, total);

				} else if (grid[i][j] == 'W') {
					rows = 0;
					cols[j] = 0;
				} else {
					rows++;
					cols[j]++;
				}

			}

		}

		return max;
	}
}
