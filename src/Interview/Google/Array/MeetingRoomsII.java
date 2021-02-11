package Interview.Google.Array;

import java.util.Arrays;

public class MeetingRoomsII {

	/*
	 * 253. Meeting Rooms II (Medium)
	 * 
	 * https://leetcode.com/problems/meeting-rooms-ii/
	 * 
	 * https://leetcode.com/problems/meeting-rooms-ii/solution/
	 * 
	 * reference: 
	 * 
	 * https://www.youtube.com/watch?v=jUpuIio_oYo&ab_channel=freeCodeCamp.org
	 * 
	 * Runtime: 2 ms, faster than 96.06% of Java online submissions for Meeting Rooms II.
	 * Memory Usage: 38.8 MB, less than 68.24% of Java online submissions for Meeting Rooms II.
	 * 
	 * Time complexity: O(NlogN)
	 * Space complexity: O(N)
	 * 
	 */
	public int minMeetingRooms(int[][] intervals) {

		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}

		Arrays.sort(start);
		Arrays.sort(end);
		int res = 0;
		int endIndex = 0;

		for (int i = 0; i < start.length; i++) {

			if (start[i] < end[endIndex]) {
				res++;
			} else {
				endIndex++;
			}

		}

		return res;

	}
}
