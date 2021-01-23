package recursionII;

public class SudokuSolver {

	
	/*
	 * Sudoku Solver (Hard)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2796/
	 * 
	 * solution: https://leetcode.com/problems/sudoku-solver/solution/
	 * 
	 * reference: https://www.javatpoint.com/java-int-to-char
	 * 
	 * 
		6 / 6 test cases passed.
		Status: Accepted
		Runtime: 6 ms (Your runtime beats 77.17 % of java submissions.)
		Memory Usage: 36.6 MB (Your memory usage beats 45.35 % of java submissions.)
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	private int boardSize = 9;
	private int minNumber = 1;
	private int maxNumber = 9;
	private int boxSize = 3;

	private char[][] board;

	public void solveSudoku(char[][] board) {
		this.board = board;
		if (solve(0, 0)) {

		} else {
			System.out.println("No feasible solution found...");
		}

	}

	private boolean solve(int rowIndex, int columnIndex) {

		if (rowIndex == boardSize && ++columnIndex == boardSize) {
			return true;
		}

		if (rowIndex == boardSize) {
			rowIndex = 0;
		}
		
		if (board[rowIndex][columnIndex] != '.') { // skip filled cells
			return solve(rowIndex + 1, columnIndex);
		}

		for (int numbers = minNumber; numbers <= maxNumber; ++numbers) {

			if (valid(rowIndex, columnIndex, numbers)) {

				board[rowIndex][columnIndex] = (char) (numbers + '0');

				if (solve(rowIndex + 1, columnIndex))
					return true;

				board[rowIndex][columnIndex] = '.'; // backtracking !!!
			}
		}

		return false;
	}

	private boolean valid(int rowIndex, int columnIndex, int actualNumber) {

		for (int i = 0; i < boardSize; ++i)
			// check the rows
			if (board[i][columnIndex] == (char) (actualNumber + '0'))
				return false;

		for (int k = 0; k < boardSize; ++k)
			if (board[rowIndex][k] == (char) (actualNumber + '0'))
				return false;

		int boxRowOffset = (rowIndex / 3) * boxSize;
		int boxColumnOffset = (columnIndex / 3) * boxSize;

		for (int i = 0; i < boxSize; ++i)
			for (int j = 0; j < boxSize; ++j)
				if (board[boxRowOffset + i][boxColumnOffset + j] == (char) (actualNumber + '0'))
					return false;

		return true;
	}
}
