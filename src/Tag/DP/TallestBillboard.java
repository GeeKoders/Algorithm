package Tag.DP;

public class TallestBillboard {

	
	/*
	 * 956. Tallest Billboard (Hard)
	 * 
	 * https://leetcode.com/problems/tallest-billboard/
	 * 
	 * solution: https://leetcode.com/problems/tallest-billboard/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=pkhBm1XzN6w&ab_channel=happygirlzt
	 * 
	 * Time Limit Exceeded
	 * 
	 */
	int max = 0;

	public int tallestBillboard(int[] rods) {

		int n = rods.length;
		int sum = 0;

		for (int rod : rods) {
			sum += rod;
		}

		helper(rods, n - 1, 0, 0, sum);

		return max;

	}

	private void helper(int[] rods, int index, int left, int right, int remain) {

		if (index < 0) {

			if (left == right && left > max) {
				max = left;
			}

			return;

		}

		if (Math.abs(left - right) > remain || left + right + remain <= 2 * max)
			return;

		helper(rods, index - 1, left + rods[index], right, remain - rods[index]);

		helper(rods, index - 1, left, right + rods[index], remain - rods[index]);

		helper(rods, index - 1, left, right, remain - rods[index]);

	}

}
