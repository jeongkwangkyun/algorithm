package b0330;

import java.util.*;


import java.io.*;

public class Main_bj_g5_1916_최소비용구하기 {
	static int V, E;
	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] adjList;
	static int[] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		V = Integer.parseInt(br.readLine());
		E  = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V];
		distance = new int[V];
		visited = new boolean[V];
		for(int i = 0 ; i < V ; i++) {
			adjList[i] = new ArrayList<Node>();
			distance[i] = INF;
		}
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Node(v, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		
		distance[start] = 0;
		
		for(int i = 0 ; i < V ; i++) {
			int min = INF;
			int minVertex = -1;
			for(int j = 0 ; j < V ; j++) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					minVertex = j;
				}
			}
			
			if(minVertex == -1) break;
			visited[minVertex] = true;
			
			for(Node next : adjList[minVertex]) {
				if(!visited[next.v] && distance[next.v] > min + next.w) {
					distance[next.v] = min + next.w;
				}
			}
		}
		
		System.out.println(distance[end]);
		
	}
	private static class Node{
		int v, w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}
