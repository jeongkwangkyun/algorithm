package b0110;
import java.util.*;

public class PR_L2_더맵게 {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int size = scoville.length;
        
        for(int i = 0 ; i < size ; i++){
            pq.add(scoville[i]);
        }
        
        while(K > pq.peek()){
            if(pq.size() < 2) {
                return -1;
            }
            int tmpScoville = pq.poll();
            int tmpScoville2 = pq.poll();
            
            int mixScoville = tmpScoville + tmpScoville2 * 2;
            
            pq.add(mixScoville);
            answer ++;
        }
        
        return answer;
    }
}