package Array;

public class FindMaxConsecutiveOnes {

	/*
	 * Given a binary array, find the maximum number of consecutive 1s in this array.
	 * 
	 * 
	 * Example 1: 
	 * Input: [1,1,0,1,1,1] 
	 * Output: 3
	 * 
	 * Explanation: The first two digits or the last three digits are
	 * consecutive 1s. The maximum number of consecutive 1s is 3.
	 * 
	 * Note:
	 * 
	 * The input array will only contain 0 and 1. The length of input array is a
	 * positive integer and will not exceed 10,000
	 * 
	 */

	public static void main(String[] args) {

		FindMaxConsecutiveOnes findMaxConsecutiveOnes = new FindMaxConsecutiveOnes();
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		int result = findMaxConsecutiveOnes.solution1(nums);

		System.out.println(result);

	}

	public int solution1(int[] nums) {
		int count = 0;
		int maxValue = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] != 0) {
				count++;
			} else {
				maxValue = getMaximum(count, maxValue);
				count = 0;
			}
		}

		maxValue = getMaximum(count, maxValue);

		return maxValue;
	}

	public int getMaximum(int count, int maxValue) {
		return count > maxValue ? count : maxValue;
	}

}
