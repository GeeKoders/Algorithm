package Interview.Google.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {

		int[] nums = { -1, 0, 1, 2, -1, -4 };

		ThreeSum solve = new ThreeSum();
		List<List<Integer>> res = new ArrayList<>();

		res = solve.threeSum(nums);

		System.out.println(res);

	}

	/*
	 * 15. 3Sum (Medium)
	 * 
	 * https://leetcode.com/problems/3sum/
	 * 
	 * solution: https://leetcode.com/problems/3sum/solution/
	 * 
	 * Runtime: 26 ms, faster than 50.70% of Java online submissions for 3Sum.
	 * Memory Usage: 43.2 MB, less than 55.88% of Java online submissions for 3Sum.
	 * 
	 * Two pointer
	 * 
	 * Time complexity: O(N*logN + N^2) = O(N^2)
	 * Space complexity: O(1)
	 * Space Complexity: depending on the implementation of the sorting algorithm.
	 *
	 */
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();

		if (nums == null || nums.length < 3) {
			return res;
		}

		int n = nums.length;

		Arrays.sort(nums);

		for (int i = 0; i < n - 2; i++) {
			
			//avoid to duplicate
			
			/*
			 *     i  
			 * -4 -1 -1 0 1 2
			 * [-1, 0, 1]
			 *        i
			 * -4 -1 -1 0 1 2
			 * [-1, 0, 1]
			 */
			
			if (i >= 1 && nums[i - 1] == nums[i]) {
				continue;
			}

			int left = i + 1;
			int right = n - 1;

			while (left < right) {

				List<Integer> list = new ArrayList<>();

				int sum = nums[i] + nums[left] + nums[right];

				if (sum < 0) {
					left++;
				} else if (sum > 0) {
					right--;
				} else {
//					list.add(nums[i]);
//					list.add(nums[left++]);
//					list.add(nums[right--]);
//					res.add(list) ;
					res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
					
					//avoid to duplicate
					/*
					 *     i   l   r
					 * -4 -2 0 1 1 1
					 * [-2, 1, 1]
					 * 
					 *     i     l r 
					 * -4 -2 0 1 1 1
					 * [-2, 1, 1]
					 * 
					 */
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
				}
			}

		}

		return res;
	}

}
