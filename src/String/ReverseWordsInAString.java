package String;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString() ;
		String result = reverseWordsInAString.reverseWords2("a good   example") ;
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

}
