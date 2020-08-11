package Queue;

import java.util.Arrays;

public class PerfectSquares {

	/*
	 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * 
	 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/
	 * 
	 * Example 1:
	 * Input: n = 12
	 * Output: 3 
	 * Explanation: 12 = 4 + 4 + 4.
	 * 
	 * Example 2:
	 * Input: n = 13
	 * Output: 2
	 * Explanation: 13 = 4 + 9.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		PerfectSquares perfectSquares = new PerfectSquares() ;
		System.out.println(perfectSquares.numSquares(13));
	}
	
	
	// 12
    // 1, 4, 9
    // 1 + minSquares(12-1)
    // 4 + minSquares(12-4) = 4 + 1 + minSquares(8 - 1)
    //                      = 4 + 4 + minSquares(8 - 4)
                                
    public int numSquares(int n) {
        
        int [] dp = new int[n+1] ;
        Arrays.fill(dp , n) ;//15, 15 * 1
        dp[0] = 0 ;
        dp[1] = 1 ;
        
        for(int items: dp){
            System.out.println("items:" + items) ;
        }
        
        for(int i=1; i<=n ;i++){
            
            for(int j=1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1) ;
                System.out.println("dp[" + i + "]:" + dp[i]);
            }
            
        }
        return dp[n] ;            
        
    }
}
