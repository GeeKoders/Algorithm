package Array;

public class DuplicateZeros {

	/*
	 * Given a fixed length array arr of integers, duplicate each occurrence of
	 * zero, shifting the remaining elements to the right.
	 * 
	 * Note that elements beyond the length of the original array are not
	 * written.
	 * 
	 * Do the above modifications to the input array in place, do not return
	 * anything from your function.
	 * 
	 * Example 1 Input: [1,0,2,3,0,4,5,0] Output: null Explanation: After
	 * calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
	 * 
	 * Example 2 Input: [1,2,3] Output: null Explanation: After calling your
	 * function, the input array is modified to: [1,2,3]
	 */

	public static void main(String[] args) {

		DuplicateZeros duplicateZeros = new DuplicateZeros();
		int[] source = { 1, 0, 2, 3, 0, 4, 5, 0 };
		duplicateZeros.solution1(source);
	}

	// not in-place
	public void solution1(int[] source) {

		int[] dest = new int[source.length];

		int s = 0;
		int d = 0;

		for (int i = 0; i < source.length; i++) {

			if (source[i] == 0) {
				dest[d] = 0;
				d += 1;
				dest[d] = 0;
			} else {
				dest[d] = source[i];
			}

			d += 1;

			if (d == source.length)
				break;
		}

		for (int i = 0; i < dest.length; i++) {
			source[i] = dest[i];
		}
		
		display(source) ;

	}

	public void display(int[] source) {

		for (int item : source) {
			System.out.print(item + " ");
		}
	}

}
