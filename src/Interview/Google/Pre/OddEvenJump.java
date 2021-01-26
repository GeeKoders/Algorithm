package Interview.Google.Pre;

public class OddEvenJump {

	/*
	 * 975. Odd Even Jump
	 * 
	 * https://leetcode.com/problems/odd-even-jump/
	 * 
	 * https://leetcode.com/problems/odd-even-jump/solution/
	 * 
	 * reference
	 * 
	 * https://www.youtube.com/watch?v=Z-MjnodQH3w&feature=youtu.be&ab_channel=happygirlzt
	 * 
	 * https://www.youtube.com/watch?v=r2I7KIqHTPU&ab_channel=NickWhite
	 * 
	 * brute-force (Time Limit Exceeded)
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity: O(1)
	 * 
	 */
	public int oddEvenJumps(int[] A) {

		int n = A.length;
		if (n < 1)
			return 0;
		int res = 0;

		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				res++;
				break;
			}

			int value = A[i];
			int index = i;

			while (index < n) {

				value = A[index];
				index = findGreater(A, value, index + 1, n);
				if (index == n - 1) {
					res++;
					break;
				} else if (index == -1)
					break;

				value = A[index];
				index = findSmaller(A, value, index + 1, n);

				if (index == n - 1) {
					res++;
					break;
				} else if (index == -1)
					break;
			}

		}

		return res;

	}

	private int findGreater(int[] A, int value, int from, int to) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = from; i < to; i++) {

			if (A[i] == value) {
				return A[i];
			}

			if (A[i] > value && min > A[i]) {
				min = A[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	private int findSmaller(int[] A, int value, int from, int to) {

		int max = Integer.MIN_VALUE;
		int maxIndex = -1;

		for (int i = from; i < to; i++) {
			if (A[i] == value) {
				return i;
			}

			if (A[i] < value && max < A[i]) {
				max = A[i];
				maxIndex = i;
			}

		}

		return maxIndex;

	}
}
