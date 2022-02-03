package b0203;

import java.io.*;
import java.util.*;

public class Main_bj_g4_2234_성곽 {
	static int N,M;
	static int[][] map;
	static int[][] wallMap;
	static int roomNum, roomSize, breakWallRoom;
	static HashMap<Integer, Integer> hashMap = new HashMap<>();
	// 남 동 북 서 
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		wallMap = new int[N][M];
		

		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				wallMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0) bfs(i, j, wallMap[i][j]);
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				int roomIndex = map[i][j];
				for(int k = 0 ; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(0 > nx || nx >= N || 0 > ny || ny >= M || map[nx][ny] == roomIndex) continue;
					breakWallRoom = Math.max(breakWallRoom, hashMap.get(roomIndex)+hashMap.get(map[nx][ny]));
				}
			}
		}
		System.out.println(roomNum);
		System.out.println(roomSize);
		System.out.println(breakWallRoom);
	}
	private static void bfs(int x, int y, int wall) {
		roomNum += 1;
		map[x][y] = roomNum;
		int size = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y, wall});
		
		while(! queue.isEmpty()) {
			int cur[] = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curWall = cur[2];
			
			int[] dir = direction(curWall);
			
			for(int i = 0 ; i < 4; i++) {
				if(dir[i] == 1) continue;
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= M || map[nx][ny] != 0) continue;
				
				map[nx][ny] = roomNum;
				size += 1;
				queue.offer(new int[] {nx, ny, wallMap[nx][ny]});
			}
		}
		hashMap.put(roomNum, size);
		roomSize = Math.max(size, roomSize);
	}
	private static int[] direction(int curWall) {
		// 남 동 북 서 
		int[] dir = {0,0,0,0};
		
		for(int i = 3 ; i >= 0 ; i--) {			
			if(curWall == 0) break;
			dir[i] = curWall % 2;
			curWall /= 2;
		}
		return dir;
	}

}
