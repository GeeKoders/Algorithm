package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix {

	
	
	/*
	 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1388/
	 * solution: https://leetcode.com/problems/01-matrix/solution/
	 * 
	 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
	 * The distance between two adjacent cells is 1.
	 * 
	 * Example 1:
	 * Input:
	 * [[0,0,0],
	 *  [0,1,0],
	 *  [0,0,0]]
	 *  
	 * Output: 
	 * [[0,0,0],
	 * [0,1,0], 
	 * [0,0,0]]
	 * 
	 * Example 2:
	 * Input:
	 * [[0,0,0],
	 * [0,1,0],
	 * [1,1,1]]
	 * 
	 * Output:
	 * [[0,0,0],
	 * [0,1,0],
	 * [1,2,1]]
	 * 
	 * Note:
	 * 1.The number of elements of the given matrix will not exceed 10,000.
	 * 2.There are at least one 0 in the given matrix.
	 * 3.he cells are adjacent in only four directions: up, down, left and right.
	 * 
	 */
	public static void main(String[] args) {

		
		
	}
	
	public int[][] updateMatrix(int[][] matrix){
		
		int [][] dirs ={{0,1}, {0, -1},{1, 0},{-1, 0}} ;
		int r = matrix.length ;
		int c = matrix[0].length ;
		
		int[][] visited = new int[r][c] ;
		
		Queue<int[]> q = new LinkedList<>() ;
		
		for(int i=0; i < r; i++){
			for(int j=0; j < c ; j++){
				
				if(matrix[r][c] == 0){
					q.add(new int[]{i, j}) ;
					visited[i][j] = 1 ;
				}
				
			}
			
		}
		
		int step = 1 ;
		while(!q.isEmpty()){
			
			int size = q.size() ;
			
			for(int k=0; k<size; k++){
				
				int[] temp = q.poll() ;
				
				for(int[] dir: dirs){
					
					int x = temp[0] + dir[0] ;
					int y = temp[1] + dir[1] ;
					
					if(x>=0 && x<r && y>=0 && y<c && visited[x][y] == 0){
						visited[x][y] = 1 ;
						matrix[x][y] = step ;
						q.add(new int[]{x, y}) ;
					}
					
				}
				
			}
			
			step++ ;
		}
		return matrix ;
	}

}
