package b0107;

import java.io.*;
import java.util.*;

class Solution {
    static Map<String, String> map;
    static Queue<String[]> result;
    
    public String[] solution(String[] record) {
        map = new HashMap<>();
        result = new LinkedList<>();
        String[] answer = {};
        StringTokenizer st;
        for(int i = 0 ; i < record.length ; i++){
            st = new StringTokenizer(record[i], " ");
            String cmd = st.nextToken();
            String id = st.nextToken();
            String nickName;
            if(!cmd.equals("Leave")){
                nickName = st.nextToken();
                // map으로 아이디 닉네임 구분하기
                map.put(id, nickName);
            }

            
            if(cmd.equals("Change")) continue;
            else if(cmd.equals("Enter")) result.offer(new String[]{id, "들어왔습니다."});
            else result.offer(new String[]{id, "나갔습니다."});
        }   
        int size = result.size();
        answer = new String[size];
        for(int i = 0 ; i < size ; i ++){

            String[] cur = result.poll();
            String nickName = map.get(cur[0]);
            answer[i] =nickName+"님이 "+cur[1];
        }
        
        return answer;
    }
}