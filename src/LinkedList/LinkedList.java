package LinkedList;

public class LinkedList<T> {

	private Node<T> first ;
	private Node<T> last ;
	
	
	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();
//		linkedList.insertH(1);
//		linkedList.insertH(2);
//		linkedList.insertH(3);
//		linkedList.insertH(4);
//		linkedList.insertH(5);
//		linkedList.print();
		
//		linkedList.insertH(new Person("Paul", "M", 37));
//		linkedList.insertH(new Person("Alice", "F", 35));
//		linkedList.print();
		
		linkedList.insertT(1);
		linkedList.insertT(2);
		linkedList.insertT(3);
		linkedList.insertT(4);
		linkedList.insertT(5);
//		linkedList.removeH();
//		linkedList.removeH();
//		linkedList.removeT();
//		linkedList.removeT();
		
//		linkedList.insertM(6, 7);
//		linkedList.insertM(6, 7);
		linkedList.removeM(3);
		linkedList.removeM(4);
		linkedList.removeM(6);
		linkedList.print();
		
		
		
		
	}
	
	public void insertH(T data){
		
		Node<T> newNode = new Node<T>(data); 
		
		if(isEmpty()){
			first = newNode ;
			last = newNode ;
		}else{
			newNode.next = first ;
			first = newNode ;
		}
	}
	
	public void insertT(T data){
		
		Node<T> newNode = new Node<T>(data) ;
		
		if(isEmpty()){
			first = newNode ;
			last = newNode ;
		}else{
			last.next = newNode ;
			last = newNode ;
		}
		
		
	}
	
	public void insertM(T target, T data){
		
		Node<T> newNode = new Node<T>(data) ;
		boolean findNodeFlag = false ;
		
		if(isEmpty()){
			first = newNode ;
			last= newNode ;
		}else{
			
			Node<T> current = first ;
			
			while(current!=null){
				
				
				if(current!=null & current.data.equals(target)){
					newNode.next = current.next ;
					current.next = newNode ;
					findNodeFlag = true ;
				}
				
				current = current.next ;
			}
		}
		
		if(!findNodeFlag){
			System.out.println("Target " + target + " not found!");
		}
		
	}
	
	public void removeH(){
		
		if(isEmpty()){
			System.out.println("No nodes to remove!");
		}else{
			first = first.next ;
		}
	}
	
	public void removeT(){
		
		Node<T> current = first ;
		
		if(isEmpty()){
			System.out.println("No nodes to remove!");
		}else{
			while(current!=null){
				
				current = current.next ;
				if(current!=null && current.next == last){
					current.next = last.next ;
					last = current ;
				}
			}
		}
		

	}
	
	public void removeM(T target){
		
		boolean findNodeFlag = false ;
		
		if(isEmpty()){
			System.out.println("No node to remove!");
		}else{
			
			Node<T> current = first ;
			
			while(current!=null){
				
				if(current.next!=null && current.next.data.equals(target)){
					current.next = current.next.next ;
					findNodeFlag = true ;
				}
				
				current = current.next ;
			}
			
		}
		
		if(!findNodeFlag){
			System.out.println("Target " + target + " not found!");
		}
		
	}
	
	public void print(){
		
		Node<T> node = first ;
		while(node!=null){
			System.out.println(node.getData());
			node = node.next ;
		}
	}
	
	public boolean isEmpty(){
		return first == null ;
	}
	

}

class Node<T>{
	
	public T data ;
	public Node<T> next ;
	
	public Node(T data) {
		this.data = data ;
		this.next = null ;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
}

class Person implements Comparable<Person>{
	
	private String name ;
	private String sex ;
	private int age ;
	
	public Person(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person other) {
		return Integer.compare(this.age, other.getAge());
	}
	
	@Override
	public String toString() {
		return this.name + "-" + this.sex + "-" + this.age ;
	}
	
}