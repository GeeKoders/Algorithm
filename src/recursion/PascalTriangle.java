package recursion;

public class PascalTriangle {

	public static void main(String[] args) {

		PascalTriangle pascalTriangle = new PascalTriangle() ;
		int result = pascalTriangle.f(5, 4) ;
		System.out.println(result);
		
	}
	
	public int f(int row, int col){
		
		// edge case
		if(row < 0 || col < 0){
			return 0 ;
		}
	
		if(col > row){
			return 0 ;
		}
		
		if(col == 1 || col == row){
			return 1 ;
		}else{
			return f(row - 1, col - 1) + f(row - 1, col) ;
		}
	}

}
