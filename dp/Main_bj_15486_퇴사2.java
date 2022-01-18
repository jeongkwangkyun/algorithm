package b0118;

import java.io.*;
import java.util.*;

public class Main_bj_15486_퇴사2 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] timeTable = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			timeTable[i][0] = Integer.parseInt(st.nextToken());
			timeTable[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];

		for(int i = N-1 ; i >= 0 ; i--) {
			int day = timeTable[i][0];
			int pay = timeTable[i][1];
			// 상담하게 되면 기한을 지나는 상황 
			if(i + day > N) {
				if(i != N-1) {
					dp[i] = dp[i+1];
				}
				continue;
			}
			// 마지막 날 상담이 하루만 걸리는 상황 
			if(i == N-1) dp[i] = pay;
			//현재 일을 하게 되면 마지막 날 완료 
			else if(i + day == N) {
				dp[i] = Math.max(pay, dp[i+1]);
			}
			else {
				dp[i] = Math.max(pay + dp[i + day], dp[i + 1]);
			}
		}
		System.out.println(dp[0]);
	}
}
