package recursionII;

public class BubbleSort {

	private int[] nums = {5, 1, 2, 3, 4, 6} ;
	
	public static void main(String[] args) {

		BubbleSort bubbleSort = new BubbleSort() ;
		bubbleSort.sort();
		bubbleSort.showArray();
		
	}
	
	public void sort(){
		
		for(int i=0; i<nums.length - 1; i++){
			for(int j = 0; j<nums.length - i - 1; j++){
				if(nums[j] > nums[j+1]){
					swap(j, j+1) ;
				}
			}
		}
	}
	
	private void swap(int i, int j){
		int temp = nums[i] ;
		nums[i] = nums[j] ;
		nums[j] = temp ;
	}
	
	
	public void showArray(){
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
	
	
	
}
