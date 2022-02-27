package b0226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_s2_14620_꽃길 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] seed = new int[3][2];
	static int min = Integer.MAX_VALUE;
	static int[] dx = {1,0,-1,0,1,1,-1,-1,2,0,-2,0};
	static int[] dy = {0,1,0,-1,1,-1,1,-1,0,2,0,-2};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0 ; i < N ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.println(min);
		
	}
	private static void dfs(int cnt, int sum) {
		if(cnt == 3) {
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 1 ; i < N -1 ; i++) {
			for(int j = 1 ; j < N-1 ; j++) {
				if(visited[i][j]) continue;
				
				seed[cnt][0] = i;
				seed[cnt][1] = j;
				if(!isAvailiable(i, j)) continue;
				visited[i][j] = true;
				dfs(cnt + 1, sum + seedCount(i, j));
				visited[i][j] = false;
			}
		}
	}
	private static int seedCount(int x, int y) {
		int temp = 0;
		temp += map[x][y];
		for(int i = 0 ; i < 4; i ++) {
			temp += map[x + dx[i]][y + dy[i]];
		}
		return temp;
	}
	private static boolean isAvailiable(int x, int y) {
		
		for(int i = 0 ; i < 12 ; i++) {
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;
			if(visited[nx][ny]) return false;
		}
		
		return true;
	}

}
