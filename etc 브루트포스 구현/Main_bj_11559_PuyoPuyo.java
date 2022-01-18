package b0118;

import java.io.*;
import java.util.*;

public class Main_bj_11559_PuyoPuyo {
	static char[][] map = new char[12][6];
	static boolean[][] visited;
	static Queue <int[]> queue = new LinkedList<>();
	static Queue<int[]> deleteQueue = new LinkedList<>();
	static int answer;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < 12 ; i++) {
			String string = br.readLine();
			for(int j = 0 ; j < 6 ; j++) {
				map[i][j] = string.charAt(j);
			}
		}
		
		while(true) {
			visited = new boolean[12][6];
			flag = false;
			for(int i = 0 ; i < 12 ; i++) {
				for(int j = 0 ; j < 6 ; j++) {
					if(map[i][j] != '.' && visited[i][j] == false) {
						bfs(i,j);
					}
				}
			}
			//4개 이상 판단 
			if(flag == false) break;
			answer ++;
			gravity();
		}
		System.out.println(answer);
		
	}
	private static void gravity() {
		for(int j = 0 ; j < 6 ; j++) {			
			for(int i = 10 ; i >= 0 ; i--) {
				for(int k = i ; k < 11 ; k++) {
					if(map[k][j] != '.' && map[k+1][j] =='.') {
						char temp = map[k][j];
						map[k+1][j] = temp;
						map[k][j] = '.';
					}
				}
			}
		}
	}
	private static void bfs(int x, int y) {
		visited[x][y] = true;
		queue.offer(new int[] {x,y});
		deleteQueue.offer(new int[] {x,y});
		int cnt = 1;
		int temp = map[x][y];
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(0 > nx || nx >= 12 || 0 > ny || ny >= 6 || visited[nx][ny] == true || map[nx][ny] != temp) continue;
				
				cnt += 1;
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny});
				deleteQueue.offer(new int[] {nx, ny});
			}
		}
		if(cnt >= 4) {
			flag = true;
			while(!deleteQueue.isEmpty()) {
				int[] cur = deleteQueue.poll();
				map[cur[0]][cur[1]] = '.';
			}
			return;
		}
		deleteQueue.clear();
		return;
	}
}
