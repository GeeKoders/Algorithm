package Array;

public class CheckIfExist {

	/*
	 * Given an array arr of integers, check if there exists two integers N and
	 * M such that N is the double of M ( i.e. N = 2 * M).
	 * 
	 * More formally check if there exists two indices i and j such that :
	 * 
	 * i != j 
	 * 0 <= i, 
	 * j < arr.length arr[i] == 2 * arr[j]
	 * 
	 * Example 1: 
	 * Input: arr = [10,2,5,3] Output: true Explanation: N = 10 is
	 * the double of M = 5,that is, 10 = 2 * 5.
	 * 
	 * Example 2: 
	 * Input: arr = [7,1,14,11] Output: true Explanation: N = 14 is
	 * the double of M = 7,that is, 14 = 2 * 7.
	 * 
	 * Example 3: 
	 * Input: arr = [3,1,7,11] Output: false Explanation: In this
	 * case does not exist N and M, such that N = 2 * M.
	 * 
	 */

	public static void main(String[] args) {

		CheckIfExist checkIfExist = new CheckIfExist();
		int[] arr = { 10, 2, 5, 3 };
//		boolean result = checkIfExist.solution1(arr);
		boolean result = checkIfExist.solution2(arr);
		System.out.println(result);

	}

	public boolean solution1(int[] arr) {

		if (arr == null || arr.length == 0)
			return false;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {

				if (j != i && arr[i] == 2 * arr[j]) {
					return true;
				}
			}

		}
		return false;

	}
	// better solution
	public boolean solution2(int[] arr){
		
		if (arr == null || arr.length == 0 || arr.length == 1)
			return false;
		
		
		
		for (int i = 0; i < arr.length; i++) {
			if(serachTarget(arr, i, 2*arr[i])) return true ;
		}
		
		return false ;
	}
	
	public boolean serachTarget(int[] arr, int i, int target){
		for (int j = 0; j < arr.length; j++) {
			if (j!=i && arr[j] == target ) {
				return true;
			}
		}
		return false ;
	}

}
