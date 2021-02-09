package Interview.Google.Array;

public class MaximizeDistancetoClosestPerson {

	/*
	 * 849. Maximize Distance to Closest Person (Medium)
	 * 
	 * https://leetcode.com/problems/maximize-distance-to-closest-person/
	 * 
	 * solution: https://leetcode.com/problems/maximize-distance-to-closest-person/solution/
	 * 
	 * reference: 
	 * 
	 * https://www.youtube.com/watch?v=Zoi9JyGpCX8&ab_channel=NareshGupta
	 * 
	 * Your runtime beats 76.14 % of java submissions.
	 * Your memory usage beats 70.92 % of java submissions.
	 * 
	 * Time complexity: O(N)
	 * Space complexitY: O(1)
	 * 
	 * 
	 */
	public int maxDistToClosest(int[] seats) {

		int l = -1, n = seats.length, maxDistance = 0;

		for (int i = 0; i < seats.length; i++) {

			if (seats[i] == 1) {
				if (l == -1) {
					maxDistance = i;
				} else {
					maxDistance = Math.max(maxDistance, (i - l) / 2);
				}
				l = i;
			}

		}

		if (seats[n - 1] == 0) {
			maxDistance = Math.max(maxDistance, (n - 1 - l));
		}

		return maxDistance;

	}
}
