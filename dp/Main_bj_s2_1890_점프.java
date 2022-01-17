package b0117;

import java.io.*;
import java.util.*;

public class Main_bj_s2_1890_점프 {
	static int N;
	static int[][] map;
	static long[][] dp;
	static int[] dx = {1,0};
	static int[] dy = {0,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(find(0,0));
	}
	private static long find(int x, int y) {
		if(x == N -1  && y == N -1) {
			return 1;
		}
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		
		for(int i = 0 ; i < 2; i++) {
			int nx = x + dx[i] * map[x][y];
			int ny = y + dy[i] * map[x][y];
			if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;
			// 가능한 경로를 dp += 1
			dp[x][y] += find(nx, ny);
		}
		return dp[x][y];
	}

}
