package LinkedList;

public class CircularLinkedList<T> {

	private CircularNode<T> first ;
	
	private CircularNode<T> last ;
	
	public static void main(String[] args) {
		
		
		CircularLinkedList circularLinkedList = new CircularLinkedList() ;
		circularLinkedList.insertH("1");
		circularLinkedList.insertH("2");
		circularLinkedList.insertH("3");
		circularLinkedList.insertH("4");
		circularLinkedList.insertH("5");
		
		circularLinkedList.print();
	}
	
	public void insertH(T data){
		
		CircularNode<T> newNode = new CircularNode(data) ;
		
		if(isEmpty()){
			first = newNode ;
			last = newNode ;
			last.next = first ;
		}else{
			newNode.next = first ;
			first = newNode ;
			last.next = first ;
		}
		
	}
	
	
	
	public void print(){
		
		int count = 0 ;
		
		CircularNode<T> current = first ;
		while(current!=null){
			
			if(count++>=10){
				break ;
			}
			
			System.out.println(current.data);
			current = current.next ;
		}
	}
	
	public boolean isEmpty(){
		return first == null ;
	}
	
	

}

class CircularNode<T>{
	
	public T data ;
	public CircularNode<T> next ;
	
	public CircularNode(T data) {
		this.data = data ;
		this.next = null ;
	}
	
}
