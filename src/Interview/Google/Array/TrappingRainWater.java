package Interview.Google.Array;

public class TrappingRainWater {

	/*
	 * 42. Trapping Rain Water (Hard)
	 * 
	 * https://leetcode.com/problems/trapping-rain-water/
	 * 
	 * solution: https://leetcode.com/problems/trapping-rain-water/solution/
	 * 
	 * reference: 
	 * 
	 * https://www.youtube.com/watch?v=fTD6Se3ZtEo&feature=youtu.be&ab_channel=TerribleWhiteboard
	 * 
	 * Your runtime beats 85.96 % of java submissions.
	 * Your memory usage beats 65.58 % of java submissions.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public int trap(int[] height) {

		if (height == null || height.length == 0)
			return 0;

		int totalWater = 0;
		int n = height.length;
		int leftMax[] = new int[n];
		int rightMax[] = new int[n];

		leftMax[0] = height[0];

		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(height[i], leftMax[i - 1]);
		}

		rightMax[n - 1] = height[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(height[i], rightMax[i + 1]);
		}

		for (int i = 1; i < n; i++) {

			totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];

		}

		return totalWater;

	}
}
