package String;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString() ;
		String result = reverseWordsInAString.reverseWords3("a good   example") ;
		System.out.println("result:" + result);
	}
	// wrong answer
	public String reverseWords(String s) {
        
        String data = s.trim() ;
        String [] split = data.split(" ") ;
        
        int start = 0 ;
        int end = split.length - 1 ;
        
        while(start < end){
            swap(split, start, end) ;
            start++;
            end--;
        }
        
        String result = "" ;
        for(String item: split){
            result += item.trim() + " " ;
        }
        
        return result.trim() ;
    }
    
    public void swap(String []split, int i, int j){
        String tmp = split[i].trim() ;
        split[i] = split[j].trim() ;
        split[j] = tmp ;
    }
    // runtime beats 10.31%
    public String reverseWords2(String s) {
        
    	String[] split = s.split("\\s+");
    	
    	int start = 0 ;
        int end = split.length - 1 ;
        
        while(start < end){
            swap(split, start, end) ;
            start++;
            end--;
        }
    	
    	
        String result = "" ;
        for(String item: split){
            result += item.trim() + " " ;
        }
        
        return result.trim() ;
    }
    // runtime beats 16.45%
    public String reverseWords3(String s) {
        
    	if(s.isEmpty()) return "" ;
    	
    	String[] arr = s.split(" ");
    	StringBuilder sb = new StringBuilder() ;
        
    	for(String item: arr){
    		System.out.println("item:" + item);
    	}
    	
    	for(int i=arr.length-1; i>=0 ; i--){
    		if(!arr[i].isEmpty()){
    			sb.append(arr[i]).append(" ") ;
    		}
    	}
    	
    	return sb.length() == 0 ? "" : sb.substring(0, sb.length()-1) ;
    	
    	
    }
    // runtime beats 90.55%
    public String reverseWords4(String s) {
        
    	if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    	
    	
    }

}
