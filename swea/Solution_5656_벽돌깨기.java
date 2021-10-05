package a1005;

import java.io.*;
import java.util.*;

public class Solution_5656_벽돌깨기 {
	private static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	static int[][] map;
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	static int N,W,H,min;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=Integer.parseInt(br.readLine());
		for(int t=1 ; t<=tc ; t++) {
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			
			map=new int[H][W];
			for(int i=0; i<H ; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<W ; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			min=Integer.MAX_VALUE;
			go(0,map);
			System.out.println("#"+t+" "+min);
		}
	}
	// 중복순열
	private static void go(int cnt , int [][] map) {
		// TODO Auto-generated method stub
		if(cnt==N) {
			// 남아있는 벽돌수 카운트 최소값 갱신
			int result = getRemain(map);
			min = Math.min(result, min);
			return;
		}
		int [][] newMap= new int[H][W];
		for(int c=0 ; c<W ; c++) { // 0열부터 마지막 열까지 시도
			//c열에 구슬이 던져졌을 때 위에서 처음만나는 벽돌 찾기
			int r=0;
			while(r<H && map[r][c]==0) r++;
			if(r==H) { // 구슬이 맞는 벽돌이 없는 경우(모두 빈칸
				go(cnt+1,map);
			}else { // 맞은 벽돌 있는 경우
				// 이전 cnt 까지의 map 상태를 복사해서 사용
				copy(map,newMap);
				// 맞은 벽돌 및 주변 벽돌 함께 제거 처리(연쇄적 처리)
				boom(newMap, r,c);
				//제거된 벽돌들 내리기
				down(newMap);
				// 다음 구슬 던지ㅣㄱ
				go(cnt+1,newMap);
			
			}
			
		}
	}
	private static int getRemain(int[][] map) {
		// TODO Auto-generated method stub
		int count=0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]>0) count++;
			}
		}
		return count;
	}
	
	
	private static void down(int[][] map) {
		// TODO Auto-generated method stub
		
		for(int c=0; c<W ;c++) {
			int r = H-1;
			while(r>0) {
				if(map[r][c] == 0) { //빈칸이면 벽돌 내리기
					int nr= r-1; // 자신의 직전 행 부터 탐색
					while(nr > 0 && map[nr][c]==0) nr--;
					
					map[r][c] = map[nr][c]; // 현재 빈칸에는 자신의 위쪽으로 처음 만나는 벽돌로 내리기
					map[nr][c] = 0; // 내린 벽돌 자리는 빈칸으로.
				}
				--r;
			}
		}
	}
	private static void boom(int[][] map, int r, int c) {
		// TODO Auto-generated method stub
		// bfs로 함께 부숴질 벽돌처리
		Queue<Point> queue = new LinkedList<Point>();
		if(map[r][c]>1) { // 벽돌의 숫자가 1보다 클때만 주변 벽돌 연쇄 처리
			queue.offer(new Point(r,c,map[r][c]));
		}
		
		map[r][c] = 0;
		
		Point p=null;
		while(!queue.isEmpty()){
			p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr=p.r;
				int nc=p.c;
				
				for(int k=1 ; k<p.cnt ; k++) {
					nr += dr[d];
					nc += dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]!= 0) {
						if(map[nr][nc]>1) {
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc]=0;
					}
				}
			}
		}
	}
	private static void copy(int[][] map, int[][] newMap) {
		// TODO Auto-generated method stub
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
	
}
