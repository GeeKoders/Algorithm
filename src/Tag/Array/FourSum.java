package Tag.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
	/*
	 * 18. 4Sum (Medium)
	 * 
	 * https://leetcode.com/problems/4sum/
	 * 
	 * solution: https://leetcode.com/problems/4sum/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=4wFQdfTZdzI&ab_channel=%E5%82%85%E7%A0%81%E7%88%B7
	 * 
	 * Runtime: 13 ms, faster than 76.95% of Java online submissions for 4Sum.
	 * Memory Usage: 39.3 MB, less than 74.32% of Java online submissions for 4Sum.
	 * 
	 * 
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> res = new ArrayList<>();

		if (nums == null || nums.length < 4)
			return res;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				for (int j = i + 1; j < nums.length - 2; j++) {
					if (j == i + 1 || nums[j] != nums[j - 1]) {
						int begin = j + 1, end = nums.length - 1;
						int newTarget = target - nums[i] - nums[j];

						while (begin < end) {
							if (nums[begin] + nums[end] == newTarget) {
								res.add(Arrays.asList(nums[i], nums[j],
										nums[begin], nums[end]));
								while (begin < end
										&& nums[begin] == nums[begin + 1])
									begin++;
								while (begin < end
										&& nums[end] == nums[end - 1])
									end--;
								begin++;
								end--;
							} else if (nums[begin] + nums[end] > newTarget) {
								end--;
							} else {
								begin++;
							}
						}
					}
				}
			}
		}

		return res;
	}
}
