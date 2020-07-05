package Array;

public class RemoveDuplicates {

	/*
	 * Given a sorted array nums, remove the duplicates in-place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this by
	 * modifying the input array in-place with O(1) extra memory.
	 * 
	 * Example 1: 
	 * Given nums = [1,1,2],
	 * 
	 * Your function should return length = 2, with the first two elements of
	 * nums being 1 and 2 respectively.
	 * 
	 * It doesn't matter what you leave beyond the returned length.
	 * 
	 * Example 2:
	 * Given nums = [0,0,1,1,1,2,2,3,3,4],
	 * 
	 * Your function should return length = 5, with the first five elements of
	 * nums being modified to 0, 1, 2, 3, and 4 respectively.
	 * 
	 * It doesn't matter what values are set beyond the returned length.
	 */

	public static void main(String[] args) {

		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		int[] nums = { 0, 0, 1, 1, 2, 2, 3, 4, 4};
//		int result = removeDuplicates.solution1(nums);
		int result = removeDuplicates.solution2(nums);
		System.out.println(result);

	}

	public int solution1(int[] nums) {
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
	
	public int solution2(int[] nums){
		
		int newArrLength = 0 ;
		
		for(int i=0; i<nums.length - 1; i++){
			
			if(nums[i] != nums[i+1]){
				newArrLength++ ;
			}
		}
		
		int[] newArr = new int[newArrLength+1] ;
		
		int count = 0 ;
		for(int j=0; j<nums.length - 1; j++){
			
			if(nums[j]!=nums[j+1]){
				newArr[count] = nums[j] ;
				count++ ;
			}
		}
		
		//count the last index no matter how the last two index is duplicate or not
		newArr[count] = nums[nums.length-1] ;
		
		for(int items: newArr){
			System.out.print(items + " ");
		}
		
		return count + 1 ;
		
	}

}
