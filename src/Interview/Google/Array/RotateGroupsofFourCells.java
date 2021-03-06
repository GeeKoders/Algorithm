package Interview.Google.Array;

public class RotateGroupsofFourCells {

	
	/*
	 * 48. Rotate Image (Medium)
	 * 
	 * https://leetcode.com/problems/rotate-image/
	 * 
	 * solution: https://leetcode.com/problems/rotate-image/solution/
	 * 
	 *  21 / 21 test cases passed.
		Status: Accepted
		Runtime: 0 ms
		Memory Usage: 39.5 MB (Your memory usage beats 15.71 % of java submissions.)
	 * 
	 */
	public void rotate(int[][] matrix) {

		int n = matrix.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
				matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}
	
	/*
	 * discuss: https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
	 * 
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
	 * Memory Usage: 39.4 MB, less than 15.71% of Java online submissions for Rotate Image.
	 * 
	 */
	public void rotate2(int[][] matrix) {
	
		int s=0 ; 
		int e = matrix.length - 1 ;
		while(s < e){
			
			int[] temp = matrix[s] ;
			matrix[s] = matrix[e] ;
			matrix[e] = temp ;
			s++; 
			e-- ;
		}
		
		for(int i=0; i<matrix.length; i++){
			for(int j=i+1; j<matrix[i].length; j++){
				int temp = matrix[i][j] ;
				matrix[i][j] = matrix[j][i] ;
				matrix[j][i] = temp ;
			}
		}
		
	}
	/*
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
	 * Memory Usage: 39.8 MB, less than 8.22% of Java online submissions for Rotate Image.
	 *
	 */
	public void rotate3(int[][] matrix) {
		
		int m = matrix.length;
        int n = matrix[0].length;
        
        //Swap all the rows
        for(int start = 0, end = m-1; start < end; start++, end--)
        {
            for(int j = 0; j < n; j++)
            {
                int temp = matrix[start][j];
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = temp;
            }
        }
        
        //Transpose the matrix
        for(int i = 0; i < m; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
	 * 
	 * Memory Usage: 39.4 MB, less than 26.53% of Java online submissions for Rotate Image.
	 * 
	 */
	public void rotate4(int[][] matrix) {
		
		int s=0 ; 
		int e = matrix.length - 1 ;
		while(s < e){
			
			for(int k=0; k<matrix[0].length; k++){
				int temp = matrix[s][k] ;
				matrix[s][k] = matrix[e][k] ;
				matrix[e][k] = temp ;
			}
			
			
			s++; 
			e-- ;
		}
		
		for(int i=0; i<matrix.length; i++){
			for(int j=i+1; j<matrix[0].length; j++){
				int temp = matrix[i][j] ;
				matrix[i][j] = matrix[j][i] ;
				matrix[j][i] = temp ;
			}
		}
		
	}
	
}
