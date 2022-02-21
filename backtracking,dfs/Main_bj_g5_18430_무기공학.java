package b0221;

import java.io.*;
import java.util.*;

public class Main_bj_g5_18430_무기공학 {
	static int N,M;
	static int[][] map ;
	static boolean[][] visited;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 인덱스와 현재 값 
		dfs(0, 0);
		System.out.println(max);
	}
	private static void dfs(int index, int value) {
		// 기저
		if(index == N * M) {
			max = Math.max(max, value);
			return;
		}
		// 인덱스 기준 x, y 값. M으로 비교해서 구해주기 
		int x = index / M;
		int y = index % M;
		
		if(visited[x][y] == false) {
			// ㄱ
			if(x + 1 < N && y - 1 >= 0 && !visited[x+1][y] && !visited[x][y-1]) {
				visited[x][y] = true;
				visited[x+1][y] = true;
				visited[x][y-1] = true;
				int sum = map[x][y] * 2 + map[x+1][y] + map[x][y-1];
				dfs(index + 1, value + sum);
				visited[x][y] = false;
				visited[x+1][y] = false;
				visited[x][y-1] = false;
			}
			// L
			if(x - 1 >= 0 && y + 1 < M && !visited[x-1][y] && !visited[x][y+1]) {
				visited[x][y] = true;
				visited[x-1][y] = true;
				visited[x][y+1] = true;
				int sum = map[x][y] * 2 + map[x-1][y] + map[x][y+1];
				dfs(index + 1, value + sum);
				visited[x][y] = false;
				visited[x-1][y] = false;
				visited[x][y+1] = false;
			}
			//r
			if(x + 1 < N && y + 1 < M && !visited[x+1][y] && !visited[x][y+1]) {
				visited[x][y] = true;
				visited[x+1][y] = true;
				visited[x][y+1] = true;
				int sum = map[x][y] * 2 + map[x+1][y] + map[x][y+1];
				dfs(index + 1, value + sum);
				visited[x][y] = false;
				visited[x+1][y] = false;
				visited[x][y+1] = false;
			}
			
			// _l
			if(x - 1 >= 0 && y - 1 >= 0 && !visited[x-1][y] && !visited[x][y-1]) {
				visited[x][y] = true;
				visited[x-1][y] = true;
				visited[x][y-1] = true;
				int sum = map[x][y] * 2 + map[x-1][y] + map[x][y-1];
				dfs(index + 1, value + sum);
				visited[x][y] = false;
				visited[x-1][y] = false;
				visited[x][y-1] = false;
			}
		}
		dfs(index + 1, value);
	}
}