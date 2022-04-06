package b0406;

import java.io.*;
import java.util.*;

public class Main_bj_s1_15989_123더하기4 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] dp;
		int[] list = new int[T];
		int max = 0;
		
		for(int i = 0 ; i < T ; i++) {
			list[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, list[i]);
		}
		
		dp = new int[max + 1][4];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int i = 4 ; i < max + 1 ; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}
		
		for(int i = 0 ; i < T ; i++) {
			int idx = list[i];
			System.out.println(dp[idx][1] + dp[idx][2] + dp[idx][3]);
		}
		
	}

}
