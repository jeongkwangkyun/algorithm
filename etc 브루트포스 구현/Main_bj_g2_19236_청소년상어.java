package b0302;

import java.io.*;
import java.util.*;

public class Main_bj_g2_19236_청소년상어 {
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0,  -1,-1,-1, 0, 1, 1, 1};
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;

		Fish[][] map = new Fish[4][4];
		for(int i = 0 ; i < 4 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[i][j] = new Fish(num, dir-1, false);
			}
		}
		
		eatFish(0, 0, -1, 0, map);
		System.out.println(max);
	}
	
	private static void eatFish(int x, int y, int dir, int sum, Fish[][] map) {
		sum += map[x][y].num;
		dir = map[x][y].dir % 8;
		map[x][y].dead = true;
		
		max = Math.max(max, sum);
		moveFish(map, x, y);
		
		for(int d = 1 ; d <4 ; d++) {
			int nx = x + dx[dir]*d;
			int ny = y + dy[dir]*d;
			
			if(0 > nx || nx >= 4 || 0 > ny || ny >= 4) break;
			if(map[nx][ny].dead == true) continue;
			
			Fish newMap[][] = new Fish[4][4];
			for(int i = 0 ; i < 4; i++) {
				for(int j = 0 ; j < 4 ; j++) {
					newMap[i][j] = map[i][j].clone();
				}
			}
			
			eatFish(nx, ny, dir, sum, newMap);
		}
	}

	private static void moveFish(Fish[][] map, int x, int y) {
		int num = 1;
		
		while(num <= 16) {
			changePos(map, num++, x, y);
		}
	}

	private static void changePos(Fish[][] map, int num, int x, int y) {
		
		for(int i = 0 ; i < 4; i++) {
			for(int j = 0 ; j < 4; j++) {
				if(map[i][j].num == num && map[i][j].dead == false) {
					int cnt = 0;
					while(cnt < 8) {
						int dir = map[i][j].dir % 8;
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						//x,y 위치는 상어 위치 
						if(!isRange(nx, ny) || (x == nx && y == ny)) {
							map[i][j].dir ++;
							cnt++;
							continue;
						}
						
						Fish temp = map[nx][ny];
						map[nx][ny] = map[i][j];
						map[i][j] = temp;
						
						return;
					}
				}
			}
		}
	}

	private static boolean isRange(int x, int y) {
		if(x < 0 || y < 0 || x >= 4|| y >= 4) return false;
		return true;
	}

	private static class Fish{
		int num;
		int dir;
		boolean dead;
		public Fish(int num, int dir, boolean dead) {
			this.num = num;
			this.dir = dir;
			this.dead = dead;
		}
		
		public Fish clone() {
			return new Fish(num, dir, dead);
		}
	}
	

}
