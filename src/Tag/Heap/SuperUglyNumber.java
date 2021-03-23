package Tag.Heap;

import java.util.PriorityQueue;

public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {

		/*
		 * tuple int[3] 
		 * val -> current value ; 
		 * prime -> which link list 
		 * index -> how far has gone through
		 * 
		 * 313. Super Ugly Number (Medium)
		 * 
		 * https://leetcode.com/problems/super-ugly-number/
		 * 
		 * reference: https://www.youtube.com/watch?v=SMEdaKUFOq0
		 * 
		 * discuss: https://leetcode.com/problems/super-ugly-number/discuss/277313/My-view-of-this-question-hope-it-can-help-you-understand!!!
		 * 
		 * Runtime: 41 ms, faster than 41.63% of Java online submissions for Super Ugly Number.
		 * Memory Usage: 39 MB, less than 45.06% of Java online submissions for Super Ugly Number.
		 * 
		 * 
		 * Time complexity: O(nlogk)
		 * Space complexity: O(n+k)
		 * 
		 * 
		 */
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

		for (int i = 0; i < primes.length; i++) {
			pq.add(new int[] { primes[i], primes[i], 0 });
		}

		int[] dp = new int[n];
		dp[0] = 1;
		int i = 1;
		while (i < n) {

			int[] entry = pq.poll();

			int val = entry[0];
			int prime = entry[1];
			int index = entry[2];

			// avoid duplicates
			if (val != dp[i - 1]) {
				dp[i] = val;
				i++;
			}

			pq.add(new int[] { prime * dp[index + 1], prime, index + 1 });

		}

		return dp[n - 1];

	}
}
