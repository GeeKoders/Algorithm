package Interview.Google.Pre;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

	
	/*
	 * 929. Unique Email Addresses (Easy)
	 * 
	 * https://leetcode.com/explore/interview/card/google/67/sql-2/3044/
	 * 
	 * solution: https://leetcode.com/problems/unique-email-addresses/solution/
	 * 
	 *  184 / 184 test cases passed.
		Status: Accepted
		Runtime: 37 ms (Your runtime beats 14.16 % of java submissions.)
		Memory Usage: 39.8 MB (Your memory usage beats 50.48 % of java submissions.)
	 * 
	 * Time complexity for indexOf = O(n.1) ~ O(n)
	   Time complexity for substring() = O(1)
       Time complexity for replaceAll() = O(n)
       Time complexity for contains() = O(n)
	 * 
	 * 
	 */
	
	public int numUniqueEmails(String[] emails) {
	     
		 Set<String> set = new HashSet() ;
	        
	        for(int i=0; i<emails.length; i++){
	            
	            String []textArr = emails[i].split("@") ;
	            
	            String localName =  textArr[0] ;
	            String domainName = textArr[1] ;
	            
	            if(localName.indexOf("+") != -1){
	                localName = localName.substring(0, localName.indexOf("+")) ;   
	                
	               
	                
	            }
	            
	            if(localName.indexOf(".") != -1){
	                    localName = localName.replace(".", "") ;
	            }
	            
	            String result = localName + "@" + domainName ; 
	            System.out.println("result:" + result) ;
	            set.add(result) ;
	                       
	        }
	        
	        return set.size() ;
	        
        
    }
	
}
