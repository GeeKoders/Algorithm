package Tag.Graph;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestPathtoGetAllKeys {

	/*
	 * 864. Shortest Path to Get All Keys (Hard)
	 * 
	 * https://leetcode.com/problems/shortest-path-to-get-all-keys/
	 * 
	 * solution: https://leetcode.com/problems/shortest-path-to-get-all-keys/solution/
	 * 
	 * reference: 
	 * 
	 * Runtime: 14 ms, faster than 90.17% of Java online submissions for Shortest Path to Get All Keys.
	 * Memory Usage: 39.3 MB, less than 78.42% of Java online submissions for Shortest Path to Get All Keys.
	 * 
	 * Time complexity: O(m*n*2^k)
	 * Space complexity: O(m*n*2^k)
	 * 
	 * 
	 */
	public int shortestPathAllKeys(String[] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length();
        
        Deque<int[]> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cur = grid[i].charAt(j);
                if (cur == '@') {
                    q.offer(new int[]{i, j, 0, 0});
                } else if (cur >= 'a' && cur <= 'f') {
                    count++;
                }
            }
        }

        int keys = (1 << count) - 1;
        int[][][] visited = new int[m][n][keys + 1];
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int steps = cur[2];
            int key = cur[3];

            if (key == keys) return steps;
            for (int[] direction : directions) {
                int newX = direction[0] + x;
                int newY = direction[1] + y;

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX].charAt(newY) != '#') {
                    char ch = grid[newX].charAt(newY);
                    if (ch >= 'A' && ch <= 'F') {
                        if (((key >> (ch - 'A')) & 1) == 1 && visited[newX][newY][key] == 0) {
                            visited[newX][newY][key] = 1;
                            q.offer(new int[]{newX, newY, steps + 1, key});
                        }
                    }  else if (ch >= 'a' && ch <= 'f') {
                        int newKey = key | (1 << (ch - 'a'));
                        if (visited[newX][newY][newKey] == 0) {
                            visited[newX][newY][newKey] = 1;
                            q.offer(new int[]{newX, newY, steps + 1, newKey});
                        }
                    } else {
                        if (visited[newX][newY][key] == 0) {
                            visited[newX][newY][key] = 1;
                            q.offer(new int[]{newX, newY, steps + 1, key});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
