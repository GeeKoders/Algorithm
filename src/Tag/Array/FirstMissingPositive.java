package Tag.Array;

public class FirstMissingPositive {

	
	/*
	 * 41. First Missing Positive (Hard)
	 * 
	 * https://leetcode.com/problems/first-missing-positive/
	 * 
	 * solution: https://leetcode.com/problems/first-missing-positive/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=jfb72FfxWKU&ab_channel=Cspiration%E5%AE%98%E6%96%B9%E9%A2%91%E9%81%93
	 * 
	 * Good solution
	 * https://www.youtube.com/watch?v=9SnkdYXNIzM&ab_channel=MichaelMuinos
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for First Missing Positive.
	 * Memory Usage: 36.4 MB, less than 92.75% of Java online submissions for First Missing Positive.
	 * 
	 */
	public int firstMissingPositive(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 1;
		}

		for (int i = 0; i < nums.length; i++) {

			while (nums[i] > 0 && nums[i] <= nums.length
					&& nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}

		}

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] != i + 1) {
				return i + 1;
			}

		}

		return nums.length + 1;

	}
}
