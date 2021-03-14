package Tag.DFS;

public class NumberofProvinces {
	
	/*
	 * 547. Number of Provinces (Medium)
	 * 
	 * https://leetcode.com/problems/number-of-provinces/
	 * 
	 * solution: https://leetcode.com/problems/number-of-provinces/solution/
	 * 
	 * Runtime: 1 ms, faster than 73.08% of Java online submissions for Number of Provinces.
	 * Memory Usage: 51.8 MB, less than 6.56% of Java online submissions for Number of Provinces.
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public int findCircleNum(int[][] isConnected) {

		int[] visited = new int[isConnected.length];
		int count = 0;

		for (int i = 0; i < isConnected.length; i++) {
			if (visited[i] == 0) {
				dfs(isConnected, visited, i);
				count++;
			}

		}

		return count;

	}

	private void dfs(int[][] isConnected, int[] visited, int i) {

		for (int j = 0; j < isConnected.length; j++) {
			if (isConnected[i][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				dfs(isConnected, visited, j);
			}
		}

	}
}
