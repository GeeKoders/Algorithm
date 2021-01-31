package Interview.Google.Pre;

public class LicenseKeyFormatting {

	
	
	/*
	 * https://leetcode.com/explore/interview/card/google/67/sql-2/472/
	 * 
	 * 
	 *  38 / 38 test cases passed.
		Status: Accepted
		Runtime: 9 ms (Your runtime beats 75.97 % of java submissions.)
		Memory Usage: 39.3 MB (Your memory usage beats 66.36 % of java submissions.)
	 * 
	 * Time Complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public String licenseKeyFormatting(String S, int K) {

		StringBuilder sb = new StringBuilder();
		int n = S.length();
		int count = 0;

		for (int i = n - 1; i >= 0; i--) {

			char text = S.charAt(i);

			if (text == '-')
				continue;

			if (count == K) {
				sb.append("-");
				count = 0;
			}

			sb.append(text);
			count++;

		}

		return sb.reverse().toString().toUpperCase();
	}

}
