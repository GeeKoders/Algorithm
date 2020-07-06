package Array;

public class SortArrayByParity {

	/*
	 * Given an array A of non-negative integers, return an array consisting of
	 * all the even elements of A, followed by all the odd elements of A.
	 * 
	 * You may return any answer array that satisfies this condition.
	 * 
	 * Example 1: 
	 * Input: [3,1,2,4] 
	 * Output: [2,4,3,1] 
	 * The outputs [4,2,3,1],[2,4,1,3], and [4,2,1,3] would also be accepted.
	 * 
	 * Note:
	 * 
	 * 1 <= A.length <= 5000 
	 * 0 <= A[i] <= 5000
	 */

	public static void main(String[] args) {

		SortArrayByParity sortArrayByParity = new SortArrayByParity() ;
		int[] A = {3,1,2,4} ;
		int[] result = sortArrayByParity.solution1(A) ;
		
		for(int items: result){
			System.out.print(items + " ");
		}
		
	}
	
	public int[] solution1(int[] A) {
        
        int count = 0 ;
        for(int i=count; i<A.length; i++){
            
            if(A[i] % 2 == 0){
               swap(A, count, i) ;
               count ++ ;
            }
            
        }
        
        return A ;
        
    }
    
    public void swap(int[] A, int i, int j){
        int temp = A[i] ;
        A[i] = A[j] ;
        A[j] = temp ;
    }

}
