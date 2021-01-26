package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {

	/*
	 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
	 * solution: https://leetcode.com/articles/diagonal-traverse/
	 * 
	 * 
	 * 
	 * Given a matrix of M x N elements (M rows, N columns), return all elements
	 * of the matrix in diagonal order as shown in the below image.
	 * 
	 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
	 * 
	 * Output: [1,2,4,7,5,3,6,8,9]
	 * 
	 * Note: The total number of elements of the given matrix will not exceed
	 * 10,000.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findDiagonalOrder(int[][] matrix) {

		// Check for empty matrices
		if (matrix == null || matrix.length == 0) {
			return new int[0];
		}

		// Variables to track the size of the matrix
		int N = matrix.length;
		int M = matrix[0].length;

		// The two arrays as explained in the algorithm
		int[] result = new int[N * M];
		int k = 0;
		ArrayList<Integer> intermediate = new ArrayList<Integer>();

		// We have to go over all the elements in the first
		// row and the last column to cover all possible diagonals
		for (int d = 0; d < N + M - 1; d++) {

			// Clear the intermediate array every time we start
			// to process another diagonal
			intermediate.clear();

			// We need to figure out the "head" of this diagonal
			// The elements in the first row and the last column
			// are the respective heads.
			int r = d < M ? 0 : d - M + 1;
			int c = d < M ? d : M - 1;

			// Iterate until one of the indices goes out of scope
			// Take note of the index math to go down the diagonal
			while (r < N && c > -1) {

				intermediate.add(matrix[r][c]);
				++r;
				--c;
			}

			// Reverse even numbered diagonals. The
			// article says we have to reverse odd
			// numbered articles but here, the numbering
			// is starting from 0 :P
			if (d % 2 == 0) {
				Collections.reverse(intermediate);
			}

			for (int i = 0; i < intermediate.size(); i++) {
				result[k++] = intermediate.get(i);
			}
		}
		return result;
	}

	public int[] findDiagonalOrder2(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return new int[] {};

		int row = 0, col = 0;
		int m = matrix.length, n = matrix[0].length;
		int[] result = new int[m * n];

		for (int i = 0; i < result.length; i++) {
			result[i] = matrix[row][col];
			if ((row + col) % 2 == 0) { // going up remember very good
				if (col == n - 1)
					row++;
				else if (row == 0)
					col++;
				else {
					row--;
					col++;
				}
			} else { // going down
				if (row == m - 1)
					col++;
				else if (col == 0)
					row++;
				else {
					row++;
					col--;
				}
			}
		}

		return result;
	}

	/*
	 * 
	 * Space Complexity: O(1) since we don't make use of any additional data
	 * structure. Note that the space occupied by the output array doesn't count
	 * towards the space complexity since that is a requirement of the problem
	 * itself. Space complexity comprises any additional space that we may have
	 * used to get to build the final array. For the previous solution, it was
	 * the intermediate arrays. In this solution, we don't have any additional
	 * space apart from a couple of variables.
	 * 
	 * 
	 * ask if space occupied by output should be counted or ignored
	 */

}