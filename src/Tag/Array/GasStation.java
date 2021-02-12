package Tag.Array;

public class GasStation {

	
	/*
	 * 134. Gas Station (Medium)
	 * 
	 * https://leetcode.com/problems/gas-station/
	 * 
	 * https://leetcode.com/problems/gas-station/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=bkXokc5hh14&ab_channel=HuaHua
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Gas Station.
	 * Memory Usage: 39.6 MB, less than 27.07% of Java online submissions for Gas Station.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {

		if (gas == null || gas.length == 0 || cost == null || cost.length == 0)
			return -1;

		int total = 0;
		int curr = 0;
		int start = 0;

		for (int i = 0; i < cost.length; i++) {

			curr += gas[i] - cost[i];

			if (curr < 0) {
				curr = 0;
				start = i + 1;
			}

			total += gas[i] - cost[i];

		}

		return total >= 0 ? start : -1;
	}
}
