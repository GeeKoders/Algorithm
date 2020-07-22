package LinkedList;

public class MyLinkedList {

	private MyNode first, last;

	private int count = 0;

	public static void main(String[] args) {
		
		MyLinkedList obj = new MyLinkedList();
		
		obj.addAtHead(0);
		obj.print();
		System.out.println("size:" + obj.getSize());
		obj.addAtIndex(1, 4);
		obj.print();
		System.out.println("size:" + obj.getSize());
		obj.addAtTail(8);
		obj.print();
		System.out.println("size:" + obj.getSize());
		obj.addAtHead(5);
		obj.print();
		System.out.println("size:" + obj.getSize());
		obj.addAtIndex(4, 3);
		obj.print();
		System.out.println("size:" + obj.getSize());
		obj.addAtTail(0);
		obj.print();
		System.out.println("size:" + obj.getSize());
		obj.addAtTail(5);
		obj.print();
		System.out.println("size:" + obj.getSize());
		obj.addAtIndex(6, 3);
		obj.print();
		System.out.println("size:" + obj.getSize());
		obj.deleteAtIndex(7);
		obj.print();
		System.out.println("size:" + obj.getSize());
		
		obj.deleteAtIndex(5);
		obj.print();
		System.out.println("size:" + obj.getSize());
		
//		obj.addAtTail(4);
//		obj.print();
		
//		int param_1 = obj.get(1);
//		System.out.println("param_1:" + param_1);
		
	}

	/** Initialize your data structure here. */
	public MyLinkedList() {
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int getSize() {
		
		MyNode current = first ;
		while(current!=null){
			count++ ;
			current = current.next ;
		}
		
		return count;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {

		int size = getSize();

		if (index < 0 || index >= size) {
			return -1;
		}

		MyNode current = first;
		int counter = 0;
		while (counter < index) {
			counter++ ; 
			current = current.next;
		}

		return current.val;

	}

	/**
	 * Add a node of value val before the first element of the linked list.
	 * After the insertion, the new node will be the first node of the linked
	 * list.
	 */
	public void addAtHead(int val) {

		MyNode newNode = new MyNode(val);

		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			newNode.next = first;
			first = newNode;
		}

	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {

		MyNode newNode = new MyNode(val);

		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If
	 * index equals to the length of linked list, the node will be appended to
	 * the end of linked list. If index is greater than the length, the node will
	 * not be inserted.
	 */
	public void addAtIndex(int index, int val) {

		int size = getSize();
		if (index == size) {
			addAtTail(val);
		} else if (index > size) {
			System.out.println("do nothing");
		} else {
			
			if(index == 0){
				addAtHead(val) ;
			}else{
				
				MyNode newNode = new MyNode(val);
				int target = get(index);
				MyNode current = first;
				MyNode prev = first;

				while (current != null) {
					prev = current;
					current = current.next;
					if (current != null && current.val == target) {
						prev.next = newNode;
						newNode.next = current;
					}
				}
			}
		}
		

	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {

		int size = getSize();
		if (index == 0) { //remove head
			first = first.next;
		} else if (index == size - 1) { //remove tail

			MyNode current = first;
			MyNode prev = first;
			while (current != null) {
				prev = current;
				current = current.next;
				if (current == last) {
					prev.next = current.next;
					last = prev;
				}
			}
		}else if(index < 0 || index >= size){
			System.out.println("index is invalid");
		}else{ //remove middle

			MyNode current = first;
			MyNode prev = first;
			while (current!=null) {
				prev = current;
				current = current.next;
				System.out.println("deleteAtIndex:" + current.val);
				System.out.println("get(index):" + get(index));
				if(current!=null && current.val == get(index)){
					prev.next = current.next;
				}
				
			}
		}
	}
	
	public void print(){
		
		MyNode current = first ;
		
		while(current!=null){
			System.out.print(current.val + " ");
			current = current.next ;
		}
		System.out.println();
		
	}
}

class MyNode {

	public int val;
	public MyNode next;

	public MyNode(int val) {
		this.val = val;
		this.next = null;
	}

}
