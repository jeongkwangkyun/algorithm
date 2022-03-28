package b0328;

import java.io.*;
import java.util.*;

public class Main_bj_g1_23290_마법사상어와복제 {
	static Queue<Integer>[][] map = new LinkedList[4][4];
	static Queue<Integer>[][] copy = new LinkedList[4][4];
	static boolean[][] visited ;
	static int[][] visitCnt;
	static int[][] smellMap = new int[4][4];
	static int[] sharkDir = new int[3];
	static int M, S, max;
	static Shark shark;
	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 물고기 이동 
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1,  0, -1};
	// 상좌하우 상어 
	static int[] sx = {-1, 0, 1, 0};
	static int[] sy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				map[i][j] = new LinkedList<Integer>();
				copy[i][j] = new LinkedList<Integer>();
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			map[x][y].add(d);
			
		}
		st = new StringTokenizer(br.readLine());
		shark = new Shark(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		
		for(int i = 0 ; i < S ; i++) {
			//물고기 복사 
			copyFishmap();
			
			// 물고기 이동 
			moveFish();
			
			// 상어 이동
			moveShark();
			
			// 두번전 물고기 냄새 없애기 visited
			fishSmellDelete();
			
			//물고기 복사 떠놓은거 map 넣기 
			insertCopyFish();
		}
		max = 0;
		for(int i = 0 ; i < 4; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				max += map[i][j].size();
			}
		}
		System.out.println(max);
	}
	
	private static void insertCopyFish() {
		for(int i = 0 ; i < 4;  i++) {
			for(int j = 0 ; j < 4; j++) {
				
				while(!copy[i][j].isEmpty()) {					
					map[i][j].add(copy[i][j].poll());
				}
			}
		}
	}

	private static void fishSmellDelete() {
		for(int i = 0 ; i < 4;  i++) {
			for(int j = 0 ; j < 4; j++) {
				if(smellMap[i][j] != 0) smellMap[i][j] -= 1;
			}
		}
	}

	private static void moveShark() {
		//상 좌 하 우 
		max = Integer.MIN_VALUE;
		visitCnt = new int[4][4];
		findSharkDir(0, 0, shark.x, shark.y, new int[]{-1, -1, -1});
		visited = new boolean[4][4];
		for(int i = 0 ; i < 3; i++) {
			shark.x = shark.x + sx[sharkDir[i]];
			shark.y = shark.y + sy[sharkDir[i]];
			if(map[shark.x][shark.y].size() != 0 && visited[shark.x][shark.y] == false) {
				visited[shark.x][shark.y] = true;
				
				map[shark.x][shark.y].clear();
				
				smellMap[shark.x][shark.y] = 3;
			}
		}
		
	}
	private static void findSharkDir(int depth, int count, int x, int y, int[] arr) {
		if(depth == 3) {
			if(count > max) {
				for(int i = 0 ; i < 3; i++) {
					sharkDir[i] = arr[i];
					max = count;
				}
			}
			return;
		}
		for(int dir = 0 ; dir < 4; dir++) {
			int nx = x + sx[dir];
			int ny = y + sy[dir];
			
			if(0 > nx || nx >= 4 || 0 > ny || ny >= 4) continue;
			arr[depth] = dir;
			if(visitCnt[nx][ny] == 0) {
				visitCnt[nx][ny] += 1;
				findSharkDir(depth + 1, count + map[nx][ny].size(), nx, ny, arr);
			}
			else {
				visitCnt[nx][ny] += 1;
				findSharkDir(depth + 1, count, nx, ny, arr);
			}
			visitCnt[nx][ny] -= 1;
		}
	}

	private static void moveFish() {
		int[][] sizeMap = new int[4][4];
		for(int x = 0 ; x < 4 ; x++) {
			for(int y = 0 ; y < 4; y++) {
				sizeMap[x][y] = map[x][y].size();
			}	
		}
		
		for(int x = 0 ; x < 4 ; x++) {
			for(int y = 0 ; y < 4; y++) {
				int size = sizeMap[x][y];
				if(size == 0) continue;
				
				Loop : for(int idx = 0 ; idx < size ; idx++) {
					int dir = map[x][y].poll();
					
					for(int d = 0 ; d < 8 ; d++) {
						
						if(d != 0) dir -= 1;
						if(dir == -1) dir = 7;
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						
						if(0 > nx || nx >= 4 || 0 > ny || ny >= 4) continue;
						
						if(nx == shark.x && ny == shark.y) continue;
						
						if(smellMap[nx][ny] != 0) continue;
						
						map[nx][ny].add(dir);
						continue Loop;
					}
					// 다돌고 없으면 갈 수 있는곳이 없으면 제자리
					dir -= 1;
					map[x][y].add(dir);
				}
			}
		}
	}
	private static void copyFishmap() {
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				copy[i][j].clear();
				int size = map[i][j].size();
				
				if(size > 0) {
					for(int k = 0 ; k < size ; k ++) {
						int tmp = map[i][j].poll();

						copy[i][j].add(tmp);
						map[i][j].add(tmp);
					}
				}
			}
		}
	}

	private static class Shark{
		int x, y;

		public Shark(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
