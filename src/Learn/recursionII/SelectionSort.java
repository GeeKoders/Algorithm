package recursionII;

public class SelectionSort {

	private int[] nums = { 5, 1, 2, 3, 4, 6 };

	public static void main(String[] args) {
		
		SelectionSort selectionSort = new SelectionSort() ; 
		selectionSort.sort(); 
		selectionSort.showArray();
		
	}
	
	
	public void sort() {

		for(int i=0; i<nums.length - 1; i++){
			
			int index = i ;
			
			for(int j = i + 1; j<nums.length; j++){
				if(nums[j] < nums[index]){
					index = j ;
				}
			}
			
			if( i != index){
				swap(i, index) ;
			}
		}
	}

	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void showArray() {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
