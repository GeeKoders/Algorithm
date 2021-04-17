package Tag.DP;

public class MaximumSumof3NonOverlappingSubarrays {
	
	/*
	 * 689. Maximum Sum of 3 Non-Overlapping Subarrays (Hard)
	 * 
	 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
	 * 
	 * solution: https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=dGS4O0110qA&ab_channel=happygirlzt
	 * 
	 * Runtime: 2 ms, faster than 98.81% of Java online submissions for Maximum Sum of 3 Non-Overlapping Subarrays.
	 * Memory Usage: 41.1 MB, less than 37.89% of Java online submissions for Maximum Sum of 3 Non-Overlapping Subarrays.
	 * 
	 */
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int len = nums.length;
		int n = len - k + 1;
		int[] dp = new int[n];
		int sum = 0;

		for (int i = 0; i < len; i++) {

			sum += nums[i];

			if (i >= k) {
				sum -= nums[i - k];
			}

			if (i >= k - 1) {
				dp[i - k + 1] = sum;
			}

		}

		int[] left = new int[n];
		int[] right = new int[n];

		int maxIndex = 0;

		for (int i = 0; i < n; i++) {
			if (dp[i] > dp[maxIndex]) {
				maxIndex = i;
			}

			left[i] = maxIndex;
		}

		maxIndex = n - 1;
		for (int i = n - 1; i >= 0; i--) {
			if (dp[i] >= dp[maxIndex]) {
				maxIndex = i;
			}

			right[i] = maxIndex;
		}

		int[] res = new int[3];
		Arrays.fill(res, -1);

		for (int i = k; i < n - k; i++) {

			if (res[0] == -1
					|| dp[res[0]] + dp[res[1]] + dp[res[2]] < dp[left[i - k]]
							+ dp[i] + dp[right[i + k]]) {
				res[0] = left[i - k];
				res[1] = i;
				res[2] = right[i + k];
			}

		}

		return res;

	}
}
