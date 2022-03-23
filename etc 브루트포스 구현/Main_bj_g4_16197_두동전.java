package b0323;

import java.io.*;
import java.util.*;

public class Main_bj_g4_16197_두동전 {
	static int N, M;
	static char[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		int idx = 0;
		
		int[][] location = new int[2][2];
		
		for(int i = 0 ; i < N ; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'o') {
					location[idx][0] = i;
					location[idx][1] = j;
					idx += 1;
				}
			}
		}
		
		bfs(location);
		
	}

	private static void bfs(int[][] arr) {
		Queue<int[]> queue = new LinkedList<>();
		// x1, y1, x2, y2, size
		queue.offer(new int[] {arr[0][0], arr[0][1], arr[1][0], arr[1][1], 0});
		
		while(! queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[4] >= 10) {
				System.out.println(-1);
				break;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int flag = 0;
				int x1 = cur[0] + dx[i];
				int y1 = cur[1] + dy[i];
				int x2 = cur[2] + dx[i];
				int y2 = cur[3] + dy[i];
				
				if(isRange(x1, y1)) {
					flag += 1;
					
				}
				else if(map[x1][y1] == '#') {
					x1 = cur[0];
					y1 = cur[1];
				}
				
				if(isRange(x2, y2)) {
					flag += 1;
				}
				else if(map[x2][y2] == '#') {
					x2 = cur[2];
					y2 = cur[3];
				}
				
				if(flag == 1) {
					System.out.println(cur[4] + 1);
					queue.clear();
					break;
				}
				else if(flag == 2) {
					continue;
				}
				queue.offer(new int[] {x1, y1, x2, y2, cur[4] + 1});
				
			}
		}
		
	}

	private static boolean isRange(int x1, int y1) {
		
		if(0 > x1 || x1 >= N || 0 > y1 || y1 >= M) return true;
		
		return false;
	}

}
