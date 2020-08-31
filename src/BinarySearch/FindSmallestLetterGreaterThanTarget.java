package BinarySearch;

public class FindSmallestLetterGreaterThanTarget {

	
	/*
	 * https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/
	 * solution: https://leetcode.com/problems/find-smallest-letter-greater-than-target/solution/
	 * 
	 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the
	 * list that is larger than the given target.
	 * 
	 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
	 * 
	 * Examples:
	 * Input:
	 * letters = ["c", "f", "j"]
	 * target = "a"
	 * Output: "c"
	 * 
	 * Input:
	 * letters = ["c", "f", "j"]
	 * target = "k"
	 * Output: "c"
	 * 
	 * Note:
	 * 1. letters has a length in range [2, 10000].
	 * 2. letters consists of lowercase letters, and contains at least 2 unique letters.
	 * 3. target is a lowercase letter.
	 * 
	 */
	
	public static void main(String[] args) {

	}
	
	public char nextGreatestLetter(char[] letters, char target) {
        
        for(char c: letters){
            
            if(c > target) return c ;
            
        }
        return letters[0] ;
        
    }
	//time limit exceeded
	public char nextGreatestLetter2(char[] letters, char target) {
        
        int left = 0 ; 
        int right = letters.length - 1 ;
        if(target > letters[right]) return letters[0] ;
        
        while(left<=right){
            
            int mid = left + (right - left) / 2 ;
            
            if(letters[mid] == target) return letters[mid + 1] ;
            
            if(letters[mid] < target){
                left = mid + 1 ;
            }else{
                right = mid ;
            }
            
        }
        
        return letters[0] ;
        
    }
	

}
