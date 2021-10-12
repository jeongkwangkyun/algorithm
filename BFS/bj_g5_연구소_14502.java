package a0917;

import java.io.*;
import java.util.*;

// bfs문제 
// 벽을 만들 수 있는 갯수는 최대가 3개이므로 3개 디폴트 

public class bj_g5_연구소_14502 {
	static int n,m;
	static int[][] graph;
	static int[][] check;
	static Queue<int[]> queue=new LinkedList<int[]>();
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static int max_val=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph=new int[n][m];
		check=new int[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//2차원 배열에서 combination
		make_wall(0);
		System.out.println(max_val);
	}
	// 3개의 벽을 만들고나면 bfs
	private static void make_wall(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==3) {
			bfs();
			return;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j]==0) {
					graph[i][j]=1;
					make_wall(cnt+1);
					graph[i][j]=0;
				}
			}
		}
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		
		int tmp=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//원본 복사 값
				check[i][j]=graph[i][j];
				if(check[i][j]==2) {
					queue.add(new int[] {i,j});
				}
			}
		}
		
		
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=cur[0]+dx[i];
				int ny=cur[1]+dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(check[nx][ny]==0) {
						check[nx][ny]=2;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0;j<m;j++) {
				if(check[i][j]==0) {
					tmp+=1;
				}
			}
		}
		
		max_val=Math.max(max_val, tmp);
		
	}

	

}
