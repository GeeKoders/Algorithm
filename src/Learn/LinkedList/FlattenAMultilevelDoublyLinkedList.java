package LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenAMultilevelDoublyLinkedList {

	/*
	 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1225/
	 * 
	 * You are given a doubly linked list which in addition to the next and
	 * previous pointers, it could have a child pointer, which may or may not
	 * point to a separate doubly linked list. These child lists may have one or
	 * more children of their own, and so on, to produce a multilevel data
	 * structure, as shown in the example below.
	 * 
	 * Flatten the list so that all the nodes appear in a single-level, doubly
	 * linked list. You are given the head of the first level of the list.
	 * 
	 * Example 1:
	 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
	 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
	 * 
	 */

	class Node {
		 public int val;
		 public Node prev;
		 public Node next;
		 public Node child;
		}
	
	public static void main(String[] args) {

	}
	
	public Node flatten(Node head) {
        if( head == null) return head;
	// Pointer
        Node p = head; 
        while( p!= null) {
            /* CASE 1: if no child, proceed */
            if( p.child == null ) {
                p = p.next;
                continue;
            }
            /* CASE 2: got child, find the tail of the child and link it to p.next */
            Node temp = p.child;
            // Find the tail of the child
            while( temp.next != null ) 
                temp = temp.next;
            // Connect tail with p.next, if it is not null
            temp.next = p.next;  
            if( p.next != null )  p.next.prev = temp;
            // Connect p with p.child, and remove p.child
            p.next = p.child; 
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
	// https://www.youtube.com/watch?v=ddB_HUMctUE
	public Node flatten2(Node head) {
		
		if(head == null) return null ;
		
		Deque<Node> s = new ArrayDeque<>() ;
		Node cur = head ;
		
		while(cur != null){
			
			if(cur.child != null){
				if(cur.next != null){
					s.offerLast(cur.next) ;
				}
				
				cur.next = cur.child ;
				cur.child.prev = cur ;
				cur.child = null ;
				
			}else{
				if(cur.next == null && !s.isEmpty()){
					cur.next = s.pollLast() ;
					cur.next.prev = cur ;
				}
				
			}
			
			cur = cur.next ;
			
			
		}
		
		return head ;
		
	}
	
	// https://www.youtube.com/watch?v=_AkSuu-oLyk
	public Node flatten3(Node head) {
		
		if(head == null) return null ;
		
		Deque<Node> stack = new ArrayDeque<>() ;
		Node cur = head ;
		
		while(cur != null){
			
			if(cur.child != null){
				if(cur.next != null){
					stack.push(cur.next) ;
				}
				
				cur.next = cur.child ;
				if(cur.next != null){
					cur.next.prev = cur ;
				}
				cur.child = null ;				
			}else{
				if(cur.next == null && !stack.isEmpty()){
					cur.next = stack.pop() ;
					if(cur.next != null){
						cur.next.prev = cur ;
					}
				}
			}
			
			cur = cur.next ;
			
			
		}
		
		return head ;
		
	}
	
}

