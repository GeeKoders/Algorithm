package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	
	
	/*
	 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/
	 * solution: https://leetcode.com/articles/pascals-triangle/
	 * 
	 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
	 * 
	 */
	public static void main(String[] args) {

	}
	
	public List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> output = new ArrayList<List<Integer>>() ;
		
		for(int i=0; i<numRows; i++){
			
			List<Integer> currentList = new ArrayList<Integer>() ;
			
			for(int j=0; j<i+1; j++){
				if(j==0 || j== i){
					currentList.add(1) ;
				}else{
					currentList.add(output.get(i-1).get(j-1) + output.get(i-1).get(j)) ;
				}
			}
			
			output.add(currentList) ;
			
		}
		return output ;
	}

}
