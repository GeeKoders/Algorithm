package recursionII;

public class MazeProblem {

	public static void main(String[] args) {
		
		int mazeTable[][] = new int[][]{
				{1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 0, 1}	
				
		};
		
		MazeProblem mazeProblem = new MazeProblem(mazeTable) ;
		mazeProblem.solveMaze() ;
		
		
	}
	
	private int[][] mazeTable ;
	private int[][] solutionTable ;
	private int mazeSize ;
	
	public MazeProblem(int[][] mazeTable){
		this.mazeTable = mazeTable ;
		this.mazeSize = mazeTable.length ;
		solutionTable = new int[this.mazeSize][this.mazeSize] ;
	}
	
	public void solveMaze(){
		
		if(solve(0, 0)){
			showResult() ;
		}else{
			System.out.println("No feasible solution...");
		}
		
		
	}
	
	private boolean solve(int x, int y){
		
		if(x == mazeSize - 1 && y == mazeSize - 1){
			solutionTable[x][y] = 1 ;
			return true ;
		}
		
		if(isValid(x, y)){
			
			solutionTable[x][y] = 1 ;
			
			if(solve(x+1, y)){
				return true;
			}
			
			if(solve(x, y+1)){
				return true ;
			}
			
			//backtracking
			
			solutionTable[x][y] = 0 ;
			
		}
		
		return false ;
		
	}
	
	private boolean isValid(int x, int y){
		
		if(x<0 || y<0 || x > mazeSize - 1 || y > mazeSize - 1){
			return false ;
		}
		
		if(mazeTable[x][y] != 1){
			return false ;
		}
		
		return true ;
	}
	
	private void showResult(){
		
		for(int i=0; i<mazeTable.length; i++){
			
			for(int j=0; j<mazeTable.length; j++){
				
				if(solutionTable[i][j] == 1){
					System.out.print(" S ");
				}else{
					System.out.print(" - ");
				}
				
			}
			System.out.println();
			
		}
		
	}
	
	
}
