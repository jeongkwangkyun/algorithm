package b0214;

import java.util.*;
import java.io.*;

public class Main_bj_g4_17135_캐슬디펜스 {	
	static int N, M, D, maxCount, enemyCount;
	static int[][] map, tempMap;
	static int[] number;
	static Queue<int[]> queue = new LinkedList<int[]>();
	// 왼 위 오 
	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		number = new int[3];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		combination(0, 0);
		System.out.println(maxCount);
	}
	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			enemyCount = 0;
			tempMap = new int[N+1][M];
			copyMap();
			game();
			maxCount = Math.max(maxCount, enemyCount);
			return;
		}
		
		for(int i = start ; i < M ; i++) {
			number[cnt] = i;
			combination(cnt + 1, i+1);
		}
		
	}
	private static void copyMap() {
		for(int i = 0 ; i < N+1 ; i++) {
			for(int j = 0 ; j < M ; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
	}
	private static void game() {
		for(int i = 0 ; i < N ; i++) {
			killNearEnemy();
			forwardEnemy();
		}
	}
	private static void forwardEnemy() {
		for(int j = 0 ; j < M ; j++) {
			for(int i = N-2 ; i >= 0 ; i--) {
				tempMap[i+1][j] = tempMap[i][j];
			}
		}
		for(int j = 0 ; j < M ; j ++) {
			tempMap[0][j] = 0;
			tempMap[N][j] = 0;
		}
	}
	private static void killNearEnemy() {
		Queue<int[]> killQueue = new LinkedList<int[]>();
		for(int i = 0 ; i < 3; i++) {
			int x = N;
			int y = number[i];
			queue.offer(new int[]{x,y});
			boolean[][] visited = new boolean[N+1][M];
			int degree = 0;
			while(!queue.isEmpty()) {
				if(degree == D) {
					queue.clear();
					break;
				}
				int size = queue.size();
				Loop : for(int j = 0 ; j < size ; j++) {
					int[] cur = queue.poll();
					
					for(int k = 0 ; k < 3 ; k++) {
						int nx = cur[0] + dx[k];
						int ny = cur[1] + dy[k];
						
						if(0 > nx || 0 > ny || ny >= M || visited[nx][ny]) continue;
						
						if(tempMap[nx][ny] == 1) {
							killQueue.add(new int[] {nx, ny});
							queue.clear();
							break Loop;
						}
						
						visited[nx][ny] = true;
						queue.add(new int[] {nx,ny});
					}
				}
				degree++;
			}
		}
		while(!killQueue.isEmpty()) {
			int[] cur = killQueue.poll();
			
			if(tempMap[cur[0]][cur[1]] == 1) {
				tempMap[cur[0]][cur[1]] = 0;
				enemyCount += 1;
			}
		}
	}
}
