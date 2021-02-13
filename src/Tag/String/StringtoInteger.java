package Tag.String;

public class StringtoInteger {

	
	/*
	 * 8. String to Integer (atoi) (Medium)
	 * 
	 * https://leetcode.com/problems/string-to-integer-atoi/
	 * 
	 * solution: https://leetcode.com/problems/string-to-integer-atoi/solution/
	 * 
	 * Runtime: 2 ms, faster than 62.92% of Java online submissions for String to Integer (atoi).
	 * Memory Usage: 39.2 MB, less than 43.77% of Java online submissions for String to Integer (atoi).
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public int myAtoi(String s) {

		if (s.length() == 0)
			return 0;

		int i = 0;
		int sign = 1;
		int result = 0;

		// Discard whitespaces in the beginning
		while (i < s.length() && s.charAt(i) == ' ')
			i++;

		// Check if optional sign if it exists
		if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
			sign = (s.charAt(i++) == '-') ? -1 : 1;

		// Build the result and check for overflow/underflow condition
		while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			if (result > Integer.MAX_VALUE / 10
					|| (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + (s.charAt(i) - '0');
			i++;
		}
		return result * sign;

	}

}
