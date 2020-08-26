package Hash;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

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
