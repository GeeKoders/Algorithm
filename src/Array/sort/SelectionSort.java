package Array.sort;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort() ;
		int[] nums = { 3, 6, 0, -5, 5, 7, 2, 1 };
		int[] result = selectionSort.solution1(nums) ;
		
		for(int items: result){
			System.out.print(items + " ");
		}
		
	}
	
	public int[] solution1(int []nums){
		
		
		for(int i=0; i<nums.length; i++){
			
			for(int j = i+1; j<nums.length; j++){
				if(nums[j] < nums[i]){
					swap(nums, j, i) ;
				}
			}
			
		}
		
		return nums ;
	}

	private void swap(int[] nums, int i, int j) {
		
		int tmp = nums[i] ;
		nums[i] = nums[j] ;
		nums[j] = tmp ;
		
	}

}
