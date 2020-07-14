package Array.sort;

public class CountingSort {

	public static void main(String[] args) {

		CountingSort countingSort = new CountingSort() ;
		int[] nums = {2, 5, 3, 2, 2, 2, 4, 5} ;
		int[] result = countingSort.solution1(nums, 2, 5) ;
		
		for(int items: result){
			System.out.print(items + " ");
		}
		
	}
	
	public int[] solution1(int[] nums, int min, int max){
		
		int[] countArray = new int[max - min + 1] ;
		
		//O(N)
		for(int i=0; i<nums.length; i++){
			countArray[nums[i]-min]++ ;
		}
		//O(K)
		int z = 0;
		for(int i=min; i<=max; i++){
			
			while(countArray[i-min] > 0){
				nums[z] = i ;
				z++ ;
				countArray[i-min] -- ;
			}
		}
		
		return nums ;
		
	}

}
