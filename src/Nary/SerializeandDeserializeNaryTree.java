package Nary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.util.Pair;

public class SerializeandDeserializeNaryTree {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	
	/*
	 * https://leetcode.com/explore/learn/card/n-ary-tree/132/conclusion/924/
	 * 
	 * solution: https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/solution/
	 * 
	 * 
		37 / 37 test cases passed.
		Status: Accepted
		Runtime: 9 ms (Your runtime beats 54.89 % of java submissions.)
		Memory Usage: 41 MB
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
	}

	class Codec {
	    
	    class WrappableInt{
	        
	        private Integer value ;
	        public WrappableInt(Integer x){
	            this.value = x ;
	        }
	        
	        public Integer getValue(){
	            return this.value ;
	        }
	        
	        public void increment(){
	            this.value ++ ;
	        }
	        
	        
	    }
	    
	    class DeserializedObject extends HashMap<Integer, Pair<Integer, Pair<Integer, Node>>>{}
	    
	    
	    // Encodes a tree to a single string.
	    public String serialize(Node root) {
	        
	        
	        StringBuilder sb = new StringBuilder() ;
	        this._serializeHelper(root, sb, new WrappableInt(1), null) ;
	        return sb.toString();
	    }
	    
	    private void _serializeHelper(Node root, StringBuilder sb, WrappableInt identity, Integer parentId){
	        
	        if(root == null) return ;
	        
	        sb.append((char)(identity.getValue() + '0')) ;
	                  
	        sb.append((char)(root.val + '0')) ;         
	        sb.append((char)( parentId == null ? 'N' : parentId + '0')) ;         
	        parentId = identity.getValue() ;
	                  
	        for(Node child: root.children){
	            identity.increment() ;
	            this._serializeHelper(child, sb, identity, parentId) ;
	        }          
	                  
	        
	    }
		
	    // Decodes your encoded data to tree.
	    public Node deserialize(String data) {
	        
	        if(data.isEmpty()){
	            return null ;
	        }
	        DeserializedObject nodesAndParents = new DeserializedObject() ;
	        
	        for(int i=0; i<data.length(); i+=3){
	            int id = data.charAt(i) - '0' ;
	            int orgValue = data.charAt(i+1) - '0' ;
	            int parentId = data.charAt(i+2) - '0' ;
	            
	            Pair<Integer, Pair<Integer, Node>> node = new Pair<Integer, Pair<Integer, Node>>(orgValue, 
                        new Pair<Integer, Node>(parentId, 
                        new Node(orgValue, new ArrayList<Node>())));
	            nodesAndParents.put(id, node) ;
	        }
	        
	        for(int i = 3; i < data.length(); i+=3){
	        	
	        	int id = data.charAt(i) - '0' ;
	        	Node node = nodesAndParents.get(id).getValue().getValue();
	        	
	        	int parentId = data.charAt(i + 2) - '0' ;
	        	Node parentNode = nodesAndParents.get(parentId).getValue().getValue() ;
	        	
	        	parentNode.children.add(node) ;
	        }
	        return nodesAndParents.get(data.charAt(0) - '0').getValue().getValue() ;
	    }
	    
	    //approach 2
	    /*
	     * 
			37 / 37 test cases passed.
			Status: Accepted
			Runtime: 4 ms (Your runtime beats 86.83 % of java submissions.)
			Memory Usage: 40.9 MB
	     * 
	     * 
	     */
	    
	    // Encodes a tree to a single string.
	    public String serialize2(Node root) {
	        
	        StringBuilder sb = new StringBuilder();
	        this._serializeHelper(root, sb);
	        return sb.toString();
	    }
	    
	    private void _serializeHelper(Node root, StringBuilder sb) {
	        
	        if (root == null) {
	            return;
	        }
	        
	        // Add the value of the node
	        sb.append((char) (root.val + '0'));
	        
	        // Add the number of children
	        sb.append((char) (root.children.size() + '0'));
	        
	        // Recurse on the subtrees and build the 
	        // string accordingly
	        for (Node child : root.children) {
	            this._serializeHelper(child, sb);
	        }
	    }

	    // Decodes your encoded data to tree.
	    public Node deserialize2(String data) {
	        if(data.isEmpty())
	            return null;
	        
	        return this._deserializeHelper(data, new WrappableInt(0));
	    }
	    
	    private Node _deserializeHelper(String data, WrappableInt index) {  
	        
	        if (index.getValue() == data.length()) {
	            return null;
	        }
	        
	        // The invariant here is that the "index" always
	        // points to a node and the value next to it 
	        // represents the number of children it has.
	        Node node = new Node(data.charAt(index.getValue()) - '0', new ArrayList<Node>());
	        index.increment();
	        int numChildren = data.charAt(index.getValue()) - '0';
	        for (int i = 0; i < numChildren; i++) {
	            index.increment();
	            node.children.add(this._deserializeHelper(data, index));
	        }
	        
	        return node;
	    }
	    
	}

}
