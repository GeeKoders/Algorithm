import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;


public class Test {

	public static void main(String[] args) {
		Test test = new Test() ;
//		test.mapLoop();
		
//		Pair<Integer, String> pair = new Pair<>(1, "One");
//		Integer key = pair.getKey();
//	    String value = pair.getValue();
//	    System.out.println("key:" + key);
//	    System.out.println("value:" + value);
		
//		int[] nums = {5,6,7,8,9,10} ;
//		
//		System.out.println(test.findKLarget(nums));
		
//		test.splitTest();
		
		test.listTest();
		
	}
	
	@SuppressWarnings("rawtypes")
	public void mapLoop(){
		Map<String, Integer> map = new HashMap<>() ;
		
		map.put("Adam", 35);
		map.put("Brian", 40) ;
		//1
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		//2
		for(String key: map.keySet()){
			System.out.println("key:" + key);
		}
		//2
		for(Integer value: map.values()){
			System.out.println("value:" + value);
		}
		//3
		Iterator it = map.entrySet().iterator();   
		while (it.hasNext())    
		{   
		        Map.Entry pairs = (Map.Entry)it.next();   
		        System.out.println(pairs.getKey() + "=" + pairs.getValue());   
		 } 
	}
	
	private int findKLarget(int[] nums){
		
		
		Integer first = null ;
		Integer second = null ;
		
		for(int i=0; i<nums.length - 1; i++){
			
			int tmp = nums[i] ;
			
			if(i==0){
				first = tmp ;
			}else{
				
				if(nums[i+1] >= nums[i]){
					second = first ;
					first = nums[i+1] ;
				}else{
					second = tmp ;
				}
				
			}
		}
		
		
		
		return second ;
		
		
		
	}
	
	private void splitTest(){
		
		String s = " A B   C D E" ;
		StringBuilder sb = new StringBuilder() ;
		String[] arr = s.split(" ") ;
		for(int i=0; i<arr.length; i++){
			System.out.println("s++" + arr[i] + "--b");
			
//			if(!arr[i].equals("")){
				sb.append(arr[i]).append(" ") ;
//			}
			
		}
		System.out.println("length:" + arr.length);
		System.out.println(sb.substring(0, sb.length() - 1));
	}
	
	private void listTest(){
		
		LinkedList<Integer> list = new LinkedList<>() ;
		
		list.add(1) ;
		list.add(2) ;
		list.add(3) ;
		list.add(4) ;
		list.add(5) ;
		
		list.add(0, 6) ;
		list.add(1, 7) ;
		list.addFirst(9) ;
		for(int item: list){
			System.out.println(item);
		}
		
	}

}
