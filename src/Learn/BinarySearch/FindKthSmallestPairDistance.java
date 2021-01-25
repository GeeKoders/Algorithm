package BinarySearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

	public static void main(String[] args) {
		
		FindKthSmallestPairDistance findKthSmallestPairDistance = new FindKthSmallestPairDistance() ;
		int result = findKthSmallestPairDistance.smallestDistancePair(new int[]{1, 6, 1}, 3) ;
		System.out.println("result:" + result);
	
	}
	//reference: https://www.youtube.com/watch?v=WHfljqX61Y8&ab_channel=HuaHua
	public int smallestDistancePair(int[] nums, int k) {
        
		Arrays.sort(nums);
		int[] arr = new int[nums[nums.length-1] + 1];
		
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length;j++){
                arr[Math.abs(nums[i] - nums[j])]++;
            }
        }

        int count = 0;
        for(int i=0; i<arr.length; i++){
            count += arr[i];
            if(count >= k) {
                return i;
            }
        }
        return 0;
        
        
    }

}
