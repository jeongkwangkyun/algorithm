import java.io.*;
import java.util.*;

public class bj_g5_16234_인구이동 {
	static int N,R,C, union ,res,cur_x,cur_y;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static boolean[][] check;
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<int[]> tmp = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		res = 0;
		for(int i=0; i<N ; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			check = new boolean[N][N];
			boolean okay = false;
			for(int i=0; i<N ; i++) {
				for (int j = 0; j < N; j++) {
					if(check[i][j]==false) {
						queue.offer(new int [] {i,j});
						union = map[i][j];
						check[i][j] = true;
						cur_x = i;
						cur_y = j;
						if(bfs()) {
							okay = true;
						}
					}
				}
			}
			if(okay == false) break;
			else res++;
		}
		System.out.println(res);
	}
	
	private static boolean bfs() {
		boolean flag = false;
		int cnt = 1 ;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			for(int i = 0 ; i <4 ; i ++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0> nx || nx>=N || 0>ny || ny>= N) continue;
				
				if(check[nx][ny]==true) continue;
				int degree = Math.abs(map[nx][ny]-map[x][y]);
				
				if(R<= degree && degree <= C) {
					flag = true;
					check[nx][ny] = true;
					queue.offer(new int[] {nx,ny});
					tmp.offer(new int[] {nx,ny});
					union += map[nx][ny];
					cnt += 1;
					
				}
			}
		}
		
		if(cnt != 1) {
			tmp.add(new int[] {cur_x,cur_y});
			int country_people = union/cnt;
			while(!tmp.isEmpty()) {
				int[] cur =tmp.poll();
				map[cur[0]][cur[1]] = country_people;
			}
		}
		return flag;
		
	}


}
