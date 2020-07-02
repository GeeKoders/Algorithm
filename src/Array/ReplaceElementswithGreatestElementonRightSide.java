package Array;

public class ReplaceElementswithGreatestElementonRightSide {

	/*
	 * Given an array arr, replace every element in that array with the greatest
	 * element among the elements to its right, and replace the last element
	 * with -1.
	 * 
	 * After doing so, return the array.
	 * 
	 * Example 1: 
	 * Input: arr = [17,18,5,4,6,1] Output: [18,6,6,6,1,-1]
	 * 
	 */

	public static void main(String[] args) {

		ReplaceElementswithGreatestElementonRightSide replaceElementswithGreatestElementonRightSide = new ReplaceElementswithGreatestElementonRightSide();
		int arr[] = { 17, 18, 5, 4, 6, 1 };
		arr = replaceElementswithGreatestElementonRightSide.solution1(arr);

		for (int item : arr) {
			System.out.print(item + " ");
		}

	}

	// waste too much time
	public int[] solution1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int tmp = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > tmp) {
					tmp = arr[j];
				}
			}
			arr[i] = tmp;
			if (i == arr.length - 1) {
				arr[arr.length - 1] = -1;
			}
		}
		return arr;

	}

	public int[] solution2(int[] arr) {
		return arr;
	}

}
