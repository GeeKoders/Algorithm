package Tag.DP;

public class CoinChaneII {

	/*
	 * 518. Coin Change 2 (Medium)
	 * 
	 * https://leetcode.com/problems/coin-change-2/
	 * 
	 * solution: https://leetcode.com/problems/coin-change-2/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=KzkQMXpWSuA&ab_channel=happygirlzt
	 * 
	 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Coin Change 2.
	 * Memory Usage: 36.4 MB, less than 80.09% of Java online submissions for Coin Change 2.
	 * 
	 */
	public int change(int amount, int[] coins) {

		int[] dp = new int[amount + 1];

		dp[0] = 1;

		for (int coin : coins) {

			for (int i = coin; i <= amount; i++) {
				dp[i] += dp[i - coin];
			}

		}

		return dp[amount];

	}

}
