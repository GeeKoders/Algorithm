package recursionII;


public class HamiltonianCycle {

	public static void main(String[] args) {
		
		int [][] matrix = {
				{0, 1, 1, 1, 0, 0},
				{1, 0, 1, 0, 1, 0}, 
				{1, 1, 1, 1, 0, 1},
				{1, 0, 1, 0, 0, 1},
				{0, 1, 0, 0, 0, 1},
				{0, 1, 1, 1, 1, 1}
		} ;
		
		HamiltonianCycle cycle = new HamiltonianCycle(matrix) ;
		cycle.solve();
	}
	
	private int numOfVertexes ;
	private int [] hamiltonianPath ;
	private int[][] adjacencyMatrix ;
	
	public HamiltonianCycle(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix ;
		this.hamiltonianPath = new int[adjacencyMatrix.length] ;
		this.numOfVertexes = adjacencyMatrix.length ;
		
		this.hamiltonianPath[0] = 0 ;
		
	}
	
	private void solve(){
		
		if(findFeasibleSolution(1)){
			showResult() ;
		}else{
			System.out.println("No feasible solution...");
		}
	}
	
	private boolean findFeasibleSolution(int position){
		if(position == numOfVertexes){
			return true ;
		}
		
		for(int vertexIndex = 1; vertexIndex<numOfVertexes; vertexIndex++){
			
			if(isFeasible(vertexIndex, position)){
				hamiltonianPath[position] = vertexIndex ;
				
				if(findFeasibleSolution(position + 1)){
					return true ;
				}
				
				//backtracking
			}
			
		}
		
		return false ;
		
	}
	
	private boolean isFeasible(int vertexIndex, int actualPosition){
		
		if(adjacencyMatrix[actualPosition - 1][vertexIndex] == 0){
			return false ;
		}
		
		for(int i=0; i<actualPosition; i++){
			if(hamiltonianPath[i] == vertexIndex){
				return false; 
			}
		}
		
		return true ;
	}
	
	private void showResult(){
		System.out.println("Hamiltonian cycle: ");
		
		for(int i=0; i<hamiltonianPath.length; i++){
			System.out.print(hamiltonianPath[i] + " ");
		}
		
		System.out.println(hamiltonianPath[0]);
		
	}
	
	
}
