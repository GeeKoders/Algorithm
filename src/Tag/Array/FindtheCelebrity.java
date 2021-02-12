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
}
