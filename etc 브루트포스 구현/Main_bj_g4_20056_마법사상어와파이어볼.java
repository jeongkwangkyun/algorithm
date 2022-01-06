package b0106;

import java.io.*;
import java.util.*;

public class Main_bj_g4_20056_마법사상어와파이어볼 {
	static int N, M, K, answer;
	static Queue<Fire> fires;
	static Queue<Fire>[][] map;
	static int[] dx = {-1,-1,0,1,1, 1, 0,-1};
	static int[] dy = {0 ,1 ,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		answer = 0;
		fires =new LinkedList<>();
		
		map = new LinkedList[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = new LinkedList<Fire>();
			}
		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fires.offer(new Fire(r,c,m,s,d));
		}
		
		while(K > 0) {
			
			K--;
			fireMove();
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j< N ; j++) {
					// 2개이상 queue 넣어주
					int mapSize = map[i][j].size();
					if(mapSize >= 2) {
						fireDivide(i,j);
					}
					// 1개는 그냥 넣어주기 
					else if(mapSize == 1) {
						fires.offer(map[i][j].poll());
					}
				}
			}
		}
		while(! fires.isEmpty()) {
			Fire fire = fires.poll();
			answer += fire.m;
		}
		System.out.println(answer);
	}
	
	private static void fireDivide(int x, int y) {
		int totalM = 0, totalS = 0, totalD = 0;
		int fireCnt = map[x][y].size();
		
		int oddFlag = map[x][y].peek().d % 2;
		boolean flag = true;
		while(! map[x][y].isEmpty()) {
			Fire fire = map[x][y].poll();
			totalM += fire.m;
			// 1,3,5,7 조건 , 모두 홀짝이 아닐때 
			if(oddFlag != fire.d % 2) flag = false;
			totalS += fire.s;
			totalD += fire.d;
		}
		
		if(totalM/5 == 0) return;
		
		int start = 0;
		if(!flag) start += 1;
		
		for(int i = start ; i < 8 ; i += 2) {
			fires.add(new Fire(x, y, totalM/5, totalS/fireCnt, i));
		}
	}

	private static void fireMove() {
		while(! fires.isEmpty()) {
			Fire fire = fires.poll();
			for(int i = 0 ; i < fire.s ; i++) {
				int nx = fire.r + dx[fire.d];
				int ny = fire.c + dy[fire.d];
				
				fire.r = isAvailiable(nx);
				fire.c = isAvailiable(ny);
			}
			map[fire.r][fire.c].offer(fire);
		}
	}

	private static int isAvailiable(int location) {
		if(location < 0) {
			location =  N-1;
		}
		else if (location >= N) {
			location = 0;
		}
		return location;
	}

	static class Fire{
		int r,c,m,s,d;
		//row,col, 질량,속력, 방향 
		public Fire(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

}
