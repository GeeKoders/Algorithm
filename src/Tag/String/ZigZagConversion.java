package Tag.String;

public class ZigZagConversion {

	
	/*
	 * 6. ZigZag Conversion (Medium)
	 * 
	 * https://leetcode.com/problems/zigzag-conversion/
	 * 
	 * solution: https://leetcode.com/problems/zigzag-conversion/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=NfBcHxRe8jo&ab_channel=Cspiration%E5%AE%98%E6%96%B9%E9%A2%91%E9%81%93
	 * 
	 * Runtime: 6 ms, faster than 58.23% of Java online submissions for ZigZag Conversion.
	 * Memory Usage: 39.4 MB, less than 80.84% of Java online submissions for ZigZag Conversion.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public String convert(String s, int numRows) {

		if (numRows <= 1)
			return s;

		StringBuilder[] sb = new StringBuilder[numRows];

		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder("");
		}

		for (int i = 0; i < s.length(); i++) {
			int index = i % (2 * numRows - 2);

			index = index < numRows ? index : 2 * numRows - 2 - index;
			sb[index].append(s.charAt(i));
		}

		for (int i = 1; i < sb.length; i++) {
			sb[0].append(sb[i]);
		}

		return sb[0].toString();

	}

}
