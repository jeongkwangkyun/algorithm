package b0202;
import java.util.*;

public class PR_L2_짝지어제거하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("cdcd"));
	}
	
	public static int solution(String s)
    {
		int answer = -1;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
        	// 큐가 비었을때 
        	if(stack.isEmpty()) {
        		stack.push(s.charAt(i));
        	}
        	// 큐가 있을때 
        	else if(s.charAt(i) == stack.peek()) stack.pop();
            
            else stack.push(s.charAt(i));
        }
        
        if(stack.isEmpty()) answer = 1;
        else answer = 0 ;
        
        return answer;
    }
}



