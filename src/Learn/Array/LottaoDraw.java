package Array;

import java.util.Random;

public class LottaoDraw {
	
	public static void main(String[] args) {
		
		LottaoDraw lottaoDraw = new LottaoDraw() ;
		int[] nums = new int[6] ;
		int[] result = lottaoDraw.solution1(nums) ;
		
		for(int item: result){
			System.out.print(item + " ");
		}
		
	}
	
	public int[] solution1(int[] nums){
		
		Random random = new Random() ;
		
		
		for(int i=0; i<nums.length; i++){
			
			nums[i] = random.nextInt(52) + 1 ;
			
			for(int j=0; j<i; j++){
				if(nums[i] == nums[j]){
					i-- ;
					break ;
				}
			}
		}
		
		return nums ;
		
		
	}

}
