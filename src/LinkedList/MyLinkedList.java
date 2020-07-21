package LinkedList;

public class MyLinkedList {

	private MyNode first, last;

	private int count = 0;

	public static void main(String[] args) {
		
		MyLinkedList obj = new MyLinkedList();
		
		obj.addAtHead(1);
		obj.print();
		obj.addAtTail(3);
		obj.print();
		obj.addAtIndex(1, 2);
		obj.print();
		int param_1 = obj.get(1);
		System.out.println("param_1:" + param_1);
		obj.deleteAtIndex(1);
		obj.print();
		int param_2 = obj.get(1);
		System.out.println("param_2:" + param_2);
	}

	/** Initialize your data structure here. */
	public MyLinkedList() {
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int getSize() {
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
		int count = 0;
		while (count++ < index) {
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

		count++;

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
		count++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If
	 * index equals to the length of linked list, the node will be appended to
	 * the end of linked list. If index is greater than the length, the node will
	 * not be inserted.
	 */
	public void addAtIndex(int index, int val) {

		
		MyNode newNode = new MyNode(val);

		int size = getSize();
		if (index == size) {
			addAtTail(val);
		} else if (index > size) {
			System.out.println("do nothing");
		} else {
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

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {

		int size = getSize();

		if (index == 0) {
			first = first.next;
		} else if (index == size) {

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
		} else {

			MyNode current = first;
			MyNode prev = first;
			int count = 0;
			while (count++ < index) {
				prev = current;
				current = current.next;
			}
			prev.next = current.next;
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
