package b0217;

import java.io.*;
import java.util.*;

public class Main_bj_s1_2583_영역구하기 {
	static int N, M , K;
	static int[][] map ;
	static boolean[][] visited;
	static List<Integer> area = new LinkedList<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		int startX, startY, endX, endY;
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			startY = Integer.parseInt(st.nextToken());
			startX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
		
			
			for(int x = startX ; x < endX ; x++) {
				for(int y = startY ; y < endY ; y++) {
					map[x][y] = 1;
					visited[x][y] = true;
				}
			}
		}
		for(int x = 0 ; x < N ; x++) {
			for(int y = 0 ; y < M ; y++) {
				if(map[x][y] != 1 && visited[x][y] == false) {
					bfs(x, y);
				}
			}
		}
		Collections.sort(area);
		System.out.println(area.size());
		for(int i = 0 ; i < area.size() ; i++) {
			System.out.print(area.get(i)+" ");
		}
	}
	private static void bfs(int x, int y) {
		visited[x][y] = true;
		int count = 1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x, y});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= M || visited[nx][ny]) continue;
				
				if(map[nx][ny] == 0) {
					visited[nx][ny] = true;
					count += 1;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
		area.add(count);
	}

}
