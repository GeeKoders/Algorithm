package Array.sort;

import java.util.Random;

public class BogoSort {

	public static void main(String[] args) {
		
		BogoSort bogoSort = new BogoSort() ;
		int[] nums = { 12, -4, 56, 0, 3, 8, 2, 1 };
		int[] result = bogoSort.solution1(nums) ;

		for(int items: result){
			System.out.print(items + " ");
		}
		
	}
	
	public int[] solution1(int[] nums){
		
		
		int count = 0 ;
		while(!isSorted(nums)){
			count++ ;
			shuffle(nums) ;
		}
		
		System.out.println("Count:" + count);
		
		return nums ;
	}
	private boolean isSorted(int[] nums) {
		
		for(int i=0; i<nums.length - 1; i++){
			if(nums[i] > nums[i+1]){
				return false ;
			}
		}
		
		return true;
	}

	//shuffle
	private void shuffle(int[] nums){
		Random random = new Random() ;
		for(int i=0; i<nums.length; i++){
			int j= random.nextInt(nums.length) ;
			swap(nums, i, j) ;
		}
	}

	private void swap(int[] nums, int i, int j) {
		
		int temp = nums[i] ;
		nums[i] = nums[j] ;
		nums[j] = temp ;
		
	}
	
	

}
