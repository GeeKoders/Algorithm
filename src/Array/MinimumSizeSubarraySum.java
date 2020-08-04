package Array;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int minSubArrayLen(int s, int[] nums) {
		
		int result = Integer.MAX_VALUE ;
		
		int left = 0 ;
		int sum = 0 ;
		
		for(int i=0; i<nums.length; i++){
			
			sum +=  nums[i] ;
			
			while(sum >= s){
				
				result = Math.min(result, i + 1 - left) ;
				sum -= nums[left] ;
				left++ ;
			}
			
		}
		
		return (result != Integer.MAX_VALUE) ?  result : 0;
	      
	}

}
