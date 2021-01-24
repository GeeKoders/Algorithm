package recursionII;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	
	/*
	 * 46. Permutations (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2903/
	 * 
	 * solution: https://leetcode.com/problems/permutations/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=T909rebQJ70&feature=youtu.be&ab_channel=happygirlzt
	 * 
	 */
	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> res = new ArrayList();
		if (nums.length < 1)
			return res;

		helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums,
			boolean[] visited) {

		if (cur.size() == nums.length) {
			res.add(new ArrayList(cur));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (visited[i])
				continue;
			cur.add(nums[i]);
			visited[i] = true;
			helper(res, cur, nums, visited);
			cur.remove(cur.size() - 1);
			visited[i] = false;
		}

	}
}
