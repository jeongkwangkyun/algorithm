package b0410;

import java.io.*;
import java.util.*;

public class Main_bj_g5_14719_빗물 {
	static int H, W;
	static int[][] map;
	static boolean[][] visited;
	static int answer = 0;
	
 	static Queue<int[]> queue = new LinkedList<int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < W ; i++) {
			int height = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < height ; j++) {
				map[H - 1 - j][i] = 1;
				visited[H - 1 - j][i] = true;
			}
		}
		
		for(int i = H - 1 ; i >= 0 ; i--) {
			for(int j = 0 ; j < W ; j++) {
				if(j == 0 || j == W - 1) {
					continue;
				}
				if(!visited[i][j] && map[i][j] == 0) bfs(i, j);
			}
		}
		
		System.out.println(answer);
	}
	private static void bfs(int i, int j) {
		boolean flag = true;
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		int[] dx = {0, 0};
		int[] dy = {1, -1};
		int cnt = 1;
		while(! queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int idx = 0 ; idx < 2 ; idx++) {
				int nx = cur[0] + dx[idx];
				int ny = cur[1] + dy[idx];
				
				if((ny == 0 || ny == W - 1) && map[nx][ny] == 0) {
					flag = false;
					continue;
				}
				
				if(visited[nx][ny] == true || map[nx][ny] == 1) continue;
				
				queue.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
				cnt ++;
			}
		}
		
		if(flag) answer += cnt;
	}

}
