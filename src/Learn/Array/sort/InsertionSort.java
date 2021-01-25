package Array.sort;

public class InsertionSort {

	public static void main(String[] args) {

		InsertionSort insertionSort = new InsertionSort() ;
		int[] nums = { 1, 4, 2, 0, -10, -5, 10, 100 };
		int[] result = insertionSort.solution1(nums) ;
		
		for(int items: result){
			System.out.print(items + " ");
		}
		
	}
	
	public int[] solution1(int []nums){
		
		
		for(int i=1; i< nums.length; i++){
			
			int j = i ;
			
			while(j>0 && nums[j-1] > nums[j]){
				swap(nums, j-1, j) ;
				j-- ;
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
