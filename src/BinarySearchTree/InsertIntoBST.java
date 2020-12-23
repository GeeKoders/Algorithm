package BinarySearchTree;

public class InsertIntoBST {

	class TreeNode{
		
		int val ;
		TreeNode left ;
		TreeNode right ;
		
		public TreeNode(int val){
			this.val = val ;
		}
		
	}
	
	/*
	 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
	 * 
	 * solution: https://leetcode.com/problems/insert-into-a-binary-search-tree/solution/
	 * 
	 */
	
	// time complexity: O(logN) in the average case, and O(N) in the worst case.
	// space complexity: O(logN) in the average case, and O(N) in the worst case.
	public TreeNode insertIntoBST(TreeNode root, int val) {
        
        return insert(root, val) ;
    }
    
    public TreeNode insert(TreeNode root, int val){
        
        if(root == null) return new TreeNode(val) ;
        
        if(val < root.val){
            root.left = insert(root.left, val) ;
        }else{
            root.right = insert(root.right, val) ;
        }
        return root ;   
    }
    
    // approach2: iteration
    
    // time complexity: O(logN) in the average case, and O(N) in the worst case.
    // space complexity: O(1)
    public TreeNode insertIntoBST2(TreeNode root, int val) {
    	
    	TreeNode curr = root ;
    	
    	while(curr != null){
    		
    		if(val > curr.val){
    			
    			if(curr.right == null){
    				
    				curr.right = new TreeNode(val) ;
    				
    				return root ;
    			}else{
    				curr = curr.right ;
    			}
    			
    			
    		}else{
    			
    			if(curr.left == null){
    				curr.left = new TreeNode(val) ;
    				return root ;
    			}else{
    				curr = curr.left ;
    			}
    		}
    		
    	}
    	
    	return new TreeNode(val) ;
    	
    }
	
}
