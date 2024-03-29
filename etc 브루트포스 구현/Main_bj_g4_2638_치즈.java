package b0306;

import java.io.*;
import java.util.*;

public class Main_bj_g4_2638_치즈 {
	static int N,M,answer;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static Queue<int[]> meltingCheese = new LinkedList<int[]>();
	static Queue<int[]> checkOutside = new LinkedList<int[]>();
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
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
				if(map[i][j] == 1) {
					queue.offer(new int[] {i, j});
				}
			}
		}
		
		bfs();
		System.out.println(answer);
	}

	private static void bfs() {
		while(!queue.isEmpty()) {
			answer ++;
			int size = queue.size();
			checkOutSide();
			for(int i = 0 ; i < size ; i++) {
				int[] cur = queue.poll();
				int air = 0;
				for(int j = 0 ; j < 4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					if(0 > nx || nx >= N || 0 > ny || ny >= M) continue;
					
					if(map[nx][ny] == 0 && visited[nx][ny] == true) air++; 
					
				}
				
				if(air >= 2) {
					meltingCheese.add(new int[] {cur[0], cur[1]});
				}
				else {
					queue.add(new int[] {cur[0], cur[1]});
				}
			}
			
			while(!meltingCheese.isEmpty()) {
				int[] cur = meltingCheese.poll();
				map[cur[0]][cur[1]] = 0;
			}
			
		}
	}

	private static void checkOutSide() {
		visited = new boolean[N][M];
		visited[0][0] = true;
		checkOutside.add(new int[] {0, 0});
		while(!checkOutside.isEmpty()) {
			int[] cur = checkOutside.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(0 > nx || nx >= N || 0 > ny || ny >= M || map[nx][ny] == 1 || visited[nx][ny] == true) continue;
				visited[nx][ny] = true;
				checkOutside.add(new int[] {nx, ny});
			}
		}
		
	}

}
