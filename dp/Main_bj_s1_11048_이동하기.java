package b0223;

import java.io.*;
import java.util.*;

public class Main_bj_s1_11048_이동하기 {
	static int[][] map, dp;
	static int N,M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <=M ; j++) {
				dp[i][j] = Math.max(map[i][j] + dp[i-1][j], map[i][j] + dp[i][j-1]);
			}
		}
		
		System.out.println(dp[N][M]);
	}

}
