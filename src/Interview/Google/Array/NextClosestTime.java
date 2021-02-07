package Interview.Google.Array;

public class NextClosestTime {

	/*
	 * 681. Next Closest Time (Medium)
	 * 
	 * https://leetcode.com/problems/next-closest-time/
	 * 
	 * solution: https://leetcode.com/problems/next-closest-time/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=YYtQrH-aPXI&ab_channel=sheetalnikam
	 * 
	 * Runtime: 34 ms, faster than 5.22% of Java online submissions for Next Closest Time.
	 * 
	 * Memory Usage: 39.7 MB, less than 6.23% of Java online submissions for Next Closest Time.
	 * 
	 * Time complexity: Time Complexity: O(1)O(1). We try up to 24 * 60 possible times until we find the correct time. e.g.: 00:00 -> 00:00
	 * Space complexity: O(1)
	 * 
	 */
	public String nextClosestTime(String time) {

		int hour = Integer.parseInt(time.substring(0, 2));
		int mins = Integer.parseInt(time.substring(3));

		while (true) {
			if (++mins == 60) {
				mins = 0;
				hour++;
				hour %= 24;
			}

			String curr = String.format("%02d:%02d", hour, mins);

			boolean isValid = true;

			for (int i = 0; i < curr.length(); i++) {

				if (time.indexOf(curr.charAt(i)) < 0) {
					isValid = false;
					break;
				}

			}

			if (isValid)
				return curr;
		}
	}

}
