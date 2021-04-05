package Tag.DP;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	
	/*
	 * 523. Continuous Subarray Sum (Medium)
	 * 
	 * https://leetcode.com/problems/continuous-subarray-sum/
	 * 
	 * solution: https://leetcode.com/problems/continuous-subarray-sum/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=C2xC-EnvpaQ&ab_channel=happygirlzt
	 * 
	 * Runtime: 15 ms, faster than 26.16% of Java online submissions for Continuous Subarray Sum.
	 * Memory Usage: 49 MB, less than 9.89% of Java online submissions for Continuous Subarray Sum.
	 * 
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public boolean checkSubarraySum(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];

			if (k != 0) {
				sum = sum % k;
			}

			if (map.containsKey(sum)) {
				if (i - map.get(sum) >= 2)
					return true;
			}

			map.putIfAbsent(sum, i);

		}

		return false;

	}
}
