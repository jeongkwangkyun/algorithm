package b0421;

import java.io.*;
import java.util.*;

public class Main_bj_g1_21611_마법사상어와블리자드 {
	static int answer = 0;
	static int N, M, limit, dir, x, y, dist, a;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[] dirX = {0, 1, 0, -1};
	static int[] dirY = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			
			// d 방향 벽 파괴 
			breakDirMarble(d, s);
			
			// 구슬 땡기기
			removeHole();
			
			// 연속되는 4개 무한 파괴
			breakSeriesMarble();
			
			// 그룹화 한거 map에 다시 넣기 
			makeGrouping();
			
		}
		System.out.println(answer);
	}
	// 이것도 카피해서 map에 채워야할듯 
	private static void makeGrouping() {
		Queue<int[]> queue = new LinkedList<>();
		int[] groupArr = new int[N * N];
		int idx = 0;
		
		int curX = N / 2;
		int curY = N / 2;
		int dir = 0;
		
		int cnt = 0;
		int len = 0;
		
		Loop : while(true) {
			for(int i = 0 ; i <= len ; i++) {	
				int nx = curX + dirX[dir];
				int ny = curY + dirY[dir];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= N || map[nx][ny] == 0) break Loop;
		
				
				// 같은 경우 
				if(map[curX][curY] == map[nx][ny]) {
					queue.offer(new int[] {nx, ny});
				}
				
				else {					
					if(idx <= groupArr.length - 1 && !queue.isEmpty()) {
						groupArr[idx ++] = queue.size();
					}
					if(idx <= groupArr.length - 1 && !queue.isEmpty()) {
						groupArr[idx ++] = map[curX][curY];
					}
					
					queue.clear();
					queue.add(new int[] {nx, ny});
				}	
				curX = nx;
				curY = ny;
			}
			cnt += 1;
			
			if(cnt >= 2) {		
				len ++;
				cnt = 0;
			}
			dir = (dir + 1) % 4;	
		}
		
		
		map = new int[N][N];
		
		curX = N / 2;
		curY = N / 2;
		
		int d = 0;
		
		cnt = 0;
		len = 0;
		idx = 0;
		
		Loop : while(true) {
			for(int i = 0 ; i <= len ; i++) {				
				int nx = curX + dirX[d];
				int ny = curY + dirY[d];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= N) break Loop;
				
				map[nx][ny] = groupArr[idx++];
				
				curX = nx;
				curY = ny;
			}
			cnt += 1;
			
			if(cnt >= 2) {		
				len ++;
				cnt = 0;
			}
			d = (d + 1) % 4;
		}
	}

	// 구슬깬거 빈벽 땡기기 
	private static void removeHole() {
		// 그냥 맵과 카피 맵을 만들어서, 맵은 그냥 영으로 초기화 하고 인덱스를 기준으로 copymap 0이 아닌거
		int[][] copyMap = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			copyMap[i] = Arrays.copyOf(map[i], N);
		}
		map = new int[N][N];
		
		int copyX = N / 2;
		int copyY = N / 2;
		int copyDir = 0;
		x = N / 2;
		y = N / 2;
		
		int cnt = 0;
		int len = 0;
		
		Loop : while(true) {
			for(int i = 0 ; i <= len ; i++) {	
				int nx = copyX + dirX[copyDir];
				int ny = copyY + dirY[copyDir];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= N) break Loop;
				
				// 값 복사 
				if(copyMap[nx][ny] != 0) {
					nextMapIndex();
					map[x][y] = copyMap[nx][ny];
				}
				
				copyX = nx;
				copyY = ny;
			}
			cnt += 1;
			
			if(cnt >= 2) {		
				len ++;
				cnt = 0;
			}
			copyDir = (copyDir + 1) % 4;	
		}
	}

	private static void nextMapIndex() {
		int curX = N /2;
		int curY = N/2;
		
		int d = 0;
		
		int cnt = 0;
		int len = 0;
		
		
		Loop : while(true) {
			for(int i = 0 ; i <= len ; i++) {				
				int nx = curX + dirX[d];
				int ny = curY + dirY[d];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= N) break Loop;
				
				if(map[nx][ny] == 0) {
					x = nx;
					y = ny;
					break Loop;
				}
				
				curX = nx;
				curY = ny;
			}
			cnt += 1;
			
			if(cnt >= 2) {		
				len ++;
				cnt = 0;
			}
			d = (d + 1) % 4;
			
			
		}
	}

	private static void breakSeriesMarble() {
		Queue<int[]> queue = new LinkedList<>();
		
		while(true) {
			int curX = N / 2;
			int curY = N / 2;
			int d = 0;
			int size = 1;
			queue.offer(new int[] {curX, curY});
			boolean flag = false;
			
			int cnt = 0;
			int len = 0;
			
			Loop : while(true) {
				for(int i = 0 ; i <= len ; i++) {				
					int nx = curX + dirX[d];
					int ny = curY + dirY[d];
					
					if(0 > nx || nx >= N || 0 > ny || ny >= N || map[nx][ny] == 0) break Loop;
					
					// 같은 경우 
					if(map[curX][curY] == map[nx][ny]) {
						size ++;
						queue.offer(new int[] {nx, ny});
					}
					else {
						if(size >= 4) {
							while(!queue.isEmpty()) {
								int[] cur = queue.poll();
								countPoint(map[cur[0]][cur[1]]);
								map[cur[0]][cur[1]] = 0;
							}
							flag = true;
						}
						else queue.clear();
						
						queue.add(new int[] {nx, ny});
						size = 1;
					}
					
					curX = nx;
					curY = ny;
				}
				cnt += 1;
				
				if(cnt >= 2) {		
					len ++;
					cnt = 0;
				}
				d = (d + 1) % 4;
				
				
			}
			if(flag == false)	break;
			
			removeHole();
		}
	}

	private static void breakDirMarble(int d, int s) {
		x = N / 2;
		y = N / 2;
		
		for(int i = 0 ; i < s ; i++) {
			x += dx[d];
			y += dy[d];
			if(0 > x || x >= N || 0 > y || y >= N) break;
			if(map[x][y] != 0) {

				map[x][y] = 0;
			}
			
		}
	}

	private static void countPoint(int num) {
		if(num == 1) answer ++;
		else if(num == 2) answer += 2;
		else if(num == 3) answer += 3;
	}
}
