package recursionII;

import java.util.ArrayList;
import java.util.List;

public class QueensProblemIII {

	public static void main(String[] args) {
		QueensProblemII queensProblemII = new QueensProblemII() ;
		List<List<Integer>> result = queensProblemII.nQueens(5) ;
		System.out.println(result.size());
	}
	
	public int totalNQueens(int n) {
        
        List<List<Integer>> result = nQueens(n) ;
        
        return result.size() ;
        
    }
	
	public List<List<Integer>> nQueens(int n){
		List<List<Integer>> result = new ArrayList<>() ;
		solveNQueens(n, 0, new ArrayList<Integer>(), result) ;
		return result ;
	}

	private void solveNQueens(int n, int col,
			List<Integer> colPlacements, List<List<Integer>> result) {
		
		if(col == n){
			result.add(new ArrayList<>(colPlacements)) ;
		}else{
			for(int row=0; row<n; row++){
				colPlacements.add(row) ;
				
				if(isValid(colPlacements)){
					solveNQueens(n, col+1, colPlacements, result) ;
				}
				
				colPlacements.remove(colPlacements.size() - 1) ;
				
			}
		}
	}
	
	private boolean isValid(List<Integer> colPlacements){
		
		int colId = colPlacements.size() - 1 ;
		
		for(int i=0; i<colId; i++){
			
			int diff = Math.abs(colPlacements.get(i) - colPlacements.get(colId)) ;
			
			if(diff == 0 || diff == colId - i){
				return false ;
			}
			
		}
		
		return true ;
		
	}

}
