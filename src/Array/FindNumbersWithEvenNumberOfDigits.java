package Array;

public class FindNumbersWithEvenNumberOfDigits {

	public static void main(String[] args) {

		FindNumbersWithEvenNumberOfDigits findNumbersWithEvenNumberOfDigits = new FindNumbersWithEvenNumberOfDigits() ;
		int[] nums = {12, 345, 2, 6, 7896} ;
		int result = findNumbersWithEvenNumberOfDigits.solution1(nums) ;
		System.out.println(result);
		
	}

	public int solution1(int[] nums) {

		int count = 0;

		for (int i = 0; i < nums.length; i++) {

			if (Integer.toString(nums[i]).length() % 2 == 0) {
				count++;
			}
		}

		return count;
	}

}
