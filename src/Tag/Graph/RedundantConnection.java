package Tag.Graph;

public class RedundantConnection {
	
	/*
	 * 684. Redundant Connection (Medium)
	 * 
	 * https://leetcode.com/problems/redundant-connection/
	 * 
	 * reference: 
	 * 
	 * https://www.youtube.com/watch?v=jlhPbnxQ2IU&ab_channel=happygirlzt
	 * 
	 * https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
	 * 
	 * Runtime: 1 ms, faster than 59.88% of Java online submissions for Redundant Connection.
	 * Memory Usage: 39.3 MB, less than 43.00% of Java online submissions for Redundant Connection.
	 * 
	 * 
	 */
	class DSU {

		int[] root;
		int[] size;

		public DSU(int n) {
			root = new int[n];
			size = new int[n];

			for (int i = 0; i < n; i++) {
				root[i] = i;
			}

		}

		public int find(int x) {
			if (root[x] != x) {
				root[x] = find(root[x]);
			}

			return root[x];
		}

		public boolean union(int x, int y) {

			int rootX = find(x);
			int rootY = find(y);

			if (rootX == rootY)
				return false;

			if (size[rootX] < size[rootY]) {
				root[rootX] = rootY;
				size[rootY]++;
			} else {
				root[rootY] = rootX;
				size[rootX]++;
			}

			return true;

		}

	}

	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		DSU dsu = new DSU(n + 1);

		for (int[] e : edges) {
			if (!dsu.union(e[0], e[1])) {
				return e;
			}
		}

		return new int[0];

	}
}
