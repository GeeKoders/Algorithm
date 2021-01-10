package recursionII;


public class QuickSort {

	private int[] nums = { 1, 5, 3, 7, 6, 9, 8, 3, 2 };

	public static void main(String[] args) {

		QuickSort quickSort = new QuickSort() ;
		quickSort.sort(); 
		quickSort.showArray();
	}
	
	private void sort() {
		quickSort(0, nums.length - 1) ;
	}
	
	private void quickSort(int low, int high){
		
		if(low >= high) return ;
		
		int pivot = partition(low, high) ;
		quickSort(low, pivot - 1) ;
		quickSort(pivot + 1, high) ;
		
	}
	
	private int partition(int low, int high){
		
		int pivotIndex = (low + high) / 2 ;
		swap(pivotIndex, high) ;
		
		int index = low ;
		
		for(int j=low; j < high; j++){
			
			if(nums[j] < nums[high]){
				
				swap(index, j) ;
				index ++ ;
			}
		}
		
		swap(index, high) ;
		
		return index ;
		
	}

	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private void showArray() {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
