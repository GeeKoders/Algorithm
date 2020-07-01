package Array;

public class RemoveDuplicates {

	public static void main(String[] args) {

		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		int[] nums = { 1, 1, 2 };
		int result = removeDuplicates.soultion1(nums);
		System.out.println(result);

	}

	public int soultion1(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];

			}
		}

		for (int items : nums) {
			System.out.print(items + " ");
		}

		System.out.println();

		return i + 1;

	}

}
