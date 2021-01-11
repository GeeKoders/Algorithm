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
	 * Time complexity: O(n*m)
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
	
	/*
	 * 
	 *  128 / 128 test cases passed.
		Status: Accepted
		Runtime: 6 ms (Your runtime beats 36.97 % of java submissions.)
		Memory Usage: 51.7 MB
	 * 
	 * 
	 * Time complexity: O(n + m)
	 * 
	 */
	public boolean searchMatrix2(int [][] matrix, int target){
		
		int row = matrix.length - 1 ;
		int col = 0 ;
		
		
		while(row >=0 && col <= matrix[0].length - 1){
			
			if(matrix[row][col] > target){
				row-- ;
			}else if(matrix[row][col] < target){
				col++ ;
			}else{
				return true ;
			}
		}
		
		return false ;
		
		
	}

}
