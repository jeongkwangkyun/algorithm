import java.io.*;
import java.util.*;

public class Main_bj_g5_마법사상어와비바라기 {
	static int[] dx = {0,-1,-1,-1,0,1,1,1};
	static int[] dy = {-1,-1,0, 1,1,1,0,-1};
	static Queue<int[]> cloud = new LinkedList<int[]>();
	static int[][] map;
	static boolean[][] check;
	static int N,M, dir,s;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i =0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine()," "); 
			for(int j = 0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cloud.add(new int[]{N-1, 0});
		cloud.add(new int[]{N-1, 1});
		cloud.add(new int[]{N-2, 0});
		cloud.add(new int[]{N-2, 1});
		
		for(int i = 0 ; i<M ; i ++) {
			check = new boolean[N][N];
			st = new StringTokenizer(br.readLine()," ");
			dir = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			// 구름 이동 
			cloud_move();
			// 구름 있던 곳 비 내리기 
			rain();
			// 대각선 비 내리기 
			cross();
			// 구름 만들기 
			clolud_make();
		}
		int res = 0;
		for(int i = 0 ; i<N ; i++) {
			 for(int j = 0 ; j<N ; j++) {
				res += map[i][j]; 
			 }
		}
		System.out.println(res);
	}
	private static void clolud_make() {
		// TODO Auto-generated method stub
		 for(int i = 0 ; i<N ; i++) {
			 for(int j = 0 ; j<N ; j++) {
				 if(map[i][j] >=2 && check[i][j]==false) {
					 map[i][j] -= 2;
					 cloud.add(new int[] {i,j});
				 }
			 }
		 }
	}
	private static void cross() {
		// TODO Auto-generated method stub
		int size = cloud.size();
		for(int i = 0 ; i<size ; i++) {
			int[] cur = cloud.poll();
			int x = cur[0];
			int y = cur[1];
			int cnt = 0;
			for(int j=1 ; j<=4 ; j++) {
				int nx = x+dx[j*2-1];
				int ny = y+dy[j*2-1];
				if(0>nx || nx>=N || 0>ny || ny>=N) continue;
				if(map[nx][ny] == 0) continue;
				cnt ++ ;
			}
			map[x][y] += cnt;
			
		}
	}
	private static void rain() {
		// TODO Auto-generated method stub
		int size = cloud.size();
		for(int i = 0 ; i<size ; i++) {
			int[] cur = cloud.poll();
			check[cur[0]][cur[1]] = true;
			map[cur[0]][cur[1]] = map[cur[0]][cur[1]] +1;
			cloud.add(new int[] {cur[0], cur[1]});
		}
	}
	private static void cloud_move() {
		// TODO Auto-generated method stub
		int size = cloud.size();
		
		for(int i = 0 ; i<size ; i++) {
			int[] cur = cloud.poll();
			int x = cur[0];
			int y = cur[1];
			s = s/N;
			x = x + dx[dir]*s;
			y = y + dy[dir]*s;
			
			if(0>x) {
				x = N+x;
				
			}
			else if(x>=N) {
				x = x - N;
			}
			if(0>y) {
				y = N+y;
				
			}
			else if(y>=N) {
				y = y - N;
			}
			cloud.add(new int[] {x,y});
		}
	}
}
