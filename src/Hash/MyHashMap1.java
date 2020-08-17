package Hash;

public class MyHashMap1 {

	// time limit exceeded
	public static void main(String[] args) {
		MyHashMap hashMap  = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		System.out.println(hashMap.get(1));            // returns 1
		System.out.println(hashMap.get(3));            // returns -1 (not found)
		hashMap.put(2, 1);          // update the existing value
		System.out.println(hashMap.get(2));            // returns 1 
		hashMap.remove(2);          // remove the mapping for 2
		System.out.println(hashMap.get(2));            // returns -1 (not found) 
	}
	
	private Node first ;
	private Node last ;

	public MyHashMap1(){
		
	}
	
	public void put(int key, int value){
		
		Node newNode = new Node(key, value) ;
		
		if(isEmpty()){
			first = newNode ;
			last = newNode ;
		}else{
			if(contains(key)){
				
				Node current = first ;
				while(current!=null){
					
					if(current.key == key){
						current.value = value ; // update ;
					}
				}
			}else{
				first.next = newNode ;
				last = newNode ;
			}
		}
		
	}
	
	public int get(int key){
		
		if(isEmpty()){
			return -1 ;
		}else{
			Node current = first ;
			
			while(current!=null){
				
				if(current.key == key){
					return current.value ;
				}
				current = current.next ;
			}
			
			return -1 ;
		}
		
	}
	
	public void remove(int key) {
		
		if(isEmpty()){
			return ;
		}else{
			
			Node current = first ;
			while(current!=null){
				
				if(current.key == key && current == first){
					first = current.next ;
				}else{
					
					Node prev = first ;
					
					while(current!=null){
						prev = current ;
						current = current.next ;
						
						if(current!=null && current.key == key){
							prev.next = current.next ;
						}
					}
				}
			}
			
		}
		
		
		
	}
	
	public boolean contains(int key){
		
		Node current = first ;
		
		while(current!=null){
			
			if(current.key == key){
				return true ;
			}
			current = current.next ;
		}
		
		return false ;
		
		
	}
	
	
	public boolean isEmpty(){
		return this.first == null ;
	}

}

class Node{
	
	public int key ;
	
	public int value ;
	
	public Node next ;
	
	public Node(int key, int value) {
		this.key = key; 
		this.value = value ;
		this.next = null ;
	}
	
	
}
