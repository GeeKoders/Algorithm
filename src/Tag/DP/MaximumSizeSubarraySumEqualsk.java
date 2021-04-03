package Tag.DP;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
	
	/*
	 * 325. Maximum Size Subarray Sum Equals k (Medium)
	 * 
	 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
	 * 
	 * reference: https://www.youtube.com/watch?v=l5fw70Sw62I&ab_channel=happygirlzt
	 * 
	 * Runtime: 8 ms, faster than 95.70% of Java online submissions for Maximum Size Subarray Sum Equals k.
	 * Memory Usage: 40.2 MB, less than 47.46% of Java online submissions for Maximum Size Subarray Sum Equals k.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public int maxSubArrayLen(int[] nums, int k) {

		// [3, 6] preSum(6) - preSum(2)
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;

		int maxLen = 0;

		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];
			if (map.containsKey(sum - k)) {
				maxLen = Math.max(maxLen, i - map.get(sum - k));
			}

			map.putIfAbsent(sum, i);

		}

		return maxLen;
	}
}
