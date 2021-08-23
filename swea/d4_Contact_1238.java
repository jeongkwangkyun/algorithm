package a0823;

import java.io.*;
import java.util.*;


public class d4_Contact_1238 {
	// TODO Auto-generated method stub
	static Queue<Integer> queue=new LinkedList<Integer>();
	static Stack<Integer> stack=new Stack<Integer>();
	
	static int[][] graph;
	static int[] check;
	static int n;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1238.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=10;tc++) {
			st=new StringTokenizer(br.readLine()," ");
			n=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken())-1;
			
			st=new StringTokenizer(br.readLine()," ");
			graph= new int[n][n];
			check = new int[n];
			while(st.countTokens()!=0) {
				int start=Integer.parseInt(st.nextToken());
				int end=Integer.parseInt(st.nextToken());
				graph[start-1][end-1]=1;
			}
			queue.offer(x);
			bfs();
			int total=x;
			for(int i=0; i<n;i++) {
				if(check[total]<=check[i]) {
					total=i;
				}
			}
			sb.append("#").append(tc).append(" ").append(total+1).append("\n");
		}
		System.out.println(sb);
		
	}

	private static void bfs() {
		// TODO Auto-generated method stub

		int tmp=queue.poll();
		check[tmp]=1;
		
		for(int i=0;i<n;i++) {
			if(graph[tmp][i]==1 ) {
				queue.add(tmp);
				queue.add(i);
			}
		}
		
		while(! queue.isEmpty()) {
			int start=queue.poll();
			int end=queue.poll();
			for(int i=0;i<n;i++) {
				if(graph[end][i]==1 && check[end]==0) {
					queue.add(end);
					queue.add(i);
				}
			}	
			
			if(check[end]==0) {
				check[end]=check[start]+1;
			}else {
				if(check[end]>check[start]+1) {
					check[end]=check[start]+1;
				}
			}
			
		}
		
	}


}
