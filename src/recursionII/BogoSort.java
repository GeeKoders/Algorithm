package recursionII;

import java.util.Random;

public class BogoSort {

	private int[] nums = { 12, -4, 56, 0, 3, 8, 2, 1 };
	
	public static void main(String[] args) {
		
		BogoSort bogoSort = new BogoSort() ;
		
		int loopCounter = 0 ;
		
		while(!bogoSort.isSorted()){
			++loopCounter ;
			bogoSort.shuffle() ;
		}
		
		System.out.println("Steps required to sort array: " + loopCounter);
		bogoSort.showArray();
	}
	
	
	public void swap(int i, int j){
		int temp = nums[i] ;
		nums[i] = nums[j] ;
		nums[j] = temp ;
	}
	
	public void showArray(){
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
	
	private void shuffle(){
		
		for(int i=nums.length -1 ; i >=0 ;i--){
			int j = (int)(Math.random() * i) ;
			swap(i, j) ;
		}
		
	}
	
	private boolean isSorted(){
		
		for(int i=0; i<nums.length - 1; i++){
			if(nums[i] > nums[i + 1]){
				return false ;
			}
		}
		
		return true ;
		
	}
	
	
}
