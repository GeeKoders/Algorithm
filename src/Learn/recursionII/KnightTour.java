package recursionII;


public class KnightTour {

	private int boardSize = 8 ;
	private int [][]solutionMatrix ;
	private int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2} ;
	private int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1} ;
	
	public static void main(String[] args) {
		
		KnightTour knightTour = new KnightTour() ;
		knightTour.solveTour(); 
	}
	
	public KnightTour() {

		this.solutionMatrix = new int[boardSize][boardSize] ;
		
		for(int i=0; i<solutionMatrix.length; i++){
			for(int j=0; j<solutionMatrix[0].length; j++){
				solutionMatrix[i][j] = Integer.MIN_VALUE ;
			}
		}
		
	}
	
	private void solveTour(){
		
		solutionMatrix[0][0] = 1 ;
		
		if(solve(2, 0, 0)){
			printSoltuion() ;
		}else{
			System.out.println("No feasible solution...");
		}
		
	}
	
	private boolean solve(int stepCount, int x, int y){
		
		if(stepCount == boardSize * boardSize + 1) return true ;
		
		for(int i=0; i<xMoves.length; i++){
			
			int nextX = x + xMoves[i] ;
			int nextY = y + yMoves[i] ;
			
			if(isStepValid(nextX, nextY)){
				
				solutionMatrix[nextX][nextY] = stepCount ;
				
				if(solve(stepCount + 1, nextX, nextY)){
					return true ;
				}
				
				solutionMatrix[nextX][nextY] = Integer.MIN_VALUE ;
				
			}
			
		}
		
		return false ;
		
	}
	
	private boolean isStepValid(int x, int y){
	
		if(x<0 || y<0 || x>solutionMatrix.length - 1 
				|| y>solutionMatrix[0].length - 1) return false ;
		
		if(solutionMatrix[x][y] != Integer.MIN_VALUE){
			return false ;
		}
		
		return true ;
		
	}
	
	
	
	
	private void printSoltuion(){
		
		for(int i=0; i<solutionMatrix.length; i++){
			for(int j=0; j<solutionMatrix[0].length; j++){
				System.out.print(solutionMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
}
