package b0215;

import java.io.*;
import java.util.*;

public class Main_bj_s2_1986_체스 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queenQueue;
	static Queue<int[]> knightQueue;
	
	static int[] qx = {1,0,-1,0,1,1,-1,-1};
	static int[] qy = {0,1,0,-1,1,-1,1,-1};
	
	static int[] kx = {-2,-1,2,1,-2,-1,1,2};
	static int[] ky = {1,2,1,2,-1,-2,-2,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		int count;
		queenQueue = new LinkedList<>();
		knightQueue = new LinkedList<>();
		// queen
		st = new StringTokenizer(br.readLine());
		count = Integer.parseInt(st.nextToken());
		int x,y;
		
		for(int i = 0 ; i < count ; i++) {
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = 1;
			visited[x][y] = true;
			queenQueue.offer(new int[] {x, y});
		}
		st = new StringTokenizer(br.readLine());
		count = Integer.parseInt(st.nextToken());
		// knight
		for(int i = 0 ; i < count ; i++) {
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = 1;
			visited[x][y] = true;
			knightQueue.offer(new int[] {x, y});
		}
		st = new StringTokenizer(br.readLine());
		count = Integer.parseInt(st.nextToken());
		//pawn
		for(int i = 0 ; i < count ; i++) {
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = 1;
			visited[x][y] = true;
		}
		
		queenMove();
		knightMove();
		count = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(!visited[i][j]) count++;
			}
		}
		System.out.println(count);
	}

	private static void knightMove() {
		while(!knightQueue.isEmpty()) {
			int[] cur = knightQueue.poll();
			for(int i = 0 ; i < 8 ; i++) {
				int nx = cur[0] + kx[i];
				int ny = cur[1] + ky[i];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= M ) continue;
				
				visited[nx][ny] = true;
			}
		}
	}

	private static void queenMove() {
		while(!queenQueue.isEmpty()) {
			
			int[] cur = queenQueue.poll();
			int x = cur[0];
			int y = cur[1];
			for(int i = 0 ; i < 8 ; i++) {
				while(true) {
					int nx = x + qx[i];
					int ny = y + qy[i];
					
					if(0 > nx || nx >= N || 0 > ny || ny >= M || map[nx][ny] == 1) break;
					visited[nx][ny] = true;
					x = nx;
					y = ny;
				}
				x = cur[0];
				y = cur[1];
			}
		}
		
	}	
}
