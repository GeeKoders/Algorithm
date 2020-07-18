package LinkedList;

public class CircularLinkedList<T> {

	private CircularNode<T> first ;
	
	private CircularNode<T> last ;
	
	public static void main(String[] args) {
		
		
		CircularLinkedList circularLinkedList = new CircularLinkedList() ;
//		circularLinkedList.insertH("1");
//		circularLinkedList.insertH("2");
//		circularLinkedList.insertH("3");
//		circularLinkedList.insertH("4");
//		circularLinkedList.insertH("5");
		
		circularLinkedList.insertT("1");
		circularLinkedList.insertT("2");
		circularLinkedList.insertT("3");
		circularLinkedList.insertT("4");
		circularLinkedList.insertT("5");
		circularLinkedList.insertM("6", "3");
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
	
	public void insertT(T data){
		
		CircularNode<T> newNode = new CircularNode(data) ;
		
		if(isEmpty()){
			first = newNode ;
			last = newNode ;
			last.next = first ;
		}else{
			last.next = newNode ;
			last = newNode ;
//			last.next = first ;
		}
	}
	
	public void insertM(T data, T target){
		
		CircularNode<T> newNode = new CircularNode(data) ;
		
		if(isEmpty()){
			first = newNode ;
			last = newNode ;
			last.next = first ;
		}else{
			
			CircularNode<T> current = first ;
			
			while(current!=null){
				if(current.data.equals(target)){
					newNode.next = current.next ;
					current.next = newNode ;
				}
				current = current.next ;
			}
			last.next = first;
		}
	}
	
	public void print(){
		
		int count = 0 ;
		
		CircularNode<T> current = first ;
		while(current!=null){
			
			if(count++>=12){
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
