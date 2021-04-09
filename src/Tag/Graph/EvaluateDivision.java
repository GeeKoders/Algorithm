package Tag.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	
	/*
	 * 399. Evaluate Division (Medium)
	 * 
	 * https://leetcode.com/problems/evaluate-division/
	 * 
	 * solution: https://leetcode.com/problems/evaluate-division/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=u9LE_7apB38&ab_channel=happygirlzt
	 * 
	 * Runtime: 1 ms, faster than 87.58% of Java online submissions for Evaluate Division.
	 * Memory Usage: 37.9 MB, less than 50.41% of Java online submissions for Evaluate Division.
	 * 
	 */
	public double[] calcEquation(List<List<String>> equations, double[] values,
			List<List<String>> queries) {

		Map<String, Map<String, Double>> g = new HashMap<>();

		buildGraph(g, equations, values);
		double[] res = new double[queries.size()];
		Arrays.fill(res, -1.0);

		int index = 0;
		for (List<String> q : queries) {
			String a = q.get(0);
			String b = q.get(1);

			if (!g.containsKey(a) || !g.containsKey(b)) {
				index++;
			} else {
				dfs(g, a, b, res, index, new HashSet<>(), 1.0);
				index++;
			}

		}

		return res;

	}

	private void dfs(Map<String, Map<String, Double>> g, String a, String b,
			double[] res, int index, Set<String> visited, double tmp) {
		visited.add(a);

		if (g.get(a) == null || g.get(a).size() == 0) {
			return;
		}

		if (g.get(a).containsKey(b)) {
			res[index] = g.get(a).get(b) * tmp;
			return;
		}

		for (String next : g.get(a).keySet()) {
			if (visited.contains(next))
				continue;
			dfs(g, next, b, res, index, visited, g.get(a).get(next) * tmp);
		}
	}

	private void buildGraph(Map<String, Map<String, Double>> g,
			List<List<String>> equations, double[] values) {

		int index = 0;
		for (List<String> e : equations) {
			String a = e.get(0);
			String b = e.get(1);
			g.putIfAbsent(a, new HashMap<>());
			g.putIfAbsent(b, new HashMap<>());
			g.get(a).put(b, values[index]);
			g.get(b).put(a, 1.0 / values[index]);
			index++;

			g.get(a).put(a, 1.0);
			g.get(b).put(b, 1.0);
		}

	}
}
