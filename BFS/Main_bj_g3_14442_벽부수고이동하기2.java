package b0121;

import java.io.*;
import java.util.*;

public class Main_bj_g3_14442_벽부수고이동하기2 {
	static int N, M, K;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = temp.charAt(j) - '0'; 
			}
		}
		System.out.println(bfs());
	}
	private static int bfs() {
		if(N == 1 && M == 1) return 1;
		boolean[][][] visited = new boolean[N][M][K+1];
		int time = 1;
		visited[0][0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0, 0});
		while(!queue.isEmpty()) {
			time += 1;
			int size = queue.size();
			while(size -- >0) {
				int[] cur = queue.poll();
				for(int i  = 0 ; i < 4 ; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];
					int cnt = cur[2];
					if(0 > nx || nx >= N || 0 > ny || ny >= M ) continue;
					//벽인 경우 
					if(map[nx][ny] == 1) {
						if(cnt < K && visited[nx][ny][cnt + 1] == false) {
							if(nx == N-1 && ny == M-1) return time;
							
							queue.offer(new int[] {nx, ny, cnt + 1});
							visited[nx][ny][cnt + 1] = true;
						}
					}
					// 벽이 아닌 경우 
					else {
						if(visited[nx][ny][cnt] == false) {
							if(nx == N-1 && ny == M-1) return time;
							
							queue.offer(new int[] {nx, ny, cnt});
							visited[nx][ny][cnt] = true;
						}
					}
				}
			}
			
		}
		return -1;
	}

}
