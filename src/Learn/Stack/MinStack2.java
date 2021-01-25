package Stack;

import java.util.Stack;

// your runtime beats 5.25% of java submissions
public class MinStack2 {

	private Stack<Integer> stack ;
	
	public MinStack2() {
		stack = new Stack<>() ;
	}
	
	public void push(int x){
		stack.push(x) ;
	}
	
	public Integer pop(){
		if(stack.empty()){
			return null ;
		}
		return stack.pop() ;
	}
	
	public int top(){
		return stack.peek() ;
	}
	
	public Integer getMin(){
		
		if(stack.empty()){
			return null ;
		}
		
		int index = stack.size() ;
		
		System.out.println("index:" + index);
		
		int min = Integer.MAX_VALUE ;

		for(int i=0;i<index; i++){
			if(stack.elementAt(i) < min){
				min = stack.elementAt(i) ;
			}
		}
		return min ;
	}
	 
	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(2);
		obj.push(0);
		obj.push(3);
		obj.push(0);
//		System.out.println(obj.getMin());
		obj.pop() ;
		obj.pop() ;
		obj.pop() ;
		System.out.println(obj.getMin());
//		System.out.println(obj.top());
//		System.out.println(obj.getMin());
	}
}
