package b0219;

import java.io.*;
import java.util.*;

public class Main_bj_g5_12865_평범한배낭 {
	static int N,K,max;
	static int[][] products,dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		products = new int[N+1][2];
		dp = new int[N+1][K+1];
		// 무게, 가치 
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			products[i][0] = Integer.parseInt(st.nextToken());
			products[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= K ; j++) {
				
				if(products[i][0] > j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - products[i][0]] + products[i][1]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
