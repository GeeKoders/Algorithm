package LinkedList;

public class DoubleLinkedList<T> {

	private DoubleNode<T> first ;
	
	private DoubleNode<T> last ;
	
	public static void main(String[] args) {

		DoubleLinkedList doubleLinkedList = new DoubleLinkedList() ;
//		doubleLinkedList.insertH("1");
//		doubleLinkedList.insertH("2");
//		doubleLinkedList.insertH("3");
//		doubleLinkedList.insertH("4");
//		doubleLinkedList.insertH("5");
//		doubleLinkedList.print();
		
		doubleLinkedList.insertT("1");
		doubleLinkedList.insertT("2");
		doubleLinkedList.insertT("3");
		doubleLinkedList.insertT("4");
		doubleLinkedList.insertT("5");
		doubleLinkedList.print();
		
	}
	
	public void insertH(T data){
		
		DoubleNode<T> newNode = new DoubleNode<>(data) ;
		
		if(isEmpty()){
			first = newNode ;
			first.rNext = last ;
			last = newNode ;
			last.lNext = first ;
		}else{
			newNode.rNext = first ;
			first.lNext = newNode ;
			first = newNode ;
		}
	}
	
	public void insertT(T data){
		
		DoubleNode<T> newNode = new DoubleNode<>(data) ;
		
		if(isEmpty()){
			first = newNode ;
			first.rNext = last ;
			last = newNode ;
			last.lNext = first ;
		}else{
			last.rNext = newNode ;
			newNode.lNext = last ;
			last = newNode ;
		}
		
	}

	public boolean isEmpty(){
		return first == null ;
	}
	
	public void print(){
		
		DoubleNode<T> current = first ;
		
		while(current!=null){
			System.out.println(current.data);
			current = current.rNext ;
		}
		
	}
}



class DoubleNode<T>{
	
	public T data ;
	
	public DoubleNode<T> lNext ;
	
	public DoubleNode<T> rNext ;
	
	public DoubleNode(T data) {
		this.data = data ;
		this.lNext = null ;
		this.rNext = null ;
	}
	
}
