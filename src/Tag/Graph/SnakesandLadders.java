package Tag.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesandLadders {

	
	/*
	 * 909. Snakes and Ladders (Medium)
	 * 
	 * https://leetcode.com/problems/snakes-and-ladders/
	 * 
	 * solution: https://leetcode.com/problems/snakes-and-ladders/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=0psTRx1FxPQ&ab_channel=happygirlzt
	 * 
	 * Runtime: 7 ms, faster than 49.71% of Java online submissions for Snakes and Ladders.
	 * Memory Usage: 39 MB, less than 68.21% of Java online submissions for Snakes and Ladders.
	 * 
	 * Time complexity: O(N*N)
	 * Space complexity: O(N*N)
	 * 
	 */
	public int snakesAndLadders(int[][] board) {

		if (board == null || board.length == 0)
			return 0;

		int n = board.length;
		boolean[] visited = new boolean[n * n + 1];
		int min = n * n;

		Queue<Integer> q = new LinkedList<>();

		q.offer(1);

		int moves = 0;

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {
				int cur = q.poll();

				if (cur == n * n) {
					min = Math.min(min, moves);
				}

				for (int j = 1; j <= 6; j++) {

					int num = cur + j;

					if (num > n * n)
						break;

					if (num == cur)
						continue;
					int row = n - (num - 1) / n - 1;
					int col = (n - row) % 2 != 0 ? (num - 1) % n : n
							- (num - 1) % n - 1;

					if (!visited[num]) {

						visited[num] = true;

						if (board[row][col] == -1) {
							q.offer(num);
						} else {
							q.offer(board[row][col]);
						}

					}

				}

			}

			moves++;

		}

		return min == n * n ? -1 : min;

	}
}
