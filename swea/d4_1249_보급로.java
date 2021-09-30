package a0930;

import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map, check;
	static int n;
	static Queue<int []> queue= new LinkedList<int[]>();
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc= Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=tc ; t++) {
			n=Integer.parseInt(br.readLine());
			map=new int[n][n];
			check=new int[n][n];
			
			for(int i=0; i<n; i++) {
				String tmp=br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j]=(tmp.charAt(j)-'0');
					check[i][j]=987654321;
				}
			}
			
			bfs();
			System.out.println("#"+t+" "+check[n-1][n-1]);
		}
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		
		queue.offer(new int[] {0,0});
		check[0][0]=0;
		while(! queue.isEmpty()) {
			int[] cur =queue.poll();
			int x=cur[0];
			int y=cur[1];
			for(int i=0 ; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(check[nx][ny]> check[x][y]+map[nx][ny]) {
						check[nx][ny]=check[x][y]+map[nx][ny];
						queue.offer(new int[] {nx,ny});
					}
				}
			}
		}
	}

}
