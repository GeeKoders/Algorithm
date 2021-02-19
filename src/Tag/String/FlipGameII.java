package Tag.String;

import java.util.HashMap;
import java.util.Map;

public class FlipGameII {

	/*
	 * 294. Flip Game II (Medium)
	 * 
	 * https://leetcode.com/problems/flip-game-ii/
	 * 
	 * discuss:
	 * 
	 * https://leetcode.com/problems/flip-game-ii/discuss/73962/Share-my-Java-backtracking-solution
	 * 
	 * Runtime: 92 ms, faster than 32.72% of Java online submissions for Flip Game II.
	 * Memory Usage: 39.5 MB, less than 52.76% of Java online submissions for Flip Game II.
	 * 
	 * 
	 */
	public boolean canWin(String s) {
        
        if(s == null || s.length() < 2){
            return false; 
        }
        
        for(int i=0; i< s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                String nextState = s.substring(0, i) + "--" + s.substring(i+2) ;
                
                if(!canWin(nextState)) return true; 
                
            }
        }
        
        return false ;
        
        
    }
	
	/*
	 * HashMap
	 * 
	 * Runtime: 11 ms, faster than 73.04% of Java online submissions for Flip Game II.
	 * Memory Usage: 40.3 MB, less than 24.88% of Java online submissions for Flip Game II.
	 * 
	 */
	public boolean canWin2(String s) {
	    if(s == null || s.length() < 2) return false;
	    Map<String, Boolean> map = new HashMap<>();
	    return canWin2(s, map);
	}

	public boolean canWin2(String s, Map<String, Boolean> map){
	    if(map.containsKey(s)) return map.get(s);
	    for(int i = 0; i < s.length() - 1; i++) {
	        if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
	            String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
	            if(!canWin2(opponent, map)) {
	                map.put(s, true);
	                return true;
	            }
	        }
	    }
	    map.put(s, false);
	    return false;
	}
}
