package Learn.Stack;

import java.util.Stack;


public class MinStack3 {

	
	/*
	 * 155. Min Stack (Easy)
	 * 
	 * https://leetcode.com/problems/min-stack/
	 * 
	 * solution: https://leetcode.com/problems/min-stack/solution/
	 * 
	 * Runtime: 5 ms, faster than 58.98% of Java online submissions for Min Stack.
     * Memory Usage: 40.6 MB, less than 72.44% of Java online submissions for Min Stack.
	 * 
	 * 
	 * Time complexity: O(1)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	Stack<Integer> stack ;
	Stack<Integer> minStack ;

	public MinStack3() {
		this.stack = new Stack<>() ;
		this.minStack = new Stack<>() ;
	}
	
	public void push(int x){
		stack.push(x) ;
		
		if(minStack.empty()){
			minStack.push(x) ;
		}else{
			if(x <= minStack.peek()){
				minStack.push(x) ;
			}
		}
	}
	
	public void pop(){
		
		if(stack.isEmpty()) return ;
		
		if(stack.pop().equals(minStack.peek())){
			minStack.pop();
		}
	}
	
	public int top(){
		return stack.peek() ;
	}
	
	public int getMin(){
		return minStack.peek() ;
	}
	
	public static void main(String[] args) {
		MinStack3 obj = new MinStack3();
		obj.push(2);
		obj.push(0);
		obj.push(3);
		obj.push(0);
		obj.pop() ;
		obj.pop() ;
		obj.pop() ;
		System.out.println(obj.getMin());
	}

}
