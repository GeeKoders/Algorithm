package recursionII;

public class QuickSort {

	private int[] nums = { 1, 5, 3, 7, 6, 9, 8, 3, 2 };

	public static void main(String[] args) {

		QuickSort quickSort = new QuickSort();
		quickSort.sort();
		quickSort.showArray();
	}

	private void sort() {
		quickSort(0, nums.length - 1);
	}

	private void quickSort(int low, int high) {

		if (low >= high)
			return;

		int pivot = partition(low, high);
		quickSort(low, pivot - 1);
		quickSort(pivot + 1, high);

	}

	private int partition(int low, int high) {

		int pivotIndex = (low + high) / 2;
		swap(pivotIndex, high);

		int index = low;

		for (int j = low; j < high; j++) {

			if (nums[j] < nums[high]) {

				swap(index, j);
				index++;
			}
		}

		swap(index, high);

		return index;

	}

	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private void showArray() {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	/*
	 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2870/
	 *
	 */
	public void quickSort(int[] lst) {
		/* Sorts an array in the ascending order in O(n log n) time */
		int n = lst.length;
		qSort(lst, 0, n - 1);
	}

	private void qSort(int[] lst, int lo, int hi) {
		if (lo < hi) {
			int p = partition(lst, lo, hi);
			qSort(lst, lo, p - 1);
			qSort(lst, p + 1, hi);
		}
	}

	private int partition(int[] lst, int lo, int hi) {
		/*
		 * Picks the last element hi as a pivot and returns the index of pivot
		 * value in the sorted array
		 */
		int pivot = lst[hi];
		int i = lo;
		for (int j = lo; j < hi; ++j) {
			if (lst[j] < pivot) {
				int tmp = lst[i];
				lst[i] = lst[j];
				lst[j] = tmp;
				i++;
			}
		}
		int tmp = lst[i];
		lst[i] = lst[hi];
		lst[hi] = tmp;
		return i;
	}
}
