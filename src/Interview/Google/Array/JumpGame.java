package Interview.Google.Array;

public class JumpGame {

	
	// solution is good to think about
	/*
	 * 55. Jump Game
	 * 
	 * https://leetcode.com/problems/jump-game/
	 * 
	 * solution: https://leetcode.com/problems/jump-game/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=Zb4eRjuPHbM&ab_channel=NickWhite
	 * 
	 * Runtime: 1 ms, faster than 86.48% of Java online submissions for Jump Game.
	 * Memory Usage: 43.4 MB, less than 13.77% of Java online submissions for Jump Game.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
    public boolean canJump(int[] nums) {
        
        int lastIndex = nums.length - 1 ;
        
        for(int i=nums.length - 1; i>=0; i--){
            
            if(i + nums[i] >= lastIndex){
                lastIndex = i ;
            }
        }
        
        return lastIndex == 0 ;
        
        
    }
	
}
