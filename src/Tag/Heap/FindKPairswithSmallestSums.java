package Tag.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {
	
	/*
	 * 373. Find K Pairs with Smallest Sums (Medium)
	 * 
	 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
	 * 
	 * reference: https://www.youtube.com/watch?v=APZbA_q1zAc&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
	 * 
	 * Runtime: 4 ms, faster than 78.36% of Java online submissions for Find K Pairs with Smallest Sums.
	 * Memory Usage: 40 MB, less than 59.59% of Java online submissions for Find K Pairs with Smallest Sums.
	 * 
	 * 
	 */
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		// return res
		List<List<Integer>> res = new ArrayList<>();
		// priority queue

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1]
				- b[0] - b[1]);

		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return res;

		for (int i = 0; i < nums1.length && i < k; i++) {
			pq.offer(new int[] { nums1[i], nums2[0], 0 });
		}

		while (!pq.isEmpty() && k-- > 0) {
			int[] cur = pq.poll();

			res.add(Arrays.asList(cur[0], cur[1]));
			if (cur[2] == nums2.length - 1)
				continue;
			pq.offer(new int[] { cur[0], nums2[cur[2] + 1], cur[2] + 1 });
		}
		return res;

	}
}
