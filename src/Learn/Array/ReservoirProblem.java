package Array;

import java.util.Random;

public class ReservoirProblem {

	public static void main(String[] args) {

		int[] nums = { 13, 65, 46, 11, 71, 50, 12, 5, 81, 97, 28, 74, 87, 68,
				42, 31, 40, 37, 43, 25 };
		int k = 5;

		ReservoirProblem reservoir = new ReservoirProblem();
		int[] result = reservoir.solution1(nums, k);

		for (int items : result) {
			System.out.print(items + " ");
		}

	}

	public int[] solution1(int[] nums, int k) {

		int[] reservoir = new int[k];

		for (int i = 0; i < reservoir.length; i++) {
			reservoir[i] = nums[i];
		}

		Random random = new Random();

		for (int i = k; i < nums.length; i++) {
			int j = random.nextInt(i + 1);
			if (j < k)
				reservoir[j] = nums[i];
		}

		return reservoir;
	}

}
