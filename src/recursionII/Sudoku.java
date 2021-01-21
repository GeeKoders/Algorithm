package recursionII;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Sudoku {

	public static void main(String[] args) {
		int sudokuTable[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		
		Sudoku sudoku = new Sudoku() ;
		
		sudoku.showResult(sudokuTable);
	}
	
	private void showResult(int [][] sudokuTable){
		
		for(int i=0 ; i<sudokuTable.length; i++){
			
			if(i % 3 == 0){
				System.out.println(" ");
			}
			
			for(int j=0; j<sudokuTable[0].length; j++){
				
				if(j % 3 == 0){
					System.out.print(" ");
				}
				
				System.out.print(sudokuTable[i][j]);
				
			}
			
			System.out.println();
			
			
		}
		
		
	}
	
	
	
	
	
}
