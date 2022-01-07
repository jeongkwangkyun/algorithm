package b0107;
import java.util.*;

public class PR_L2_기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int[] answer = {};
        if(progresses.length == 0) return answer;
        answer = new int[speeds.length];

        // 걸리는 날짜 계산
        for(int i = 0 ; i < speeds.length ; i++){

            int day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0 ) day++;
            answer[i] = day;
        }
        int input = 1;
        int max = answer[0];
        if(answer.length == 1) queue.offer(max);
        
        for(int i = 1 ; i < answer.length ; i++){
            if(max >= answer[i]){
                input ++;
            }
            else{
                queue.offer(input);
                input = 1;
                max = answer[i];
            }
            if(i == answer.length - 1 ){
                    queue.offer(input);
            }
        }
        
        answer = new int[queue.size()];
        int idx = 0;
        while(! queue.isEmpty()){
            answer[idx++] = queue.poll();
        }
        return answer;
    }
}