package b0302;

import java.io.*;
import java.util.*;

public class Main_bj_s1_16918_봄버맨 {
	static int[][] map;
	static int R, C, N, time;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		boolean[][] visited = new boolean[R][C];
		map = new int[R][C];
		for(int i = 0 ; i < R ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				if(temp.charAt(j) == 'O') map[i][j] = 3;
				
			}
		}
		
		time = 1;
		
		while(time < N) {
			time ++;
			setBomb();
			if(time >= N) break;
			time++;
			fireBomb();
		}
		
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] != 0) System.out.print('O');
				else System.out.print('.');
			}
			System.out.println();
		}
		
	}
	private static void fireBomb() {
		for(int i = 0 ; i < R ; i ++) {
			for(int j = 0 ; j < C ; j ++) {
				if(map[i][j] <= time) {
					map[i][j] = 0;
					
					for(int k = 0 ; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(0 > nx || nx >= R || 0 > ny || ny >= C) continue;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			map[cur[0]][cur[1]] = 0;
		}
	}
	private static void setBomb() {
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] == 0) map[i][j] = time + 3;
			}
		}
	}

}
