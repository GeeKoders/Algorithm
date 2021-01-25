package BinarySearchTree;

import java.util.PriorityQueue;

public class KthLargestSolution2 {
	class Node {

		public int val;
		public Node left;
		public Node right;

		public Node(int val, int cnt) {
			this.val = val;
		}

	}
	
	/*
	 * https://leetcode.com/submissions/detail/434987315/?from=explore&item_id=1018
	 * 
	 * solution: https://leetcode.com/submissions/detail/434987315/?from=explore&item_id=1018
	 * 
	 * 
		10 / 10 test cases passed.
		Status: Accepted
		Runtime: 21 ms (better solution)
		Memory Usage: 49.4 MB
	 * 
	 * time complexity: the wrost case is O(N^2) and O(NlogN) ideally
	 *  
	 */

	public static void main(String[] args) {

		int k = 3;
		int[] nums = { 4, 5, 8, 2 };

		KthLargestSolution2 obj = new KthLargestSolution2(k, nums);
		System.out.println(obj.add(3)); // return 4
		System.out.println(obj.add(5)); // return 5
		System.out.println(obj.add(10)); // return 5
		System.out.println(obj.add(9)); // return 8
		System.out.println(obj.add(4)); // return 8
	}

	private int toFind;

	private PriorityQueue<Integer> q ;
	

	public KthLargestSolution2(int k, int[] nums) {
		
		toFind = k ;
		q = new PriorityQueue<Integer>(k) ;
		
		for(int a: nums){
			add(a) ;
		}
		
	}

	public int add(int val) {
		
		if(q.size() < toFind){
			q.offer(val) ;
		}else{
			if (q.peek() < val) {
                q.poll();
                q.offer(val);
            }
		}
		
		
		return q.peek() ;
	}

}
