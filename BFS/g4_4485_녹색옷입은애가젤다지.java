package a0929;

import java.io.*;
import java.util.*;

// bfs문제 check 현재 위치를 도달할 수 있는 최솟값을 갱신하면서 탐색
public class g4_4485_녹색옷입은애가젤다지 {
	static int[][] map, check;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int tc=1;
		while(true) {
			n=Integer.parseInt(br.readLine());
			map=new int[n][n];
			check=new int[n][n];
			if(n!=0) {
				for(int i=0; i<n;i++) {
					st= new StringTokenizer(br.readLine()," ");
					for(int j=0 ; j<n; j++) {
						map[i][j]=Integer.parseInt(st.nextToken());
						check[i][j]=987654321;
					}
				}

				bfs(0,0);
				System.out.println("Problem "+ tc++ +": "+check[n-1][n-1]);

			}
			else {
				break;
			}

		}
		br.close();
	}
	private static void bfs(int a, int b) {
		// TODO Auto-generated method stub
		check[a][b]=map[a][b];
		queue.offer(new int[] {a,b});
		while(! queue.isEmpty()) {
			int[] cur=queue.poll();
			int x=cur[0];
			int y=cur[1];
			for(int i=0; i<4; i++) {
				int nx= cur[0] + dx[i];
				int ny= cur[1] + dy[i];

				if(0<=nx && nx<n && 0<=ny && ny<n) {
					// check에 현재까지 온 거리합 갱신 
					if(check[nx][ny]>check[x][y]+map[nx][ny]) {
						check[nx][ny]=check[x][y]+map[nx][ny];
						queue.offer(new int[] {nx,ny});
					}
				}
			}
		}
	}

}
