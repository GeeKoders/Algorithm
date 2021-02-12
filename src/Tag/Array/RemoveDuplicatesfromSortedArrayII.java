package Tag.Array;

public class RemoveDuplicatesfromSortedArrayII {

	
	/*
	 * 80. Remove Duplicates from Sorted Array II (Medium)
	 * 
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
	 * 
	 * solution: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/solution/
	 * 
	 * Runtime: 1 ms, faster than 34.15% of Java online submissions for Remove Duplicates from Sorted Array II.
	 * 
	 * Memory Usage: 39.2 MB, less than 58.27% of Java online submissions for Remove Duplicates from Sorted Array II.
	 * 
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity: O(N)
	 * 
	 */
	private int[] remElement(int[] nums, int index) {

		for (int i = index + 1; i < nums.length; i++) {
			nums[i - 1] = nums[i];
		}

		return nums;

	}

	public int removeDuplicates(int[] nums) {

		int i = 1, count = 1, length = nums.length;

		while (i < length) {

			if (nums[i - 1] == nums[i]) {
				count++;

				if (count > 2) {
					remElement(nums, i);

					i--;
					length--;

				}

			} else {
				count = 1;
			}

			i++;

		}

		return length;

	}

}
