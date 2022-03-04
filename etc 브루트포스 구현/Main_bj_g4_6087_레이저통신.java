package b0304;

import java.io.*;
import java.util.*;

public class Main_bj_g4_6087_레이저통신 {
	static int N, M;
	static char[][] map;
	static Queue<Node> queue = new LinkedList<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] visited;
	static final int MAX = 999999;
	static ArrayList<int[]> list ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			String row = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				visited[i][j] = MAX;
				map[i][j] = row.charAt(j);
				if(map[i][j] == 'C') {
					list.add(new int[] {i,j});
				}
			}
		}
		visited[list.get(0)[0]][list.get(0)[1]] = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = list.get(0)[0] + dx[i];
			int ny = list.get(0)[1] + dy[i];
			if(!isRange(nx, ny) || map[nx][ny] == '*') continue;
			queue.offer(new Node(nx, ny, i, 0));
			visited[nx][ny] = 0;
		}
		bfs();
		System.out.println(visited[list.get(1)[0]][list.get(1)[1]]);
	}
	
	private static void bfs() {
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			// 목적지 도착 
			if(cur.x == list.get(1)[0] && cur.y == list.get(1)[1]) {
				continue;
			}
			
			for(int i = 0 ; i < 4 ; i ++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(!isRange(nx, ny) || map[nx][ny] == '*') continue;
				
				// 큐에 넣고나서 더 작은 예시가 발견됐을때 
				if(cur.count != visited[cur.x][cur.y]) continue;
	
				// 같은 방향 
				if(cur.dir == i) {
					if(visited[nx][ny] >= visited[cur.x][cur.y])
					visited[nx][ny] = visited[cur.x][cur.y];
					queue.offer(new Node(nx, ny, i, visited[cur.x][cur.y]));
				}
				//거울 쓰기 
				else {
					if(visited[nx][ny] >= visited[cur.x][cur.y]+1) {
						visited[nx][ny] = visited[cur.x][cur.y]+1;
						queue.offer(new Node(nx, ny, i, visited[cur.x][cur.y] + 1));
					}
				}
			}
		}
	}

	private static boolean isRange(int nx, int ny) {
		if(0 > nx || nx >= N || 0 > ny || ny >= M) return false;
		return true;
	}

	private static class Node{
		int x, y, dir, count;

		public Node(int x, int y, int dir, int count) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
		}
		
	}
}