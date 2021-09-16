package a0915;

import java.io.*;
import java.util.*;

// cnt 수와 k의 남은 수를 기록하기 위해서 check를 3차원으로 선언
public class Main_bj_g4_말이되고픈원숭이_1600_서울_12반_정광균 {
	static int n,m,k;
	static int[][] graph;
	static boolean[][][] check;
	
	// x,y,cnt,k 남은수
	static class Pair{
		int x;
		int y;
		int cnt;
		int k;
		public Pair(int x, int y, int cnt, int k) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}

	}
	// 상 우 하 좌
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	// 말이 움직일 수 있는 좌표
	static int[] dx_h= {-2, -2, 2, 2, 1, -1, 1, -1};
	static int[] dy_h= {1, -1, 1, -1, 2, 2, -2, -2};

	public static void main(String[] args) throws Exception {

		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		k=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		graph=new int[n][m];
		//k 값을 넣구 3차원 
		check=new boolean[n][m][31];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		bfs();
        br.close();
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		graph[0][0]=0;
		check[0][0][0]=true;
		//queue에 Pair타입 삽입
		Queue<Pair> queue=new LinkedList<Pair>();
		// 0,0에서 출발하구 , cnt=0, k=k로 add
		queue.add(new Pair(0,0,0,k));

		while(! queue.isEmpty()) {
			Pair cur=queue.poll();
			int x=cur.x;
			int y=cur.y;
			int cnt=cur.cnt;
			int curK=cur.k;
			//도착지 도달하면,, cnt값을 비교할 필요 없는 것이 가장 빠르게 도달하는 것이 출력
			if(x==n-1 && y==m-1) {
				System.out.println(cnt);
				return;
			}
			
			if(0<=x && x<n && 0<=y && y<m) {
				if(graph[x][y]==1) continue;
				
				if(check[x][y][curK]) continue;
				
				check[x][y][curK]=true;
				// 일반점프
				for(int i=0;i<4;i++) {
					int nx=x+dx[i];
					int ny=y+dy[i];

					queue.add(new Pair(nx,ny,cnt+1,curK));
				}
				// 말 점프 못하는 경우..
				if(curK!=0) {
					for(int i=0;i<8;i++) {
						int nx=x+dx_h[i];
						int ny=y+dy_h[i];
						
						queue.add(new Pair(nx,ny,cnt+1,curK-1));
					}					
				}
			}

		}
		System.out.println(-1);
		return;
	}
}