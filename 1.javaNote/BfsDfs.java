package a0810;

import java.util.*;
import java.util.LinkedList;

public class BfsDfs {
	static int[] di= {-1,0,1,0}; //상우하좌
	static int[] dj= {0,1,0,-1};
	static int n=5, cnt;
	static int[][] a;
	static boolean[][] v;
	
	static void bfs(int i, int j) {
		Queue<int[]> q=new LinkedList<int[]>();
		v[i][j]=true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			i=cur[0];
			j=cur[1];
			a[i][j]=cnt++;
			for(int d=0 ; d<4 ; d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni && ni<n &&0<=nj && nj<n &&!v[ni][nj]) {
					v[ni][nj]=true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	
	static void dfs(int i, int j) {
		v[i][j]=true;
		a[i][j]=cnt++;
		for(int d=0 ; d<4 ; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni && ni<n &&0<=nj && nj<n &&!v[ni][nj]) {
				dfs(ni,nj);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a=new int[n][n];
		v=new boolean[n][n];
		cnt=1;
		bfs(n/2,n/2);
		for(int[] b:a) System.out.println(Arrays.toString(b));
		System.out.println();
		
		a=new int[n][n];
		v=new boolean[n][n];
		cnt=1;
		dfs(n/2,n/2);
		for(int[] b:a) System.out.println(Arrays.toString(b));
		System.out.println();
	}

}
