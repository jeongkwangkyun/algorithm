package b0112;

public class PR_L2_피보나치수 {
	public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i < n+1 ; i++){
            dp[i] = dp[i-1] % 1234567 + dp[i-2] % 1234567;
        }
        answer = dp[n] % 1234567;
        
        return answer;
    }
}