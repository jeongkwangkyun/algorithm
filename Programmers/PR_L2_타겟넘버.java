package b0110;
import java.util.*;

public class PR_L2_타겟넘버 {
	  static boolean[] isSelected;
	    static int answer;
	    
	    public static int solution(int[] numbers, int target) {
	        answer = 0;
	        isSelected = new boolean[numbers.length];
	        permutation(numbers, 0, target);
	        
	        return answer;
	    }
	    private static void permutation(int[] numbers,int cnt,int target){
	        if(cnt == numbers.length){
	            int total = 0;
	            for(int i = 0 ; i < numbers.length ; i++){
	                if(isSelected[i]) total += numbers[i];
	                else total -= numbers[i];
	            }
	            
	            if(total == target) {
	                System.out.println(Arrays.toString(isSelected));
	                answer ++;
	            }
	            return;
	        }
	        
            isSelected[cnt] = true;
            permutation(numbers, cnt+1, target);
            isSelected[cnt] = false;
            permutation(numbers, cnt+1, target);
	        
	    }
	    public static void main(String[] args) {
	    	int[] numbers = {1,1,1,1,1};
			System.out.println(solution(numbers,3));
		}
	}