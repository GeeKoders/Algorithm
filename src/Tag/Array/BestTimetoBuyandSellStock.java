package Tag.Array;

public class BestTimetoBuyandSellStock {

	
	
	/*
	 * 121. Best Time to Buy and Sell Stock (Easy)
	 * 
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 * 
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
	 * 
	 * Runtime: 3 ms, faster than 22.65% of Java online submissions for Best Time to Buy and Sell Stock.
	 * 
	 * Memory Usage: 105.4 MB, less than 5.16% of Java online submissions for Best Time to Buy and Sell Stock.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length < 2) return 0 ;
            
        int min = prices[0] ;
        int max = 0 ;
        
        
        for(int i=1; i<prices.length; i++){
            
            min = Math.min(min, prices[i]) ;
            max = Math.max(max, prices[i] - min) ;
        }
        
        return max ;
        
    }
	
}
