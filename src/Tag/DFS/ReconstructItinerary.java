package Tag.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {
	
	/*
	 * 332. Reconstruct Itinerary (Medium)
	 * 
	 * https://leetcode.com/problems/reconstruct-itinerary/
	 * 
	 * solution: https://leetcode.com/problems/reconstruct-itinerary/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=kZXsB3WemYY&ab_channel=happygirlzt
	 * 
	 * Runtime: 5 ms, faster than 82.22% of Java online submissions for Reconstruct Itinerary.
	 * Memory Usage: 39.6 MB, less than 76.75% of Java online submissions for Reconstruct Itinerary.
	 * 
	 * Time complexity: O(|E|^d) where |E|¡ýE¡ý is the number of total flights and dd is the maximum number of flights from an airport.
	 * Space complexity: O(|V| + |E|)
	 * 
	 */
	public List<String> findItinerary(List<List<String>> tickets) {

		List<String> res = new ArrayList<>();
		Map<String, PriorityQueue<String>> g = new HashMap<>();
		buildGraph(tickets, g);
		Stack<String> stack = new Stack<>();
		dfs(g, stack, "JFK");

		while (!stack.isEmpty()) {
			res.add(stack.pop());
		}

		return res;
	}

	private void dfs(Map<String, PriorityQueue<String>> g, Stack<String> stack,
			String from) {

		PriorityQueue<String> arrivals = g.get(from);
		while (arrivals != null && !arrivals.isEmpty()) {
			String to = arrivals.poll();
			dfs(g, stack, to);
		}

		stack.push(from);

	}

	/*
	 * iterative
	 * 
	 * Runtime: 4 ms, faster than 99.64% of Java online submissions for Reconstruct Itinerary.
	 * Memory Usage: 39.4 MB, less than 93.82% of Java online submissions for Reconstruct Itinerary.
	 * 
	 */
	private void buildGraph2(List<List<String>> tickets,
			Map<String, PriorityQueue<String>> g) {

		for (List<String> travel : tickets) {

			String from = travel.get(0);
			String to = travel.get(1);

			if (!g.containsKey(from)) {
				g.put(from, new PriorityQueue<>());
			}

			g.get(from).offer(to);

		}

	}
	
	public List<String> findItinerary2(List<List<String>> tickets) {
        
        List<String> res = new ArrayList<>() ;
        Map<String, PriorityQueue<String>> g = new HashMap<>() ;
        buildGraph2(tickets, g) ;
        dfs(g, res, "JFK") ;
        
        return res ;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> g, List<String> res, String from){
        
        PriorityQueue<String> arrivals = g.get(from) ;
        while(arrivals != null && !arrivals.isEmpty()){
            String to = arrivals.poll() ;
            dfs(g, res, to) ;
        }
        
        res.add(0, from) ;
        
    }
    
    private void buildGraph(List<List<String>> tickets, Map<String, PriorityQueue<String>> g){
        
        for(List<String> travel: tickets){
            
            String from = travel.get(0) ;
            String to = travel.get(1) ;
            
            if(!g.containsKey(from)){
                g.put(from, new PriorityQueue<>()) ;
            }
            
            g.get(from).offer(to) ;
            
        }
        
        
    }
}
