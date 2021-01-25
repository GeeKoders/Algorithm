package Array.sort;

public class BubbleSort {

	public static void main(String[] args) {

		BubbleSort bubbleSort = new BubbleSort() ;
		int[] nums = {12, 7, -5, -77, 102} ;
		int[] result = bubbleSort.solution1(nums) ;
		
		for(int items: result){
			System.out.print(items + " ");
		}
		
	}
	
	public int[] solution1(int[] nums){
		
		for(int i=0; i<nums.length; i++){
			
			for(int j=0; j<nums.length - i -1 ; j++){
				if(nums[j]>nums[j+1]){
					swap(nums, j, j+1) ;
				}
			}
		}
		
		return nums ;
	}
	
	private void swap(int[] nums, int i, int j){
		int tmp = nums[i] ;
		nums[i] = nums[j] ;
		nums[j] = tmp ;
	}
	
	

}
