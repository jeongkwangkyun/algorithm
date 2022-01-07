package b0107;

public class Pr_L2_124나라의숫자 {

	public static void main(String[] args) {
		int n = 15 ;
		String answer = "";
        String rules[] = {"4", "1", "2"};
        
        while(n != 0){
            answer = rules[n % 3] + answer;
            if(n%3 == 0){
                n--;
            }
            n /= 3;
        }
        System.out.println(answer);
		
	}

}
