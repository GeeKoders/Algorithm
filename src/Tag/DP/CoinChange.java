package Tag.DP;

import java.util.Arrays;

public class CoinChange {

	
	/*
	 * 322. Coin Change (Medium)
	 * 
	 * https://leetcode.com/problems/coin-change/
	 * 
	 * solution: https://leetcode.com/problems/coin-change/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=KzkQMXpWSuA&ab_channel=happygirlzt
	 * 
	 * Runtime: 12 ms, faster than 57.15% of Java online submissions for Coin Change.
	 * Memory Usage: 38.4 MB, less than 60.20% of Java online submissions for Coin Change
	 * 
	 */
	public int coinChange(int[] coins, int amount) {

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {

			for (int coin : coins) {
				if (i < coin)
					continue;
				dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
			}

		}

		return dp[amount] == amount + 1 ? -1 : dp[amount];

	}
}
