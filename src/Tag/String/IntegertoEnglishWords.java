package Tag.String;

public class IntegertoEnglishWords {
	
	
	/*
	 * 273. Integer to English Words (Hard)
	 * 
	 * https://leetcode.com/problems/integer-to-english-words/
	 * 
	 * solution: https://leetcode.com/problems/integer-to-english-words/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=qwotMTggot0&ab_channel=happygirlzt
	 * 
	 * Runtime: 2 ms, faster than 94.84% of Java online submissions for Integer to English Words.
	 * Memory Usage: 37.4 MB, less than 87.43% of Java online submissions for Integer to English Words.
	 * 
	 * 
	 */
	private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

	private final String[] LESS_THAN_TWENTY = { "", "One", "Two", "Three",
			"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Nineteen" };

	private final String[] TENS = { "", "", "Twenty", "Thirty", "Forty",
			"Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	public String numberToWords(int num) {

		if (num == 0)
			return "Zero";

		StringBuilder sb = new StringBuilder();
		int index = 0;

		while (num > 0) {

			if (num % 1000 != 0) {
				StringBuilder tmp = new StringBuilder();
				helper(tmp, num % 1000);
				sb.insert(0, tmp.append(THOUSANDS[index]).append(" "));
			}

			index++;
			num = num / 1000;
		}

		return sb.toString().trim();

	}

	private void helper(StringBuilder sb, int num) {
		if (num == 0) {
			return;
		} else if (num < 20) {
			sb.append(LESS_THAN_TWENTY[num]).append(" ");
		} else if (num < 100) {
			sb.append(TENS[num / 10]).append(" ");
			helper(sb, num % 10);
		} else {

			sb.append(LESS_THAN_TWENTY[num / 100]).append(" Hundred ");
			helper(sb, num % 100);
		}

	}
}
