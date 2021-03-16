package Tag.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {
	
	/*
	 * 721. Accounts Merge (Medium)
	 * 
	 * https://leetcode.com/problems/accounts-merge/
	 * 
	 * solution: https://leetcode.com/problems/accounts-merge/solution/
	 * 
	 * Runtime: 39 ms, faster than 54.51% of Java online submissions for Accounts Merge.
	 * Memory Usage: 45.9 MB, less than 41.42% of Java online submissions for Accounts Merge.
	 * 
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		Map<String, Set<String>> g = new HashMap<>();
		Map<String, String> emailToName = new HashMap<>();

		buildGraph(g, emailToName, accounts);
		List<List<String>> res = new ArrayList<>();
		Set<String> visited = new HashSet<>();

		for (String mail : emailToName.keySet()) {

			if (visited.add(mail)) {
				List<String> list = new ArrayList<>();
				list.add(mail);
				dfs(g, list, mail, visited);
				Collections.sort(list);
				list.add(0, emailToName.get(mail));
				res.add(list);
			}

		}

		return res;
	}

	private void buildGraph(Map<String, Set<String>> g,
			Map<String, String> emailToName, List<List<String>> accounts) {

		for (List<String> a : accounts) {
			String name = a.get(0);

			for (int i = 1; i < a.size(); i++) {

				String mail = a.get(i);

				emailToName.put(mail, name);
				g.putIfAbsent(mail, new HashSet<>());

				if (i == 1)
					continue;
				String prev = a.get(i - 1);
				g.get(prev).add(mail);
				g.get(mail).add(prev);

			}
		}
	}

	private void dfs(Map<String, Set<String>> g, List<String> list,
			String mail, Set<String> visited) {

		if (g.get(mail) == null || g.get(mail).size() == 0)
			return;

		for (String neighbour : g.get(mail)) {
			if (visited.add(neighbour)) {
				list.add(neighbour);
				dfs(g, list, neighbour, visited);
			}
		}

	}
}
