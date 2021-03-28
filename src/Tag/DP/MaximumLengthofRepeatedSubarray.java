package Tag.DP;

public class MaximumLengthofRepeatedSubarray {
	
	/*
	 * 718. Maximum Length of Repeated Subarray (Medium)
	 * 
	 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
	 * 
	 * solution: https://leetcode.com/problems/maximum-length-of-repeated-subarray/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=1qHRZpvYy-o&ab_channel=%E4%B8%83%E4%BA%BA%E5%B0%8F%E7%BB%84Pleasewatchin2xSPEED
	 * 
	 * Runtime: 33 ms, faster than 98.91% of Java online submissions for Maximum Length of Repeated Subarray.
	 * Memory Usage: 47.9 MB, less than 61.49% of Java online submissions for Maximum Length of Repeated Subarray.
	 * 
	 * Time complexity: O(M*N)
	 * Space complexity: O(M*N)
	 * 
	 */
	public int findLength(int[] A, int[] B) {

		int lenA = A.length;
		int lenB = B.length;

		int[][] dp = new int[lenA + 1][lenB + 1];

		int res = 0;

		for (int i = 0; i < lenA; i++) {

			for (int j = 0; j < lenB; j++) {

				if (A[i] == B[j]) {

					dp[i + 1][j + 1] = 1 + dp[i][j];

					res = Math.max(res, dp[i + 1][j + 1]);

				}

			}

		}

		return res;

	}
}
