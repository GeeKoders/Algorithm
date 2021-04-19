package Tag.DP;

public class CountSquareSubmatriceswithAllOnes {
	
	/*
	 * 1277. Count Square Submatrices with All Ones (Medium)
	 * 
	 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
	 * 
	 * reference: https://www.youtube.com/watch?v=GfGsM2G1tP8&ab_channel=happygirlzt
	 * 
	 * Runtime: 5 ms, faster than 93.56% of Java online submissions for Count Square Submatrices with All Ones.
	 * Memory Usage: 47.6 MB, less than 93.69% of Java online submissions for Count Square Submatrices with All Ones.
	 * 
	 */
	public int countSquares(int[][] matrix) {

		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;

		int res = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (matrix[i][j] == 0)
					continue;
				if (i == 0 || j == 0) {
					res++;
					continue;
				}

				int min = Math.min(matrix[i - 1][j - 1],
						Math.min(matrix[i][j - 1], matrix[i - 1][j]));

				matrix[i][j] += min;
				res += matrix[i][j];

			}
		}

		return res;

	}
}
