package Interview.Google.Array;

public class ReadNCharactersGivenRead4II {
	
	
	/*
	 * 158. Read N Characters Given Read4 II - Call multiple times (Hard)
	 * 
	 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=w3ke3MQTEJ8&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
	 * 
	 * Runtime: 1 ms, faster than 44.43% of Java online submissions for Read N Characters Given Read4 II - Call multiple times.
	 * 
	 * Memory Usage: 39.2 MB, less than 7.03% of Java online submissions for Read N Characters Given Read4 II - Call multiple times.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 * 
	 */
    private int tmpPointer = 0 ;
    private int tmpCount = 0 ;
    private char[] tmp = new char[4] ;
    public int read(char[] buf, int n) {
        
        int index = 0 ;
        
        while(index < n){
            
            if(tmpPointer == 0){ // It's no left from previous buffer  
                tmpCount = read4(tmp) ;
            }
            
            if(tmpCount == 0 ) break ; // We have reached to the end
            
            while(index < n && tmpPointer < tmpCount){
                buf[index++] = tmp[tmpPointer++] ;
            }
            
            if(tmpPointer >= tmpCount){ // If we run out of the buff, we have to draw the next buff
                tmpPointer = 0 ;
            }
        }
        return index ;
    }
}
