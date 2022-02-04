package b0204;

import java.io.*;
import java.util.*;

public class Main_bj_g3_19237_어른상어 {
	static int N, M, K, sharkCount;
	static int[][] map;
	static int[][][] visited, priorityDir;
	static List<Shark> sharks;
	// 위 아래 왼 오 
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static private class Shark{
		int x, y, dir;
		public Shark(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 상어 인덱스 맵 
		map = new int[N][N];
		// 상어 냄새담는 맵, 상어 인덱스와 남은 냄새크기 
		visited = new int[N][N][2];
		// 상어 x,y,dir 
		sharks = new LinkedList<>();
		for(int i = 0 ; i < M ; i++) {
			sharks.add(new Shark(-1, -1, -1));
		}
		priorityDir = new int[M][4][4];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 ) {
					// 상어 번호 
					visited[i][j][0] = map[i][j];
					visited[i][j][1] = K;
					sharks.get(map[i][j]-1).x = i;
					sharks.get(map[i][j]-1).y = j;		
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			sharks.get(i).dir = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < 4; k++) {					
					priorityDir[i][j][k] = Integer.parseInt(st.nextToken()) - 1;
				}
			}	
		}
		
		int time = 0;
		// 먹힌 상어 
		sharkCount = 0;
		
		while(true) {
			if(time > 1000 || sharkCount == M-1) {
				break;
			}
			
			// 우선순위 방향에 따라 상어 이동 
			makeDir();
			
			// 냄새 삭제 -1
			deleteVisit();
			
			// 이동 sharks에 따라서 map 위치 이동시키기 
			moveMap();
			
			// 이동한 위치 냄새 뿌리기 
			makeVisit();
			time ++;
		}
		if(time <= 1000) System.out.println(time);
		else System.out.println(-1);
	}
	
	private static void makeVisit() {
		for(int i = 0 ; i < M ; i++) {
			int x = sharks.get(i).x;
			int y = sharks.get(i).y;
			
			if(x == -1) continue;
			
			visited[x][y][0] = i+1;
			visited[x][y][1] = K;
		}
	}

	private static void moveMap() {
		map = new int[N][N];
		for(int i = 0 ; i < M ; i++) {
			
			int x = sharks.get(i).x;
			int y = sharks.get(i).y;
			
			if(x == -1) continue;
			
			if(map[x][y] == 0) {
				map[x][y] = i + 1;
			}
			
			else {
				sharkCount += 1;
				sharks.get(i).x = -1;
				sharks.get(i).y = -1;
				sharks.get(i).dir = -1;
			}
		}
	}

	private static void deleteVisit() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(visited[i][j][1] != 0) {
					visited[i][j][1] -= 1 ;
					if(visited[i][j][1] == 0) {
						visited[i][j][0] = 0;
					}
				}
			}
		}
		
	}

	private static void makeDir() {
		// 위 아래 왼 오 
		for(int i = 0 ; i < M ; i++) {
			int dir = sharks.get(i).dir;
			if(dir == -1) continue;
			boolean flag = false;
			for(int j = 0 ; j < 4 ; j++) {
				int nd = priorityDir[i][dir][j];
				int nx = sharks.get(i).x + dx[nd];
				int ny = sharks.get(i).y + dy[nd];
				if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;
				// 냄새가 없는 장소가 있을시 
				if(visited[nx][ny][0] == 0) {
					flag =true;
					sharks.get(i).x = nx;
					sharks.get(i).y = ny;
					sharks.get(i).dir = nd;
					break;
				}
			}
			// 원래 자신의 냄새 자리로 돌아가기 
			if(flag == false) {
				for(int j = 0 ; j < 4 ; j++) {
					int nd = priorityDir[i][dir][j];
					int nx = sharks.get(i).x + dx[nd];
					int ny = sharks.get(i).y + dy[nd];
					if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;

					if(visited[nx][ny][0] == i+1) {
						sharks.get(i).x = nx;
						sharks.get(i).y = ny;
						sharks.get(i).dir = nd;
						break;
					}
				}
			}
		}
	}

}
