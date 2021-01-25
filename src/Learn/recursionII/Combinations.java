package recursionII;

import java.util.LinkedList;
import java.util.List;

public class Combinations {

	
	/*
	 * 77. Combinations (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798/
	 * 
	 * solution: https://leetcode.com/problems/combinations/solution/
	 * 
	 * 
		27 / 27 test cases passed.
		Status: Accepted (Your runtime beats 72.85 % of java submissions.)
		Runtime: 16 ms (Your memory usage beats 20.57 % of java submissions.)
		Memory Usage: 41.7 MB
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	private List<List<Integer>> result = new LinkedList();
	private int n;
	private int k;

	public List<List<Integer>> combine(int n, int k) {
		this.n = n;
		this.k = k;
		backtrack(1, new LinkedList<Integer>());
		return result;
	}

	public void backtrack(int first, LinkedList<Integer> curr) {
		if (curr.size() == k)
			result.add(new LinkedList(curr));

		for (int i = first; i < n + 1; ++i) {
			// add i into the current combination
			curr.add(i);
			// use next integers to complete the combination
			backtrack(i + 1, curr);
			// backtrack
			curr.removeLast();
		}
	}

}
