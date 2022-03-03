package b0303;

import java.io.*;
import java.util.*;

public class Main_bj_g2_2933_미네랄 {
	static char[][] map;
	static int R,C;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static ArrayList<int[]> list = new ArrayList<>();
	// 동 서 북 남
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		int time = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < time ; i++) {
			int row = R - Integer.parseInt(st.nextToken());
			int[] cur;
			// 던지기
			cur = throwStick(i, row);
			// 클러스터 중력 
			if(cur[0] == -1) continue;
			
			check(cur[0], cur[1]);
			
			// 'x'이고 false인 곳이 미네랄 공중에 떠있는거
			getCluster();
			gravity();
		}
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	private static void getCluster() {
		list.clear();
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(!visited[i][j] && map[i][j] == 'x') {
					list.add(new int[] {i,j});
					map[i][j] = '.';
				}
			}
		}
	}
	private static void gravity() {
		int cnt = 1;
		boolean flag = true;
		while(true) {
			if(list.size() == 0) break;
			
			
			for(int[] cur : list) {
				if(map[cur[0] + cnt][cur[1]] == 'x') {
					cnt --;
					flag = false;
					break;
				}
				
				if(cur[0] + cnt == R-1) {
					flag = false;
					break;
				}
			}
			if(flag == false) break;
			cnt ++;
			
		}
		
		for(int[] cur : list) {
			map[cur[0] + cnt][cur[1]] = 'x';
		}
	}
	private static void check(int x, int y) {
		visited = new boolean[R][C];
		for(int i = 0 ; i < C-1 ; i++) {
			if(!visited[R-1][i]) bfs(R-1, i);
		}
	}
	private static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x, y});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(0 > nx || nx >= R || 0 > ny || ny >= C || map[nx][ny]=='.' || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				queue.add(new int[] {nx, ny});
			}
		}
	}
	
	private static int[] throwStick(int time, int row) {
		int x = -1, y = -1;
		if(time % 2 == 0) {
			for(int i = 0 ; i < C ; i++) {
				if(map[row][i] == 'x') {
					x = row;
					y = i;
					break;
				}
			}
		}
		else {
			for(int i = C - 1; i >=0 ; i--) {
				if(map[row][i] == 'x') {
					x = row;
					y = i;
					break;
				}
			}
		}
		if(x != -1) map[x][y] = '.';
		
		return new int[] {x, y};
	}

}
