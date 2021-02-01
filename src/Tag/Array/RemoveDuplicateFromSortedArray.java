package Tag.Array;

public class RemoveDuplicateFromSortedArray {

	/*
	 * 26. Remove Duplicates from Sorted Array
	 * 
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	 * 
	 * solution:
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
	 * Memory Usage: 41.4 MB, less than 16.37% of Java online submissions for Remove Duplicates from Sorted Array.
	 * 
	 * Two pointer
	 * 
	 * Time complexity: O(N) 
	 * Space complexity: O(1)
	 */
	public int removeDuplicates(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int count = 1;
		for (int i = 1; i < nums.length; i++) {

			if (nums[count - 1] != nums[i]) {
				count++;
				nums[count - 1] = nums[i];
			}

		}

		return count;

	}

}
