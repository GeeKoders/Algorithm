package Tag.Graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
	
	/*
	 * 797. All Paths From Source to Target (Medium)
	 * 
	 * https://leetcode.com/problems/all-paths-from-source-to-target/
	 * 
	 * https://leetcode.com/problems/all-paths-from-source-to-target/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=j8FVIC9HcE4&ab_channel=happygirlzt
	 * 
	 * Runtime: 2 ms, faster than 93.56% of Java online submissions for All Paths From Source to Target.
	 * Memory Usage: 40.3 MB, less than 95.59% of Java online submissions for All Paths From Source to Target.
	 * 
	 */
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		tmp.add(0);
		helper(res, graph, 0, tmp);

		return res;

	}

	private void helper(List<List<Integer>> res, int[][] graph, int cur,
			List<Integer> tmp) {

		if (cur == graph.length - 1) {
			res.add(new ArrayList(tmp));
		}

		for (int next : graph[cur]) {
			tmp.add(next);
			helper(res, graph, next, tmp);
			tmp.remove(tmp.size() - 1);
		}

	}
}
