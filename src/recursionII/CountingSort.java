package recursionII;

public class CountingSort {

	private int[] nums = { 2, 5, 3, 2, 2, 2, 4, 5 };
	
	public static void main(String[] args) {
	
		CountingSort countingSort = new CountingSort() ;
		countingSort.sort(2, 5) ;
		countingSort.showArray();
		
	}
	
	private void sort(int min, int max){
		
		int [] countArray = new int [max - min + 1] ;
		
		for(int i=0; i<nums.length; i++){
			countArray[nums[i] - min] ++ ;
		}
		
		int z = 0 ;
		for(int i=min; i<=max; i++){
			
			while(countArray[ i - min] > 0){
				nums[z] = i ;
				z++ ;
				countArray[ i - min] -- ;
			}
			
		}
		
		
		
	}
	
	private void showArray(){
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
	
}
