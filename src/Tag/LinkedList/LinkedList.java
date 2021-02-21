package Tag.LinkedList;

public class LinkedList {

	
	
	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList() ;
		
//		linkedList.insertHead(1);
//		linkedList.insertHead(2);
//		linkedList.insertHead(3);
		linkedList.insertTail(1);
		linkedList.insertTail(2);
		linkedList.insertTail(3);
//		linkedList.insertMiddle(4, 2);
//		linkedList.insertMiddle(5, 4);
		
//		linkedList.delete(1);
//		linkedList.delete(2);
		linkedList.delete(2);
		linkedList.traversal();
	}
	
	class Node{
		
		int val ;
		Node next ;
		public Node(int val){
			this.val = val ;
		}
		
	}
	
	private Node head ;
	
	public void insertHead(int data){
		
		Node newNode = new Node(data) ;
		
		if(head == null){
			
			head = newNode ;
			
		}else{
			newNode.next = head ;
			head = newNode ;
		}
		
	}
	
	public void insertMiddle(int data, int after){
		
		Node newNode = new Node(data) ;
		
		Node cur = head ;
		
		if(head == null){
			head = newNode ;
		}else{

			while(cur!=null && cur.next!=null){
				
				
				if(cur.next.val == after){
					
					newNode.next = cur.next.next ;
					cur.next.next = newNode ;
				}
				
				cur = cur.next;
				
			}
			
		}
		
	}
	
	public void insertTail(int data){
		
		Node newNode = new Node(data) ;
		
		if(head == null){
			head = newNode ;
		}else{
			
			Node cur = head ;
			Node prev = null ;
			while(cur != null){
				prev = cur ;
				cur = cur.next ;
			}
			
			prev.next = newNode ;
			
		}
		
	}
	
	public void traversal(){
		
		Node cur = head ;
		
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.next ;
		}
	}
	
	public void delete(int data){
		
		Node dummy = new Node(-1) ;
		dummy.next = head ;
		
		
		
		if(head == null){
			System.out.println("No items to delete");
		}else{
			
			
			if(head.val == data){
				dummy.next = head.next ;
				head = head.next ;
			}else{
				Node cur = head ;
				Node prev = null ;
				
				boolean dataFound = false ;
				
				while(cur != null && cur.next != null){
					
					prev = cur ;
					cur = cur.next ;
					if(cur.val == data){
						dataFound = true ;
						prev.next = cur.next ;
					}
				}
				
				if(!dataFound){
					System.out.println("No items to delete");
				}
			}
		}
	}
}
