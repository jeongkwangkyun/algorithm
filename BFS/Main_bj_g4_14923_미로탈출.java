package b0118;

import java.io.*;
import java.util.*;

public class Main_bj_g4_14923_미로탈출 {
	static int N, M, min, curX, curY, destinationX, destinationY;
	static Queue<int[]> queue = new LinkedList<>();
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		min = 9999999;
		st = new StringTokenizer(br.readLine());
		curX = Integer.parseInt(st.nextToken())-1;
		curY = Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(br.readLine());
		destinationX = Integer.parseInt(st.nextToken())-1;
		destinationY = Integer.parseInt(st.nextToken())-1;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
		
	}
	private static int bfs() {
		int time = 0;
		boolean[][][] visited = new boolean[2][N][M];
		queue.offer(new int[] {curX, curY, 0});
		visited[0][curX][curY] = true;
		
		while(!queue.isEmpty()) {
			time ++;
			int size = queue.size();
			while(size-- > 0) {			
				// nx, ny, 지팡이 썼는지 안썼는지 
				int[] cur = queue.poll();
				for(int i = 0 ; i < 4 ; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];
					if(0 > nx || nx >= N || 0 > ny || ny >= M) continue;
					
					// 벽이 있는 경우 
					if(map[nx][ny] == 1) {
						if(cur[2] == 0 && !visited[cur[2]+1][nx][ny]) {
							if(nx == destinationX && ny == destinationY) return time;
							
							queue.offer(new int[] {nx, ny, cur[2]+1});
							visited[cur[2]+1][nx][ny] = true;
						}
					}
					// 벽이 아닌 경우 
					else {
						if(!visited[cur[2]][nx][ny]) {
							if(nx == destinationX && ny == destinationY) return time;
							
							queue.offer(new int[] {nx, ny, cur[2]});
							visited[cur[2]][nx][ny] = true;
						}
					}
				}
			}
		}
	return -1;
	}

}
