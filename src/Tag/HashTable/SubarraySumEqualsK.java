package Tag.HashTable;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	
	/*
	 * 560. Subarray Sum Equals K (Medium)
	 * 
	 * https://leetcode.com/problems/subarray-sum-equals-k/
	 * 
	 * solution: https://leetcode.com/problems/subarray-sum-equals-k/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=AmlVSNBHzJg&ab_channel=NickWhite
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * Runtime: 17 ms, faster than 95.92% of Java online submissions for Subarray Sum Equals K.
	 * Memory Usage: 41.4 MB, less than 68.35% of Java online submissions for Subarray Sum Equals K.
	 * 
	 */
	public int subarraySum(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, 1);
		int sum = 0;
		int res = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (map.containsKey(sum - k)) {
				res += map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);

		}

		return res;
	}
}
