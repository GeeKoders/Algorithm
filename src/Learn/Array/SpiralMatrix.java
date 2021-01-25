package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	
	/*
	 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
	 * solution: https://leetcode.com/articles/spiral-matrix/
	 * reference: https://www.youtube.com/watch?v=NO1zLdOwgR0
	 * 
	 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	 * 
	 * Example 1:
	 * Input:
	 * [
 		[ 1, 2, 3 ],
 		[ 4, 5, 6 ],
 		[ 7, 8, 9 ]
	   ]
	 * Output: [1,2,3,6,9,8,7,4,5]
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>() ;
        
        if(matrix.length == 0) return list ;
        
        int row = matrix.length ; 
        int col = matrix[0].length ;
        
        int rowBegin = 0 ;
        int rowEnd = row - 1 ; 
        int columnBegin = 0 ; 
        int columnEnd = col - 1 ;
        
        while(rowBegin <= rowEnd && columnBegin <= columnEnd){
            
            for(int i=columnBegin; i<=columnEnd; i++){
                list.add(matrix[rowBegin][i]) ;
            }
            
            rowBegin ++ ;
            
            for(int i=rowBegin; i<=rowEnd; i++){
                list.add(matrix[i][columnEnd]) ;
            }
            columnEnd -- ;
            
            if(rowBegin <= rowEnd){
                for(int i=columnEnd; i>=columnBegin; i--){
                    list.add(matrix[rowEnd][i]) ;
                }    
            }
            
            
            rowEnd-- ;
            if(columnBegin <= columnEnd){
                for(int i=rowEnd; i>=rowBegin; i--){
                    list.add(matrix[i][columnBegin]) ;
                }    
            }
            
             columnBegin ++ ;
            
        }
        
        return list ;
        
    }

}
