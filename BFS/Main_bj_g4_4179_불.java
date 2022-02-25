package b0225;

import java.io.*;
import java.util.*;

public class Main_bj_g4_4179_불 {
	static int R,C;
	static char[][] map;
	static boolean[][] visited,fireVisited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static Queue<int[]> fire = new LinkedList<int[]>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		fireVisited = new boolean[R][C];
		for(int i = 0 ; i < R ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j] == 'J') {
					queue.offer(new int[] {i, j});
					visited[i][j] = true;
					if(i == 0 || j == 0 || i == R-1 || j == C-1) {
						System.out.println(1);
						return;
					}
				}
				else if(map[i][j] == 'F'){
					fire.offer(new int[] {i, j});
					fireVisited[i][j] = true;
				}
			}
		}
		bfs();
	}
	private static void bfs() {
		int time = 1;
		while(! queue.isEmpty()) {
			int size = fire.size();
			// 불 이동 
			for(int i = 0 ; i < size ; i++) {
				int cur[] = fire.poll();
				
				for(int j = 0 ; j < 4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					
					if(0 > nx || nx >= R || 0 > ny || ny >= C || map[nx][ny] == '#' || fireVisited[nx][ny]) continue;
					
					fire.offer(new int[] {nx, ny});
					fireVisited[nx][ny] = true;
				}
			}
			
			
			size = queue.size();
			// 진호 이동 
			for(int i = 0 ; i < size ; i++) {
				int[] cur = queue.poll();
				
				for(int j = 0 ; j < 4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];
					
					if(0 > nx || nx >= R || 0 > ny || ny >= C || map[nx][ny] == '#' || visited[nx][ny] || fireVisited[nx][ny]) continue;
					
					if(nx == 0 || ny == 0 || nx == R-1 || ny == C-1) {
						System.out.println(++time);
						return;
					}
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
			time ++;
		}
		
		System.out.println("IMPOSSIBLE");
	}

}
