package Interview.Google.Array;

public class MultiplyStrings {

	public static void main(String[] args) {
		MultiplyStrings solve = new MultiplyStrings() ;
//		solve.multiply("20", "5") ;
		solve.multiply("9173", "0") ;
	}
	
	/*
	 * Multiply Strings
	 * 
	 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3051/
	 * 
	 * discuss: https://leetcode.com/explore/interview/card/google/59/array-and-strings/3051/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
	 * 
	 * reference: 
	 * 
	 * https://www.youtube.com/watch?v=CnEFY5Y3Z68&ab_channel=AmellPeralta
	 * 
	 * Your runtime beats 22.20 % of java submissions.
	 * Your memory usage beats 7.73 % of java submissions.
	 * 
	 */
	public String multiply(String num1, String num2) {

		int m = num1.length();
		int n = num2.length();

		int[] pos = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {

				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int sum = pos[i + j + 1] + mul;
				pos[i + j] += sum / 10;
				pos[i + j + 1] = sum % 10;

			}
		}

		StringBuilder sb = new StringBuilder();
		for (int val : pos) {

			// first index should get rid of
//			System.out.println("val:" + val);
			if ( !(sb.length() == 0 && val == 0)) {
				System.out.println("val:" + val);
				sb.append(val);
			}

		}
		System.out.println("sb:" + sb.toString());
		return sb.length() == 0 ? "0" : sb.toString();

	}
}
