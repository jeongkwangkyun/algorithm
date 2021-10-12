package a0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prim {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] adjMatrix=new int[N][N];
		boolean[] visited=new boolean[N];
		int[] minEdge=new int[N];
		
		StringTokenizer st=null;
		for(int i=0; i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				adjMatrix[i][j]=Integer.parseInt(st.nextToken());
			}
			minEdge[i]=Integer.MAX_VALUE;
		}
		
		int result=0;
		minEdge[0]=0;
		
		for(int i=0;i<N;i++) {
			int min=Integer.MAX_VALUE;
			int minVertex=-1;
			for(int j=0;j<N;j++) {
				if( !visited[j]&&min>minEdge[j]) {
					min=minEdge[j];
					minVertex=j;
				}
			}
			
			visited[minVertex]=true;
			result+=min;
			
			for(int j=0;j<N;j++) {
				if(!visited[j] && adjMatrix[minVertex][j]!=0 && minEdge[j]>adjMatrix[minVertex][j]) {
					minEdge[j]=adjMatrix[minVertex][j];
				}
			}
			
		}
	}

}
