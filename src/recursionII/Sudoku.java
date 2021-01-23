package recursionII;

public class Sudoku {

	
	public static void main(String[] args) {
		int sudokuTable[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		Sudoku sudoku = new Sudoku(sudokuTable);
		sudoku.solveSudokuProblem();
	}
	
	
	private int boardSize = 9;
	private int minNumber = 1;
	private int maxNumber = 9;
	private int boxSize = 3;

	private int[][] sudokuTable;

	public Sudoku(int[][] sudokuTable) {
		this.sudokuTable = sudokuTable;
	}
	
	

	public void solveSudokuProblem() {

		if (solve(0, 0)) {
			showResult();
		} else {
			System.out.println("No feasible solution found...");
		}
	}

	private boolean solve(int rowIndex, int columnIndex) {


		if (rowIndex == boardSize  && ++columnIndex == boardSize) {
			return true;
		}


		if (rowIndex == boardSize) {
			rowIndex = 0;
		}

		if (sudokuTable[rowIndex][columnIndex] != 0) { // skip filled cells
			return solve(rowIndex + 1, columnIndex);
		}

		for (int numbers = minNumber; numbers <= maxNumber; ++numbers) {

			if (valid(rowIndex, columnIndex, numbers)) {

				sudokuTable[rowIndex][columnIndex] = numbers;

				if (solve(rowIndex + 1, columnIndex))
					return true;
			}
		}

		sudokuTable[rowIndex][columnIndex] = 0; // backtracking !!!

		return false;
	}

	private boolean valid(int rowIndex, int columnIndex, int actualNumber) {

		for (int i = 0; i < boardSize; ++i)
			// check the rows
			if (sudokuTable[i][columnIndex] == actualNumber)
				return false;

		for (int k = 0; k < boardSize; ++k)
			if (sudokuTable[rowIndex][k] == actualNumber)
				return false;

		// if the given number is already in the box: the number cannot be part
		// of the solution
		int boxRowOffset = (rowIndex / 3) * boxSize;
		int boxColumnOffset = (columnIndex / 3) * boxSize;

		for (int i = 0; i < boxSize; ++i)
			for (int j = 0; j < boxSize; ++j)
				if (actualNumber == sudokuTable[boxRowOffset + i][boxColumnOffset
						+ j])
					return false;

		return true;
	}

	private void showResult() {

		for (int i = 0; i < boardSize; ++i) {

			if (i % 3 == 0)
				System.out.println(" ");

			for (int j = 0; j < boardSize; ++j) {

				if (j % 3 == 0)
					System.out.print(" ");
				System.out.print(sudokuTable[i][j] + " ");
			}

			System.out.println(" ");
		}
	}


	
	
	
}
