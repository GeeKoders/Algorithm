package Interview.Google.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {
class Worker implements Comparable<Worker>{
        
        int quality ;
        int wage ;
        
        public Worker(int q, int w){
            this.quality = q ;
            this.wage = w ;
        }
        
        public double getRatio(){
            return (double)wage/quality ;
        }
        
        public int compareTo(Worker other){
            return Double.compare(getRatio(), other.getRatio());
        }
        
    }
    /*
     * 857. Minimum Cost to Hire K Workers (Hard)
     * 
     * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
     * 
     * solution: https://leetcode.com/problems/minimum-cost-to-hire-k-workers/solution/
     * 
     * reference:
     * 
     * https://www.youtube.com/watch?v=7-vZbPEuvwM&ab_channel=happygirlzt
     * 
     * https://www.youtube.com/watch?v=3a_HFrdpjos&ab_channel=%E5%8F%B8%E6%B3%A2%E5%9B%BE
     * 
     * https://www.youtube.com/watch?v=o8emK4ehhq0&ab_channel=ShiranAfergan
     * 
     * Your runtime beats 86.88 % of java submissions.
     * Your memory usage beats 69.04 % of java submissions.

     * Time complexity: O(NlogN)
     * Space complexity: O(N)
     * 
     * 
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        
        
        Worker[] workers = new Worker[quality.length] ;
        
        for(int i=0; i<workers.length; i++){
            workers[i] = new Worker(quality[i], wage[i]) ;
        }
        
        Arrays.sort(workers) ;
        
        double cost = Integer.MAX_VALUE ;
        int totalQuality = 0 ;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a) ;
        
        for(Worker worker: workers){
            totalQuality+= worker.quality ;
            maxHeap.offer(worker.quality) ;
           
            if(maxHeap.size() > K){
                //remove the largest quality
                totalQuality -= maxHeap.poll() ;
            }
            //if we have k person now, update answer
            if(maxHeap.size() == K){
                cost = Math.min(cost, totalQuality * worker.getRatio()) ;
            }
            
            
        }
        
        return cost ;
        
    }
}
