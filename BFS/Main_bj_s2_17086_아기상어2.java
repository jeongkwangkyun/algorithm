package b0320;

import java.io.*;
import java.util.*;

public class Main_bj_s2_17086_아기상어2 {
	static int[][] map, visited;
	static int N,M, max;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
	static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0) {
					for(int d = 0 ; d < 8 ; d++) {					
						bfs(i, j, d, 0);
					}
					
				}
			}
		}
		System.out.println(max);
	}

	private static void bfs(int x, int y, int dir, int count) {
		visited = new int[N][M];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x, y, 0});
		visited[x][y] = 1;
		int degree = 0;
		while(! queue.isEmpty()) {
			degree ++;
			int size = queue.size();
			Loop : for(int i = 0 ; i < size ; i++) {				
				int[] cur = queue.poll();
				for(int j = 0 ; j < 8 ; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					
					if(0 > nx || nx >= N || 0 > ny || ny >= M || visited[nx][ny] == 1) continue;
					
					if(map[nx][ny] == 1) {
						queue.clear();
						break Loop;
					}
					else {
						queue.offer(new int[] {nx, ny, degree + 1});
						visited[nx][ny] = 1;
					}

				}
			}
			
		}
		max = Math.max(degree, max);
	}

}
