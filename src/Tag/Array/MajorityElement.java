package Tag.Array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	
	/*
	 * 169. Majority Element (Easy)
	 * 
	 * https://leetcode.com/problems/majority-element/
	 * 
	 * solution: https://leetcode.com/problems/majority-element/solution/
	 * 
	 * Runtime: 8 ms, faster than 40.87% of Java online submissions for Majority Element.
	 * Memory Usage: 44.2 MB, less than 45.47% of Java online submissions for Majority Element.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public int majorityElement(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (Double.valueOf(entry.getValue()) / nums.length >= 0.5) {

				return entry.getKey();
			}

		}

		return -1;

	}

}
