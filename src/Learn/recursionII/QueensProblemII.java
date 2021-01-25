package recursionII;

import java.util.ArrayList;
import java.util.List;

public class QueensProblemII {

	/*
	 * https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2804/
	 * 
	 * solution: https://leetcode.com/problems/n-queens-ii/solution/
	 * 
	 * youtube: https://www.youtube.com/watch?v=wGbuCyNpxIg&ab_channel=BackToBackSWE
	 * 
	 *  9 / 9 test cases passed.
		Status: Accepted
		Runtime: 4 ms (Your runtime beats 31.51 % of java submissions.)
		Memory Usage: 35.7 MB (Your memory usage beats 78.09 % of java submissions.)
	 * 
	 */
	public static void main(String[] args) {
		QueensProblemII queensProblemII = new QueensProblemII() ;
		List<List<Integer>> result = queensProblemII.nQueens(5) ;
		System.out.println(result.size());
	}
	
	public List<List<Integer>> nQueens(int n){
		List<List<Integer>> result = new ArrayList<>() ;
		solveNQueens(n, 0, new ArrayList<Integer>(), result) ;
		return result ;
	}

	private void solveNQueens(int n, int row,
			List<Integer> colPlacements, List<List<Integer>> result) {
		
		if(row == n){
			result.add(new ArrayList<>(colPlacements)) ;
		}else{
			for(int col=0; col<n; col++){
				colPlacements.add(col) ;
				
				if(isValid(colPlacements)){
					solveNQueens(n, row+1, colPlacements, result) ;
				}
				
				colPlacements.remove(colPlacements.size() - 1) ;
				
			}
		}
	}
	
	private boolean isValid(List<Integer> colPlacements){
		
		int rowId = colPlacements.size() - 1 ;
		
		for(int i=0; i<rowId; i++){
			
			int diff = Math.abs(colPlacements.get(i) - colPlacements.get(rowId)) ;
			
			if(diff == 0 || diff == rowId - i){
				return false ;
			}
			
		}
		
		return true ;
		
	}
}
