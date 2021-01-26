package Tag.Array;

public class RemoveElement {

	
	/*
	 * 27. Remove Element (Easy)
	 * 
	 * https://leetcode.com/problems/remove-element/
	 * 
	 * solution: https://leetcode.com/problems/remove-element/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
	 * 
	 * Memory Usage: 37.3 MB, less than 96.28% of Java online submissions for Remove Element.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public int removeElement(int[] nums, int val) {

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[count++] = nums[i];
			}
		}

		return count;
	}

}
