package Tag.DP;

import java.util.Arrays;

public class PalindromePartitioningII {
	
	/*
	 * 132. Palindrome Partitioning II (Hard)
	 * 
	 * https://leetcode.com/problems/palindrome-partitioning-ii/
	 * 
	 * reference: https://www.youtube.com/watch?v=3jENt4DdXac&ab_channel=happygirlzt
	 * 
	 * Runtime: 11 ms, faster than 71.30% of Java online submissions for Palindrome Partitioning II.
	 * Memory Usage: 40.4 MB, less than 33.66% of Java online submissions for Palindrome Partitioning II.
	 * 
	 */
	public int minCut(String s) {
		int n = s.length();
		boolean[][] isPal = new boolean[n + 1][n + 1];
		computeAllPals(isPal, s.toCharArray());

		int[] minPals = new int[n + 2];
		Arrays.fill(minPals, Integer.MAX_VALUE);
		minPals[n + 1] = 0;

		for (int k = n; k >= 1; k--) {
			for (int l = k; l <= n; l++) {
				if (isPal[k][l]) {
					minPals[k] = Math.min(minPals[k], 1 + minPals[l + 1]);
				}
			}
		}

		return minPals[1] - 1;
	}

	private void computeAllPals(boolean[][] isPal, char[] A) {
		int n = A.length;
		for (int i = n; i >= 1; i--) {
			isPal[i][i - 1] = true;
			isPal[i][i] = true;

			for (int j = i + 1; j <= n; j++) {
				if (A[i - 1] == A[j - 1]) {
					isPal[i][j] = isPal[i + 1][j - 1];
				} else {
					isPal[i][j] = false;
				}
			}
		}
	}
}
