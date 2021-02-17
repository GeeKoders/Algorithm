package Tag.String;

public class IntegertoRoman {
	
	/*
	 * 12. Integer to Roman (Medium)
	 * 
	 * https://leetcode.com/problems/integer-to-roman/
	 * 
	 * solution: https://leetcode.com/problems/integer-to-roman/solution/
	 * 
	 * Runtime: 3 ms, faster than 100.00% of Java online submissions for Integer to Roman.
	 * Memory Usage: 38.5 MB, less than 78.11% of Java online submissions for Integer to Roman.
	 * 
	 * Time complexity: O(1)
	 * Space complexity: O(1)
	 * 
	 */
	public String intToRoman(int num) {

		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < values.length && num >= 0; i++) {

			while (values[i] <= num) {

				num -= values[i];
				sb.append(symbols[i]);

			}

		}

		return sb.toString();

	}
}
