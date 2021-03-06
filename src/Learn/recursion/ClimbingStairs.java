package recursion;

public class ClimbingStairs {

	/**
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-
	 * memoization/1662/
	 * 
	 * solution: https://leetcode.com/articles/climbing-stairs/
	 * 
	 * You are climbing a stair case. It takes n steps to reach to the top. Each
	 * time you can either climb 1 or 2 steps. In how many distinct ways can you
	 * climb to the top?
	 * 
	 * Example 1: 
	 * Input: 2 
	 * Output: 2 
	 * Explanation: There are two ways to climb to the top.
	 *  1. 1 step + 1 step 
	 *  2. 2 steps
	 * 
	 * Example 2: 
	 * Input: 3 
	 * Output: 3 
	 * Explanation: There are three ways to climb to the top.
	 *  1. 1 step + 1 step + 1 step 
	 *  2. 1 step + 2 steps 
	 *  3. 2 steps + 1 step
	 * 
	 */

	public static void main(String[] args) {
		ClimbingStairs climbingStairs = new ClimbingStairs();
		System.out.println(climbingStairs.climbStairs1(4));
	}

	// time limit exceeded
	public int climbStairs1(int n) {
		return climb_Stairs(0, n);
	}

	public int climb_Stairs(int i, int n) {

		if (n < 2)
			return 1;
		return climb_Stairs(1, n - 1) + climb_Stairs(2, n - 2);
	}

	// time limit exceeded
	public int climbStairs2(int n) {
		return climb_Stairs2(0, n);
	}

	public int climb_Stairs2(int i, int n) {
		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}
		return climb_Stairs2(i + 1, n) + climb_Stairs2(i + 2, n);
	}

	//better solution
	public int climbStairs3(int n) {
		int[] memo = new int[n+1] ;
		return climb_Stairs3(0, n, memo);
	}

	public int climb_Stairs3(int i, int n, int[] memo) {
		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}
		
		if(memo[i] > 0) return memo[i] ;
			
		memo[i] = climb_Stairs3(i + 1, n, memo) + climb_Stairs3(i + 2, n, memo);
		
		return memo[i] ;
		
	}

}
