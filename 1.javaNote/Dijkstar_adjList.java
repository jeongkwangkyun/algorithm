package b0330;

import java.io.*;
import java.util.*;

public class Main_bj_g5_1753_최단경로 {
	static int V,E;
	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] adjList;
	static int[] distance;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V];
		distance = new int[V];
		visited = new boolean[V];
		
		int start = Integer.parseInt(br.readLine()) - 1;
		
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
		
		for(int i = 0 ; i < V ; i++) {
			if(distance[i] == INF) System.out.println("INF");
			else System.out.println(distance[i]);
		}
		
	}
	private static class Node{
		int v, w;
		
		public Node(int v, int e) {
			this.v = v;
			this.w = e;
		}
	}
}
