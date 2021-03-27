package Tag.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsonaLine {
	
	/*
	 * 149. Max Points on a Line (Hard)
	 * 
	 * https://leetcode.com/problems/max-points-on-a-line/
	 * 
	 * solution: https://leetcode.com/problems/max-points-on-a-line/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=6YVJfVhsESk&ab_channel=happygirlzt
	 * 
	 * Runtime: 23 ms, faster than 38.86% of Java online submissions for Max Points on a Line.
	 * Memory Usage: 39 MB, less than 42.81% of Java online submissions for Max Points on a Line.
	 * 
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity: O(N)
	 * 
	 */
	public int maxPoints(int[][] points) {

		if (points.length < 2)
			return points.length;

		int n = points.length;
		int max = 1;
		Set<String> set = new HashSet<>();

		for (int i = 0; i < n
				&& !set.contains(points[i][0] + "-" + points[i][1]); i++) {

			int[] a = points[i];
			Map<Double, Integer> map = new HashMap<>();

			int same = 0;
			int localMax = 1;

			for (int j = i + 1; j < n; j++) {

				if (isSame(a, points[j])) {
					same++;
					continue;
				}

				double slope = getSlope(a, points[j]);
				map.put(slope, map.getOrDefault(slope, 1) + 1);
				localMax = Math.max(localMax, map.get(slope));

			}

			set.add(a[0] + "-" + a[1]);
			System.out.println("a[0]" + a[0]);
			System.out.println("a[1]" + a[1]);
			max = Math.max(max, localMax);

		}

		return max;
	}

	private boolean isSame(int[] a, int[] b) {
		return a[0] == b[0] && a[1] == b[1];
	}

	private double getSlope(int[] a, int[] b) {

		if (a[0] == b[0])
			return Double.MAX_VALUE;
		if (a[1] == b[1])
			return 0;
		return ((double) a[0] - b[0]) / ((double) a[1] - b[1]);
	}
}
