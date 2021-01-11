package recursionII;

public class Searcha2DMatrixII {

	
	/*
	 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/
	 * 
	 * solution: https://leetcode.com/problems/search-a-2d-matrix-ii/solution/
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	/*
	 * Brute Force
	 *  
	 *  Time complexity: O(n*m)
	 */
	public boolean searchMatrix(int[][] matrix, int target) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == target) {
					return true;
				}
			}
		}

		return false;

	}

}
