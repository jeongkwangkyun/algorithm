package b0216;

import java.io.*;
import java.util.*;

public class Main_bj_g3_17822_원판돌리기 {
	static int N, M, T, x, d, k, point, plusPoint, count;
	static int[][] map;	
	static Queue<int[]> queue = new LinkedList<int[]>();
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		count = N * M;
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				point += map[i][j];
			}
		}
		
		for(int i = 0 ; i < T ; i++) {
			st = new StringTokenizer(br.readLine());
			// x의 배수 
			x = Integer.parseInt(st.nextToken());
			// 0 이면 시계 1 이면 반시계 
			d = Integer.parseInt(st.nextToken());
			// k 칸 
			k = Integer.parseInt(st.nextToken());
			
			for(int j = 0 ; j < k ; j++) {
				if(d == 0) forwardLotate();
				else if(d == 1) reverseLotate();
			}
			
			visited = new boolean[N][M];
			plusPoint = 0;
			for(int row = 0 ; row < N ; row++) {
				for(int col = 0 ; col < M ; col++) {
					if(map[row][col] == 0) visited[row][col] = true;
					else if(visited[row][col] == false) findEqualPoint(row, col);
				}
			}
			
			point -= plusPoint;
			if(plusPoint == 0) onePlusMinus();
		}
		System.out.println(point);
	}
	
	private static void onePlusMinus() {
		float average = (float)point / count;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0 ) continue;
				else if(map[i][j] > average) {
					map[i][j] -= 1;
					point -= 1 ;
				}
				else if(map[i][j] < average) {
					map[i][j] += 1;
					point += 1;
				}
			}
		}
	}

	private static void findEqualPoint(int x, int y) {
		visited[x][y] = true;
		queue.offer(new int[] {x, y});
		int samePoint = 0;
		int tmp = map[x][y];
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(0 > nx || nx >= N) continue;
				if(0 > ny) ny = M-1;
				if(ny >= M ) ny = 0;
				if(visited[nx][ny]) continue;
				
				if(map[nx][ny] == tmp) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
					samePoint += map[nx][ny];
					count -= 1;
					map[nx][ny] = 0;
  				}
			}
		}
		if(samePoint > 0) {
			map[x][y] = 0;
			count -= 1;
			samePoint += tmp;
		}
		plusPoint += samePoint;
	}

	private static void reverseLotate() {
		int plus = x;
		for(int i = x-1 ; i < N ; i += plus) {
			int tmp = map[i][0];
			for(int j = 0 ; j < M-1 ; j++) {
				map[i][j] = map[i][j+1];
			}
			map[i][M-1] = tmp;
		}
	}

	private static void forwardLotate() {
		int plus = x ;
		for(int i = x - 1; i < N ; i += plus) {
			int tmp = map[i][M-1];
			for(int j = M-1 ; j > 0 ; j--) {
				map[i][j] = map[i][j-1];
			}
			map[i][0] = tmp;
		}
	}
}
