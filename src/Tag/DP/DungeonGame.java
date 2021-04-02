package Tag.DP;

import java.util.Arrays;

public class DungeonGame {
	
	/*
	 * 174. Dungeon Game (Hard)
	 * 
	 * https://leetcode.com/problems/dungeon-game/
	 * 
	 * solution: https://leetcode.com/problems/dungeon-game/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=h7mrQrpti-k&ab_channel=happygirlzt
	 * 
	 * Runtime: 1 ms, faster than 91.88% of Java online submissions for Dungeon Game.
	 * Memory Usage: 39 MB, less than 20.97% of Java online submissions for Dungeon Game.
	 * 
	 * Time complexity: O(M*N)
	 * Space complexity: O(M*N)
	 * 
	 */
	public int calculateMinimumHP(int[][] dungeon) {

		int m = dungeon.length, n = dungeon[0].length;

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		dp[m - 1][n] = 1;
		dp[m][m - 1] = 1;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int minHp = Math.min(dp[i + 1][j], dp[i][j + 1])
						- dungeon[i][j];

				if (minHp < 1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = minHp;
				}

			}

		}

		return dp[0][0];

	}
}
