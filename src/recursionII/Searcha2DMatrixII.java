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
	// solution3
	private int[][] matrix;
    private int target;
    
    public boolean searchMatrix3(int[][] mat, int targ) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`
        matrix = mat;
        target = targ;

        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
    }

    private boolean searchRec(int left, int up, int right, int down) {
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
        // `target` is already larger than the largest element or smaller
        // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = left + (right-left)/2;

        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }

        //go to bottom-left or top-right
        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
    }
    
    /*
     * binary search
     * 
     * soltuion: https://www.youtube.com/watch?v=eT0UqrYuqbg&ab_channel=NickWhite
     *
     */
    public boolean searchMatrix4(int [][] matrix, int target){

    	if(matrix == null || matrix.length == 0) return false ;
    	
    	int rows = matrix.length ;
    	int columns = matrix[0].length ;
    	
    	int left = 0 ;
    	int right = rows * columns - 1 ;
    	
    	while(left <= right){
    		
    		int mid = left + (right - left) / 2 ;
    		int mid_element = matrix[mid/columns][mid*columns] ;
    		if(target == mid_element){
    			return true ;
    		}else if(target < mid_element){
    			right = mid - 1 ;
    		}else if(target > mid_element){
    			left = mid + 1 ;
    		}
    	}
    	
    	return false ;
    	
    	
    }
}
