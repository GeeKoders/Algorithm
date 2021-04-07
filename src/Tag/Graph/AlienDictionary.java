package Tag.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
	
	
	/*
	 * 269. Alien Dictionary (Hard)
	 * 
	 * https://leetcode.com/problems/alien-dictionary/
	 * 
	 * solution: https://leetcode.com/problems/alien-dictionary/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=RIrTuf4DfPE&ab_channel=happygirlzt
	 * 
	 * Runtime: 3 ms, faster than 82.52% of Java online submissions for Alien Dictionary.
	 * Memory Usage: 38.2 MB, less than 63.23% of Java online submissions for Alien Dictionary.
	 * 
	 */
	public String alienOrder(String[] words) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		int[] inDegree = new int[26];
		buildGraph(graph, inDegree, words);
		return bfs(graph, inDegree);
	}

	private void buildGraph(Map<Character, Set<Character>> graph,
			int[] inDegree, String[] words) {
		for (String s : words) {
			for (char c : s.toCharArray()) {
				graph.putIfAbsent(c, new HashSet<>());
			}
		}

		for (int i = 1; i < words.length; i++) {
			String first = words[i - 1];
			String second = words[i];
			int len = Math.min(first.length(), second.length());
			for (int j = 0; j < len; j++) {
				char out = first.charAt(j);
				char in = second.charAt(j);
				if (out != in) {
					if (!graph.get(out).contains(in)) {
						graph.get(out).add(in);
						inDegree[in - 'a']++;
					}
					break;
				}

				// Thanks for @Jay He
				if (j + 1 == len && first.length() > second.length()) {
					graph.clear();
					return;
				}
			}
		}
	}

	private String bfs(Map<Character, Set<Character>> graph, int[] inDegree) {
		StringBuilder sb = new StringBuilder();
		Queue<Character> q = new LinkedList<>();
		for (char c : graph.keySet()) {
			if (inDegree[c - 'a'] == 0) {
				q.offer(c);
			}
		}

		while (!q.isEmpty()) {
			char out = q.poll();
			sb.append(out);
			for (char in : graph.get(out)) {
				inDegree[in - 'a']--;
				if (inDegree[in - 'a'] == 0) {
					q.offer(in);
				}
			}
		}

		return sb.length() == graph.size() ? sb.toString() : "";
	}
}
