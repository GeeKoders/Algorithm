package Learn.Array;

public class RotateArray {

	/*
	 * 189. Rotate Array (Easy)
	 * 
	 * https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/
	 * 
	 * solution: https://leetcode.com/articles/rotate-array/
	 * 
	 * Given an array, rotate the array to the right by k steps, where k is non-negative.
	 * Follow up:
	 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
	 * Could you do it in-place with O(1) extra space?
	 * 
	 * Example 1:
	 * Input: nums = [1,2,3,4,5,6,7], k = 3
	 * Output: [5,6,7,1,2,3,4]
	 * Explanation:
	 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
	 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
	 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
	 * 
	 * Example 2:
	 * Input: nums = [-1,-100,3,99], k = 2
	 * Output: [3,99,-1,-100]
	 * Explanation: 
	 * rotate 1 steps to the right: [99,-1,-100,3]
	 * rotate 2 steps to the right: [3,99,-1,-100]
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//time complexity:O(N), space complexity:O(N)
	public void rotate(int[] nums, int k) {

		int[] result = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			result[(i + k) % nums.length] = nums[i];
		}

		for (int i = 0; i < result.length; i++) {

			nums[i] = result[i];
		}

	}
	//time complexity: O(N*k), space complexity: O(1)
	/*
	 * Runtime: 215 ms, faster than 9.69% of Java online submissions for Rotate Array.
	 * Memory Usage: 39.5 MB, less than 58.65% of Java online submissions for Rotate Array.
	 * 
	 */
	public void rotate2(int[] nums, int k) {
		
		int tmp, previous ;
		
		for(int i=0; i<k; i++){
			
			previous = nums[nums.length - 1] ;
			
			for(int j=0; j<nums.length; j++){
				
				tmp = nums[j] ;
				nums[j] = previous ;
				previous = tmp ;
				
			}
			
		}
	}

}
