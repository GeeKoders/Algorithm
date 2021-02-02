package Interview.Google.Array;

public class NextPermutation {

	
	/*
	 * 31. Next Permutation (Medium)
	 * 
	 * https://leetcode.com/problems/next-permutation/
	 * 
	 * solution: https://leetcode.com/problems/next-permutation/solution/
	 * 
	 * Your runtime beats 40.28 % of java submissions.
	 * Your memory usage beats 86.51 % of java submissions.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public void nextPermutation(int[] nums) {

		if (nums == null || nums.length < 1)
			return;

		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}

		if (i >= 0) {
			int j = nums.length - 1;

			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	private void reverse(int[] nums, int i) {

		int j = nums.length - 1;

		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}

	}

	private void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

}
