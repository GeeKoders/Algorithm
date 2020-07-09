package Array;

public class ReverseArray {

	/*
	 * 
	 * Reversing an array in-place solution O(N)
	 */

	public static void main(String[] args) {

		ReverseArray reverseArray = new ReverseArray() ;
		int[] nums = {5, 4, 3, 2, 1, 0} ;
		int []result = reverseArray.solution1(nums);
		
		for(int items: result){
			System.out.print(items + " ");
		}
		
	}
	
	public int[] solution1(int []nums){
		
		int startIndex = 0 ;
		int lastIndex = nums.length - 1 ;
		
		while(startIndex < lastIndex){
			
			swap(nums, startIndex, lastIndex) ;
			startIndex ++ ;
			lastIndex -- ; 
		}
		
		return nums ;
		
	}

	private void swap(int[] nums, int startIndex, int lastIndex) {
		
		int temp = nums[startIndex] ;
		nums[startIndex] = nums[lastIndex] ;
		nums[lastIndex] = temp ;
		
	}

}
