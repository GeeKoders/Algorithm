package Tag.Other;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
	
	/*
	 * 56. Merge Intervals (Medium)
	 * 
	 * https://leetcode.com/problems/merge-intervals/
	 * 
	 * solution: https://leetcode.com/problems/merge-intervals/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=CR5TszEmVzw&ab_channel=happygirlzt
	 * 
	 * Runtime: 5 ms, faster than 94.42% of Java online submissions for Merge Intervals.
	 * Memory Usage: 41.5 MB, less than 64.19% of Java online submissions for Merge Intervals.
	 * 
	 * Time complexity: O(nlogn)
	 * Space complexity: O(logN) (or O(n))
	 * 
	 */
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		LinkedList<int[]> merged = new LinkedList<>();
		for (int[] interval : intervals) {
			// if the list of merged intervals is empty or if the current
			// interval does not overlap with the previous, simply append it.
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			}
			// otherwise, there is overlap, so we merge the current and previous
			// intervals.
			else {
				merged.getLast()[1] = Math
						.max(merged.getLast()[1], interval[1]);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
}