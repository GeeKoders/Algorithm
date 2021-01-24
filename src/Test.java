import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javafx.util.Pair;


public class Test {

	public static void main(String[] args) {
//		Test test = new Test() ;
//		test.mapLoop();
		
		Pair<Integer, String> pair = new Pair<>(1, "One");
		Integer key = pair.getKey();
	    String value = pair.getValue();
	    System.out.println("key:" + key);
	    System.out.println("value:" + value);
		
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

}