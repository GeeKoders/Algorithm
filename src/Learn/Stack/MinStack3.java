package Stack;

import java.util.Stack;

// your runtime beats 75.84% of java submissions
public class MinStack3 {
	
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
