package Tag.Other;

public class ReverseInteger {

	
	/*
	 * 7. Reverse Integer (Easy)
	 * 
	 * https://leetcode.com/problems/reverse-integer/
	 * 
	 * solution: https://leetcode.com/problems/reverse-integer/solution/
	 * 
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
	 * Memory Usage: 36.3 MB, less than 46.71% of Java online submissions for Reverse Integer.
	 * 
	 * Time complexity:O(log(x))
	 * Space complexity: O(1)
	 * 
	 */
	public int reverse(int x) {

		long res = 0;

		while (x != 0) {
			res = res * 10 + x % 10;
			x = x / 10;
		}

		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
			return 0;

		return (int) res;
	}
}
