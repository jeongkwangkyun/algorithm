package b0330;

import java.io.*;
import java.util.*;

public class Main_bj_g3_11967_불켜기 {
	static int N,M;
	static Queue<int[]>[][] map;
	static boolean[][] possible;
	static boolean[][] visited, isMove;
	
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int roomNum ;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		possible = new boolean[N][N];
		visited = new boolean[N][N];
		isMove = new boolean[N][N];
		map = new LinkedList[N][N];
		
		for(int i = 0 ; i <  N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = new LinkedList<int[]>();
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int nx = Integer.parseInt(st.nextToken()) - 1;
			int ny = Integer.parseInt(st.nextToken()) - 1;
			
			map[x][y].offer(new int[] {nx, ny});
		}

		visited[0][0] = true;
		possible[0][0] = true;
		queue.offer(new int[] {0, 0});
		bfs();
		for(int i = 0 ; i <  N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(possible[i][j]) roomNum += 1;
			}
		}
		System.out.println(roomNum);
	}
	
	private static void bfs() {
		while(! queue.isEmpty()) {
			int[] cur = queue.poll();
			visited[cur[0]][cur[1]] = true;
			possible[cur[0]][cur[1]] = true;
			
			// 현위치에서 4방향 탐색 
			for(int i = 0 ; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;
				
				isMove[nx][ny] = true;
			}
			// 현위치에서 스위치 킬 수 있는거키기, bfs니까 가능 
			while(! map[cur[0]][cur[1]].isEmpty()) {
				int[] point = map[cur[0]][cur[1]].poll();
				
				if(!possible[point[0]][point[1]]) {
					possible[point[0]][point[1]] = true;
				}
				//이동 할 수 있는방
				if(isMove[point[0]][point[1]] && !visited[point[0]][point[1]]) {
					visited[point[0]][point[1]] = true;
					queue.offer(new int[] {point[0], point[1]});
				}
			}
			
			//현 위치에서 이동할 수 있는 방 이동
			for(int i = 0 ; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;
				// 이미 방문한방, 이동할수 없는방, 불 꺼진 방 
				if(visited[nx][ny] || !isMove[nx][ny] || !possible[nx][ny]) continue;
				
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny});
				
			}
		}
	}
}
