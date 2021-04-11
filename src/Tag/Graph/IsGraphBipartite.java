package Tag.Graph;

public class IsGraphBipartite {
	
	
	/*
	 * 785. Is Graph Bipartite? (Medium)
	 * 
	 * https://leetcode.com/problems/is-graph-bipartite/
	 * 
	 * solution: https://leetcode.com/problems/is-graph-bipartite/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=Gmp51E8HVVs&ab_channel=happygirlzt
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Graph Bipartite?.
	 * Memory Usage: 51.5 MB, less than 6.93% of Java online submissions for Is Graph Bipartite?.
	 * 
	 */
	// DFS
	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] colors = new int[n];

		for (int i = 0; i < n; i++) {
			if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
				return false;
			}
		}

		return true;
	}

	private boolean validColor(int[][] graph, int[] colors, int color, int node) {
		if (colors[node] != 0) {
			return colors[node] == color;
		}

		colors[node] = color;
		for (int next : graph[node]) {
			if (!validColor(graph, colors, -color, next)) {
				return false;
			}
		}

		return true;
	}
}
