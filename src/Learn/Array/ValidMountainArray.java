package Array;

public class ValidMountainArray {

	/*
	 * Given an array A of integers, return true if and only if it is a valid
	 * mountain array.
	 * 
	 * Recall that A is a mountain array if and only if:
	 * 
	 * A.length >= 3 There exists some i with 0 < i < A.length - 1 such that:
	 * A[0] < A[1] < ... A[i-1] < A[i] A[i] > A[i+1] > ... > A[A.length - 1]
	 * 
	 * Example 1: 
	 * Input: [2,1] Output: false
	 * 
	 * Example 2: 
	 * Input: [3,5,5] Output: false
	 * 
	 * Example 3: 
	 * Input: [0,3,2,1] Output: true
	 * 
	 */

	public static void main(String[] args) {

		ValidMountainArray validMountainArray = new ValidMountainArray() ;
		int[] A = {1,3,4,2} ;
		boolean result = validMountainArray.solution1(A) ;
		System.out.println(result);
	}
	
	 public boolean solution1(int[] A) {
	        
	        int N = A.length;
	        int i = 0;

	        if(N < 3) return false ;
	        
	        // walk up
	        while (i+1 < N && A[i] < A[i+1])
	            i++;

	        // peak can't be first or last
	        if (i == 0 || i == N-1)
	            return false;

	        // walk down
	        while (i+1 < N && A[i] > A[i+1])
	            i++;

	        return i == N-1;
	        
	        
	    }

}
