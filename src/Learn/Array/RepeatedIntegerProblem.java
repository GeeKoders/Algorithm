package Array;

import java.util.Arrays;

public class RepeatedIntegerProblem {

	public static void main(String[] args) {

		// {0, 4, 2, 4, 1, 1} is bug
		int[] nums = { 2, 1, 2, 4, 4, 3, 3 };
		RepeatedIntegerProblem repeatedIntegerProblem = new RepeatedIntegerProblem();
		// int[] result = repeatedIntegerProblem.solution1(nums) ;

		repeatedIntegerProblem.solution2(nums);

		// for(int items: result){
		// System.out.print(items + " ");
		// }

	}

	// not in-place
	public int[] solution1(int[] nums) {

		// O(logN)
		Arrays.sort(nums);

		int target[] = new int[nums.length];
		int count = 0;
		// O(N)
		for (int i = 0; i < nums.length - 1; i++) {

			if (nums[i] == nums[i + 1]) {
				if (target[count] != nums[count + 1]) {
					target[count++] = nums[i];
				}

			}

		}

		return target;
	}

	public void solution2(int[] nums) {

		for (int i = 0; i < nums.length; i++) {

			if (nums[Math.abs(nums[i])] > 0) {
				nums[Math.abs(nums[i])] = -Math.abs(nums[i]);
			} else {
				System.out.println(Math.abs(nums[i]) + " repeated");
			}

		}

	}

}
