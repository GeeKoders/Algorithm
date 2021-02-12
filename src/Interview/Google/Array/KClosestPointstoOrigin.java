package Interview.Google.Array;

import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

	/*
	 * 973. K Closest Points to Origin (Medium)
	 * 
	 * https://leetcode.com/problems/k-closest-points-to-origin/
	 * 
	 * https://leetcode.com/problems/k-closest-points-to-origin/solution/
	 * 
	 * discuss:
	 * 
	 * https://leetcode.com/problems/k-closest-points-to-origin/discuss/218888/Java-Priority-Queue-Easy-to-Understand
	 * 
	 * https://leetcode.com/problems/k-closest-points-to-origin/discuss/576025/Python-3-lines-kNN-search-using-kd-tree-(for-large-number-of-queries)
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=eaYX0Ee0Kcg&ab_channel=CSDojo
	 * 
	 * Your runtime beats 70.65 % of java submissions.
	 * Your memory usage beats 44.01 % of java submissions.
	 * 
	 * Time complexity: O(Nlogn) +O(K)
	 * Space complexity: O(N)
	 * 
	 */
	public int[][] kClosest(int[][] points, int K) {

		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1]
				* a[1])
				- (b[0] * b[0] + b[1] * b[1]));
		int[][] res = new int[K][2];
		int index = 0;
		for (int[] arr : points) {
			queue.add(arr);
		}
		while (index < K) {
			res[index] = queue.poll();
			index++;
		}
		return res;

	}
}
