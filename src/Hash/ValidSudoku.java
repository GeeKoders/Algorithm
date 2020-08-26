package Hash;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	/*
	 * https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1126/
	 * 
	 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
	 * 1.Each row must contain the digits 1-9 without repetition.
	 * 2.Each column must contain the digits 1-9 without repetition.
	 * 3.Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
	 * 
	 * Note:
	 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
	 * Only the filled cells need to be validated according to the mentioned rules.
	 * The given board contain only digits 1-9 and the character '.'.
	 * The given board size is always 9x9.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//reference: https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1126/discuss/15450/Shared-my-concise-Java-code
	public boolean isValidSudoku(char[][] board) {
		for(int i = 0; i<9; i++) {
	        Set<Character> rows = new HashSet<>();
	        Set<Character> cols = new HashSet<>();
	        Set<Character> cube = new HashSet<>();
	        for (int j = 0; j < 9;j++) {
	            if(board[i][j]!='.' && !rows.add(board[i][j]))
	                return false;
	            if(board[j][i]!='.' && !cols.add(board[j][i]))
	                return false;
	            int cubeRow = 3*(i/3) + j/3;
	            int cubeCol = 3*(i%3) + j%3;
	            if(board[cubeRow][cubeCol]!='.' && !cube.add(board[cubeRow][cubeCol]))
	                return false;
	        }
	    }
	    return true;
	}
}
