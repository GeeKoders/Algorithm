package Tag.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsinaNetwork {

	
	/*
	 * 1192. Critical Connections in a Network (Hard)
	 * 
	 * https://leetcode.com/problems/critical-connections-in-a-network/
	 * 
	 * solution: https://leetcode.com/problems/critical-connections-in-a-network/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=kYcUIEQqL2Y&ab_channel=happygirlzt
	 * 
	 * Runtime: 89 ms, faster than 83.48% of Java online submissions for Critical Connections in a Network.
	 * Memory Usage: 104 MB, less than 66.60% of Java online submissions for Critical Connections in a Network.
	 * 
	 * Time complexity: O(V+E)
	 * Space complexity: O(E)
	 * 
	 */
	int time = -1;

	public List<List<Integer>> criticalConnections(int n,
			List<List<Integer>> connections) {

		List<List<Integer>> res = new ArrayList<>();

		List<Integer>[] graph = new List[n];

		buildGraph(graph, connections);

		int[] disc = new int[n];
		int[] low = new int[n];
		int[] parents = new int[n];

		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);
		Arrays.fill(parents, -1);

		for (int i = 0; i < n; i++) {

			if (disc[i] == -1) {
				dfs(i, parents, low, disc, res, graph);
			}
		}

		return res;

	}

	private void dfs(int u, int[] parents, int[] low, int[] disc,
			List<List<Integer>> res, List<Integer>[] graph) {
		if (disc[u] != -1)
			return;

		low[u] = disc[u] = time++;

		for (int v : graph[u]) {
			if (disc[v] == -1) {
				parents[v] = u;
				dfs(v, parents, low, disc, res, graph);
				if (low[v] > disc[u]) {
					res.add(Arrays.asList(u, v));
				}

				low[u] = Math.min(low[u], low[v]);

			} else if (parents[u] != v) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}

	}

	private void buildGraph(List<Integer>[] graph,
			List<List<Integer>> connections) {

		for (List<Integer> c : connections) {

			int a = c.get(0);
			int b = c.get(1);

			if (graph[a] == null) {
				graph[a] = new ArrayList<>();
			}
			if (graph[b] == null) {
				graph[b] = new ArrayList<>();
			}

			graph[a].add(b);
			graph[b].add(a);

		}

	}
}
