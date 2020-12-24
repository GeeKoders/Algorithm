package BinarySearchTree;


public class BinarySearchTree {

	
	class Tree{
		
		int val ;
		Tree left ;
		Tree right ;
		
		public Tree(int val){
			this.val = val ;
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree() ;
		bst.insertTree(32);
		bst.insertTree(10);
		bst.insertTree(55);
		bst.insertTree(1);
		bst.insertTree(19);
		bst.insertTree(79);
		bst.insertTree(16);
		bst.insertTree(23);
		
		bst.inorderTraversal() ;
		System.out.println();
		System.out.println("Max:" + bst.getMax());
		System.out.println("Min:" + bst.getMin());
		System.out.println("root" + bst.getRoot().val);
		System.out.println(bst.getPredecessor(bst.getRoot().left)); //23
		System.out.println(bst.getSuccessor(bst.getRoot().right)); //55
		bst.preorderTraversal() ;
		System.out.println();
		bst.postorderTraversal();
	}
	
	private Tree root ;
	
	public Tree getRoot(){
		return this.root ;
	}
	
	public Integer getMax(){
		
		if(root == null) return null ;
		
		Tree curr = root ;
		while(curr.right != null){
			curr = curr.right ;
		}
		
		return curr.val ;
	}
	
	public Integer getMin(){
		
		if(root == null) return null ;
		
		Tree curr = root ;
		while(curr.left != null){
			curr = curr.left ;
		}
		
		return curr.val ;
	}
	
	public void inorderTraversal(){
		
		if(root == null) return ;
		
		inorder(root) ;
		
	}

	private void inorder(Tree root) {

		Tree curr = root ;
		
		if(curr.left != null){
			inorder(curr.left) ;
		}
		System.out.print(curr.val + "-->");
		
		if(curr.right != null){
			inorder(curr.right) ;
		}
		
	}
	
	public void preorderTraversal(){
		
		if(root == null) return ;
		
		preorder(root) ;
		
	}

	private void preorder(Tree root) {
		
		Tree curr = root; 
		
		System.out.print(curr.val + "-->");
		
		if(curr.left != null){
			preorder(curr.left) ;
		}
		
		if(curr.right != null){
			preorder(curr.right) ;
		}
	}
	
	public void postorderTraversal(){
		
		if(root == null) return ;
		
		postorder(root) ;
		
	}

	private void postorder(Tree root) {
		
		Tree curr = root ;
		
		if(curr.left != null){
			postorder(curr.left) ;
		}
		
		if(curr.right != null){
			postorder(curr.right) ;
		}
		
		System.out.print(curr.val + "-->");
		
	}
	
	public Integer getSuccessor(Tree root){
		
		if(root == null) return null ;
		
		Tree curr = root ;
		
		if(curr.left != null){
			return getSuccessor(curr.left) ;
		}
		
		return curr.val ;
	}

	
	public Integer getPredecessor(Tree root){
		
		if(root == null) return null ;
		
		Tree curr = root ;
		
		if(curr.right != null){
			return getPredecessor(curr.right) ;
		}
		return curr.val ;
	}
	
	public void insertTree(int val){
		
		if(root == null) {
			root = new Tree(val) ;
		}else{
			insert(root, val) ;
		}
		
		
		
	}

	private void insert(Tree root, int val) {
		
		Tree curr = root ;
		while(curr != null){
			if(val < curr.val){
				if(curr.left == null){
					curr.left = new Tree(val) ;
					return ;
				}else{
					curr = curr.left ;
				}
				
			}else{
				if(curr.right == null){
					curr.right = new Tree(val) ;
					return ;
				}else{
					curr = curr.right ;
				}
			}
		}
		
	}
	
	
	
}
