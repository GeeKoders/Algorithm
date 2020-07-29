package recursion;

public class Pow {

	
	/*
	 * https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
	 * 
	 * Implement pow(x, n), which calculates x raised to the power n (x^n).
	 * 
	 * Example 1:
	 * Input: 2.00000, 10
	 * Output: 1024.00000
	 * 
	 * Example 2:
	 * Input: 2.10000, 3
	 * Output: 9.26100
	 * 
	 * Example 3:
	 * Input: 2.00000, -2
	 * Output: 0.25000
	 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
	 * 
	 */
	
	public static void main(String[] args) {

	}
	
	//stackOverflow error
	public double myPow(double x, int n) {
        
        if(n == 0) return 1 ;
        if(n < 0) return 1 / (x * myPow(x, (Math.abs(n) - 1))) ;
        if(n > 0) return x * myPow(x, n - 1) ;
        
        return 0 ;
    }
	
	//brute force time exceed limit
	public double myPow2(double x, int n) {
		
		double val = 1.0;
        for (int i = 0; i < Math.abs(n); i++) val *= x;
        if (n < 0) return 1/val;
        return val;
		
	}

}
