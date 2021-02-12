package Tag.Array;

public class FindtheCelebrity {
	
	/*
	 * 277. Find the Celebrity (Medium)
	 * 
	 * https://leetcode.com/problems/find-the-celebrity/
	 * 
	 * solution: https://leetcode.com/problems/find-the-celebrity/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=Woma70JhE0Y&ab_channel=XavierElon
	 * 
	 * Brute Force
	 * 
	 * Runtime: 22 ms, faster than 47.40% of Java online submissions for Find the Celebrity.
	 * Memory Usage: 39.1 MB, less than 85.50% of Java online submissions for Find the Celebrity.
	 * 
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity: O(1)
	 * 
	 */
	public int findCelebrity(int n) {

		for (int i = 0; i < n; i++) {
			if (isCeleb(i, n)) {
				return i;
			}
		}

		return -1;

	}

	private boolean isCeleb(int possible_celeb, int n) {

		for (int j = 0; j < n; j++) {
			if (possible_celeb == j)
				continue;
			//if celebrity know other people or other people don't know celebrity
			if (knows(possible_celeb, j) || !knows(j, possible_celeb))
				return false;

		}

		return true;

	}
	/*
	 * Logical deduction
	 * 
	 * Runtime: 19 ms, faster than 79.11% of Java online submissions for Find the Celebrity.
	 * Memory Usage: 39.7 MB, less than 27.03% of Java online submissions for Find the Celebrity.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public int findCelebrity2(int n) {

		int possible_celeb = 0 ;
		
		for (int i = 0; i < n; i++) {
			if (knows(i, possible_celeb)) {
				possible_celeb = i ;
			}
		}
		
		if(isCeleb(possible_celeb, n)){
			return possible_celeb ;
		}

		return -1;

	}
}
