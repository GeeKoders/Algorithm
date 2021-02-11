package Interview.Google.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {

	/*
	 * 215. Kth Largest Element in an Array (Medium)
	 * 
	 * https://leetcode.com/problems/kth-largest-element-in-an-array/
	 * 
	 * solution:https://leetcode.com/problems/kth-largest-element-in-an-array/solution/
	 * 
	 * Your runtime beats 98.02 % of java submissions. 
	 * Your memory usage beats 56.65 % of java submissions.
	 * 
	 * 
	 * Time complexity: O(N*logN) 
	 * Space complexity: O(1)
	 * 
	 */
	public int findKthLargest(int[] nums, int k) {

		Arrays.sort(nums);

		int n = nums.length;

		return nums[n - k];

	}

	/*
	 * 
	 * Your runtime beats 31.72 % of java submissions. 
	 * Your memory usage beats 99.39 % of java submissions.
	 * 
	 * Time complexity: O(NlogN) 
	 * Space complexity: O(N)
	 * 
	 */
	public int findKthLargest2(int[] nums, int k) {

		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			heap.add(nums[i]);
		}

		int n = nums.length;
		int count = 0;
		int res = 0;

		while (count != (n - k + 1)) {
			res = heap.remove();
			count++;
		}

		return res;

	}

	/*
	 * 
	 * Your runtime beats 60.30 % of java submissions. 
	 * Your memory usage beats 78.99 % of java submissions.
	 * 
	 * Time complexity: O(Nlogk) 
	 * Space complexity: O(k)
	 * 
	 */
	public int findKthLargest3(int[] nums, int k) {

		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			heap.add(nums[i]);

			if (heap.size() > k) {
				heap.poll();
			}

		}

		return heap.poll();

	}

	/*
	 * Quick select
	 * 
	 * Your runtime beats 98.02 % of java submissions.
	 * Your memory usage beats 37.91 % of java submissions.
	 * 
	 * Time complexity: O(N) 
	 * Space complexity: O(1)
	 * 
	 */
	private int[] nums;
	private int n;

	public int findKthLargest4(int[] nums, int k) {
		this.nums = nums;
		n = nums.length;
		int left = 0;
		int right = n - 1;

		return quickSelect(left, right, n - k);

	}

	private int quickSelect(int left, int right, int target) {

		int pivotIndex = partition(left, right);

		if (pivotIndex == target)
			return nums[pivotIndex];

		if (pivotIndex < target) {
			return quickSelect(pivotIndex + 1, right, target);
		} else {
			return quickSelect(left, pivotIndex - 1, target);
		}

	}

	private int partition(int left, int right) {

		int pivotIndex = (left + right) / 2;

		swap(pivotIndex, right);

		int i = left;

		for (int j = left; j < right; j++) {

			if (nums[j] < nums[right]) {
				swap(i, j);
				i++;
			}

		}

		swap(i, right);

		return i;
	}

	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
