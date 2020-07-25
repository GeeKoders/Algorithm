package recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

	
	/*
	 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
	 * 
	 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
	 * Note that the row index starts from 0.
	 * 
	 * Input: 3
	 * Output: [1,3,3,1]
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// time limit exceeded
	public List<Integer> getRow(int rowIndex) {

		List<Integer> list = new ArrayList<>();

		for (int col = 1; col <= rowIndex + 1; col++) {
			list.add(f(rowIndex + 1, col));
		}

		return list;
	}

	public int f(int row, int col) {

		// edge case
		if (row < 0 || col < 0) {
			return 0;
		}

		if (col > row) {
			return 0;
		}

		if (col == 1 || col == row) {
			return 1;
		} else {
			return f(row - 1, col - 1) + f(row - 1, col);
		}
	}

}
