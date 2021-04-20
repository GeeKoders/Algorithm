package Tag.Other;

public class DivideTwoIntegers {
	
	/*
	 * 29. Divide Two Integers (Medium)
	 * 
	 * https://leetcode.com/problems/divide-two-integers/
	 * 
	 * solution: https://leetcode.com/problems/divide-two-integers/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=S9huMzNzR4M&ab_channel=happygirlzt
	 * 
	 * Runtime: 1 ms, faster than 99.97% of Java online submissions for Divide Two Integers.
	 * Memory Usage: 36 MB, less than 58.04% of Java online submissions for Divide Two Integers.
	 * 
	 */
	public int divide(int dividend, int divisor) {

		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		boolean isNegative = (dividend > 0 && divisor < 0)
				|| (dividend < 0 && divisor > 0);

		int res = 0;

		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);

		int shift = 31;

		while (a >= b) {

			while (a < b << shift) {
				shift--;
			}

			a -= b << shift;
			res += 1 << shift;

		}

		return isNegative ? -res : res;

	}
}
