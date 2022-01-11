package b0111;

import java.io.*;
import java.util.*;

public class Main_bj_g4_마법사상어와파이어스톰 {
	static int N, Q, iceTotal, sumMax;
	static int[][] map;
	static boolean[][] visited;
	static int[] L;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N= (int) Math.pow(2, N);
		L =new int[Q];
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine() , " ");
		for(int i = 0 ; i<Q;i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		for(int i =0 ; i<Q;i++) {
			map = divide(L[i]);
			map = melt();
		}
		
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				iceTotal += map[i][j];
				if(!visited[i][j] && map[i][j] != 0) bfs(i,j); 
			}
		}
		
		System.out.println(iceTotal);
		System.out.println(sumMax);
	}
	
	private static int[][] divide(int L) {
		int[][] temp = new int[N][N];
		L =(int) Math.pow(2, L);
		
		//격자 부분에 가장 왼 위쪽 
		for(int i = 0 ; i<N ; i+=L) {
			for(int j = 0 ; j<N; j+=L) {
				rotate(i, j, L, temp);
			}
		}
		return temp;
	}
	// 90도로 돌리기 
	private static void rotate(int r, int c, int L, int[][] temp) {
		for(int i = 0 ; i < L ; i++) {
			for(int j = 0; j < L ; j++) {
				temp[r + j][c + L - i - 1] = map[r + i][c + j];
			}
		}
	}
	
	private static int[][] melt() {
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] != 0)find(i, j);
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(visited[i][j] == false && map[i][j] != 0) map[i][j] -= 1;
			}
		}
		return map;
	}
	
	private static void find(int x, int y) {
		// 주변 얼음 개수 고르기 
		int cnt = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 > nx || nx>= N || 0>ny || ny>=N) continue;
			if(map[nx][ny] > 0) cnt ++;
		}
		if(cnt >= 3) visited[x][y] = true;
	}
	
	private static void bfs(int x, int y) {
		Queue<int []> queue = new LinkedList<>();
		int temp = 1;
		visited[x][y] = true;
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			for(int i = 0 ; i<4;i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(0 > nx || nx>= N || 0>ny || ny>=N || map[nx][ny] == 0 || visited[nx][ny] ==true) continue;
				
				visited[nx][ny] =true;
				temp += 1;
				queue.offer(new int[] {nx, ny});
			}
		}
		sumMax = Math.max(temp, sumMax);
	}

}
