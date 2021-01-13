package recursionII;

public class QueensProblem {

	public static void main(String[] args) {
		
		QueensProblem queensProblem = new QueensProblem(8) ;
		queensProblem.solve();
	}
	
	
	private int[][] chessTable ;
	private int numOfQueens ; 
	
	public QueensProblem(int numOfQueens) {
		this.numOfQueens = numOfQueens; 
		chessTable = new int[numOfQueens][numOfQueens] ;
	}
	
	private void solve(){
		
		if(setQueens(0)){
			printQueens();
		}else{
			System.out.println("No feasible solution...");
		}
		
	}
	
	private boolean setQueens(int colIndex){
		
		if(colIndex == numOfQueens) return true ;
		
		for(int rowIndex=0; rowIndex < numOfQueens; rowIndex++){
			
			if(isPlaceValid(rowIndex, colIndex)){
				
				chessTable[rowIndex][colIndex] = 1 ;
				
				if(setQueens(colIndex + 1)){
					return true ;
				}
				//backtracking
				chessTable[rowIndex][colIndex] = 0 ;
				
			}
		}
		
		return false ;
		
	}
	
	private boolean isPlaceValid(int rowIndex, int colIndex){
		
		for(int i=0; i<colIndex; i++){
			if(chessTable[rowIndex][i] == 1){
				return false; 
			}
		}
		
		for(int i=rowIndex, j=colIndex; i>=0&& j>=0; i--,j--){
			if(chessTable[i][j] == 1){
				return false ;
			}
		}
		
		for(int i=rowIndex, j=colIndex; i<chessTable.length&&j>=0; i++, j--){
			if(chessTable[i][j] == 1){
				return false ;
			}
				
		}
		
		return true; 
		
		
	}
	
	private void printQueens(){
		
		for(int i=0;i <chessTable.length; i++){
			for(int j=0; j<chessTable[0].length; j++){
				if(chessTable[i][j] == 1){
					System.out.print(" * ");
				}else{
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
