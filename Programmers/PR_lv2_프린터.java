package b0310;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < priorities.length ; i++){
            // index랑 우선순위 
            queue.add(new int[]{i, priorities[i]});
        }
        Arrays.sort(priorities);
        int priorityIndex = priorities.length - 1;
        int time = 1;
        while(true){
            int[] cur = queue.poll();
            int index = cur[0];
            int num = cur[1];
            System.out.println(num);
            if(num == priorities[priorityIndex]){
                
                if(location == index){
                    answer = time;
                    break;
                }
                time ++;
                priorityIndex--;
            }
            
            queue.add(cur);
        }
        
        
        return answer;
        
    }
}