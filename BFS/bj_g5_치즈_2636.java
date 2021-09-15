package a0915;

import java.io.*;
import java.util.*;

public class Main_bj_g5_치즈_2636_서울_12반_정광균 {
	static int n,m, time , cnt , cheese;
	static int[][] graph;
	static boolean[][] check;
	static Queue<int[]> queue=new LinkedList<int[]>(); 
	// 상 우 하 좌
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws Exception {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		graph=new int[n][m];

		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
				if(graph[i][j]==1) {
					cheese+=1;
				}
			}
		}

		while(cheese!=0) {
			//while 문이 돌아갈때마다 시간 체크
			time++;
			// bfs돌리고나면 cheese가 감소하므로 cnt에 그 전값 넣기
			cnt=cheese;
			bfs();
		}

		System.out.println(time);
		System.out.println(cnt);

	}
	private static void bfs() {
		// TODO Auto-generated method stub
		queue.offer(new int[] {0,0});
		// bfs 돌릴때마다 check값 선언
		check=new boolean[n][m];
		check[0][0]=true;

		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			for(int i=0; i<4; i++) {
				int nx=cur[0]+dx[i];
				int ny=cur[1]+dy[i];
				// 한번도 들린적 없으면
				if (0<=nx && nx< n && 0<=ny && ny<m &&check[nx][ny]==false) {
					// 1일때 껍데기면 -1하고 0으로 녹이기
					if(graph[nx][ny]==1) {
						cheese-=1;
						graph[nx][ny]=0;
					}
					// 0일때 queue에 넣어주기
					else if(graph[nx][ny]==0) {
						queue.offer(new int[] {nx,ny});
					}
					//방문처리
					check[nx][ny]=true;

				}
			}
		}




	}


}

