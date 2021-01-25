package Array;

import java.util.Arrays;

public class SquaresOfASortedArray {

	public static void main(String[] args) {
		
		SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray() ;
		int[] A = {-4,-1,0,3,10} ;
		int[] result = squaresOfASortedArray.solution1(A) ;
		
		for(int items: result){
			System.out.print(items + " ");
		}
	}

	public int[] solution1(int[] A) {

		for (int i = 0; i < A.length; i++) {
			A[i] = Math.abs(A[i]);
		}

		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] * A[i];
		}

		return A;
	}

}
