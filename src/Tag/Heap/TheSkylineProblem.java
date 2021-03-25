package Tag.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;


/*
 * 218. The Skyline Problem (Hard)
 * 
 * https://leetcode.com/problems/the-skyline-problem/
 * 
 * solution: https://leetcode.com/problems/the-skyline-problem/solution/
 * 
 * reference: https://www.youtube.com/watch?v=tQiXaCT0ndE&ab_channel=happygirlzt
 * 
 * Runtime: 20 ms, faster than 62.83% of Java online submissions for The Skyline Problem.
 * Memory Usage: 42.4 MB, less than 45.96% of Java online submissions for The Skyline Problem.
 * 
 */
public class TheSkylineProblem {

	public List<List<Integer>> getSkyline(int[][] buildings) {
        
	       TreeMap<Integer, List<int[]>> map = new TreeMap<>();
	        for (int[] b : buildings) {
	            map.putIfAbsent(b[0], new ArrayList<>());
	            map.putIfAbsent(b[1], new ArrayList<>());
	            map.get(b[0]).add(b);
	            map.get(b[1]).add(b);
	        }
	        
	        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
	        List<List<Integer>> res = new ArrayList<>();
	        
	        for (int a : map.keySet()) {
	            List<int[]> bs = map.get(a);
	            for (int[] b : bs) {
	                if (b[0] == a) {
	                    maxHeap.offer(b);
	                } else {
	                    maxHeap.remove(b);
	                }
	            }
	            
	            if (maxHeap.size() == 0) {
	                List<Integer> tmp = new ArrayList<>();
	                tmp.add(a);
	                tmp.add(0);
	                res.add(tmp);
	            } else {
	                int maxHeight = maxHeap.peek()[2];
	                
	                if (res.size() == 0 || res.get(res.size() - 1).get(1) != maxHeight) {
	                    List<Integer> tmp = new ArrayList<>();
	                    tmp.add(a);
	                    tmp.add(maxHeight);
	                    res.add(tmp);
	                }
	            }
	        }
	        
	        return res;
	        
	        
	    }
	
	
	
}
