package Tag.String;

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
}
