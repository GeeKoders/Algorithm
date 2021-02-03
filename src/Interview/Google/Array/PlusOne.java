package Interview.Google.Array;

public class PlusOne {
	
	
	/*
	 * 66. Plus One (Easy)
	 * 
	 * https://leetcode.com/problems/plus-one/
	 * 
	 * solution: https://leetcode.com/problems/plus-one/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
	 * Memory Usage: 38.9 MB, less than 12.23% of Java online submissions for Plus One.
	 * 
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public int[] plusOne(int[] digits) {

		for (int i = digits.length - 1; i >= 0; i--) {

			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i]++;
				return digits;
			}

		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;

		return res;
	}
}
