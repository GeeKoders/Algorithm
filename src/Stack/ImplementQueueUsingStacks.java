package Stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	/*
	 * Implement the following operations of a queue using stacks.
	 * solution: https://leetcode.com/problems/implement-queue-using-stacks/solution/
	 * 
	 * push(x) -- Push element x to the back of queue.
	 * pop() -- Removes the element from in front of queue.
	 * peek() -- Get the front element.
	 * empty() -- Return whether the queue is empty.
	 * 
	 * Example:
	 * MyQueue queue = new MyQueue();
	 * queue.push(1);
	 * queue.push(2);
	 * queue.peek();  // returns 1
	 * queue.pop();   // returns 1
	 * queue.empty(); // returns false
	 * 
	 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
	 * 
	 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended
	 * queue), as long as you use only standard operations of a stack.
	 * 
	 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
	 * 
	 */
	
	public Stack<Integer> stack1 ;
	
	public Stack<Integer> stack2 ;
	/** Initialize your data structure here. */
	public ImplementQueueUsingStacks() {
        stack1 = new Stack<Integer>() ;
        stack2 = new Stack<Integer>() ;
    }
	/** Push element x to the back of queue. */
	public void push(int x) {
		
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop()) ;
		}
        stack2.push(x) ;
        
        while(!stack1.isEmpty()){
        	stack2.push(stack1.pop()) ;
        }
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    
        if(stack2.isEmpty()){
            return -1 ;
        }
        return stack2.pop() ;
    }
    
    /** Get the front element. */
    public int peek() {
        return stack2.peek() ;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty() ;
    }
	
	public static void main(String[] args) {
		ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks() ;
		obj.push(1);
		obj.push(2);
		System.out.println(obj.pop());
		System.out.println(obj.peek());
	}
}
