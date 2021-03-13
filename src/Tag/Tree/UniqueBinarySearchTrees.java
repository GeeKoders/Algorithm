package Tag.Tree;

public class UniqueBinarySearchTrees {

	
	/*
	 * 96. Unique Binary Search Trees (Medium)
	 * 
	 * https://leetcode.com/problems/unique-binary-search-trees/
	 * 
	 * solution: https://leetcode.com/problems/unique-binary-search-trees/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=-rlQCg_TJac&ab_channel=JacobHuang
	 * 
	 * Runtime: 1969 ms, faster than 10.77% of Java online submissions for Unique Binary Search Trees.
	 * Memory Usage: 35.4 MB, less than 90.45% of Java online submissions for Unique Binary Search Trees.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(H)
	 * 
	 */
	public int numTrees(int n) {
        if(n <= 1) return 1 ;
        
        int res = 0 ;
        
        for(int i=0; i<n; i++){
            res+= numTrees(i) * numTrees(n - 1 - i );
        }
        
        return res ;
    }
	
}
