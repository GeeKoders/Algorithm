package Stack;

import java.util.ArrayList;
import java.util.List;
/*
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 */
public class MinStack {

	private List<Integer> data;

	public MinStack() {
		this.data = new ArrayList<>();
	}
	
	public void push(int x) {
        data.add(x) ;    
    }
    
    public void pop() {
        if(data.isEmpty()){
            return ;
        }
        data.remove(data.size() - 1) ;
        
    }
    
    public int top() {
        return data.get(data.size() - 1) ;    
    }
    
    
    
    public Integer getMin() {
        
        if(data.isEmpty()){
            return null ;
        }
        
        int index = data.size() ;
        int min = Integer.MAX_VALUE ;
        
        for(int i=0 ;i<index; i++){
        	if(data.get(i) < min ){
        		min = data.get(i) ;
        	}
        }
        
        return min ;
    }
    // beats 5.69% of java submissions
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
