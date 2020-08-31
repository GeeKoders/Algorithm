package BinarySearch;

public class ValidPerfectSquare {

	/*
	 * https://leetcode.com/explore/learn/card/binary-search/137/conclusion/978/
	 * 
	 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
	 * Follow up: Do not use any built-in library function such as sqrt.
	 * 
	 * Example 1:
	 * Input: num = 16
	 * Output: true
	 * 
	 * Example 2:
	 * Input: num = 14
	 * Output: false
	 * 
	 * Constraints:
	 * 1 <= num <= 2^31 - 1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// time limit exceeded
	public boolean isPerfectSquare(int num) {
        
        int i = 1 ;
        int sum = 0 ;
        while(sum<=num){
            i+=2 ;
            if(i == num) return true;
        }
        
        return false ;
        
    }
	
	public boolean isPerfectSquare2(int num) {
        
        int i = 1 ;
        int rediual = num ;
        while(rediual > 0){
            rediual = rediual - i ; 
            i+=2 ;
        }
        if(rediual == 0) return true ;
        return false ;
        
    }

}
