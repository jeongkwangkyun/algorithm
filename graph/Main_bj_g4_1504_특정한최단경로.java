package b0330;

import java.util.*;
import java.io.*;

public class Main_bj_g4_1504_특정한최단경로 {
	static int V, E;
	static final long INF = Long.MAX_VALUE;
	static List<Node>[] adjList;
	static long[] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E  = Integer.parseInt(st.nextToken());
		if(E == 0) {
			System.out.println(-1);
			return;
		}
		adjList = new ArrayList[V];
		distance = new long[V];
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
			adjList[v].add(new Node(u, w));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()) - 1;
		int v2 = Integer.parseInt(st.nextToken()) - 1;
		
		long tmp = 0;
		tmp += dijkstra(0, v1);
		tmp += dijkstra(v1, v2);
		tmp += dijkstra(v2, V-1);
		
		long tmp2 = 0;
		tmp2 += dijkstra(0, v2);
		tmp2 += dijkstra(v2, v1);
		tmp2 += dijkstra(v1, V-1);
		long answer = Math.min(tmp, tmp2);
		if(answer == INF) System.out.println(-1);
		else System.out.println(answer);
		
	}
	private static long dijkstra(int start, int end) {
		
		distance = new long[V];
		visited = new boolean[V];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		for(int i = 0 ; i < V ; i++) {
			long min = INF;
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
		return distance[end];
	}
	private static class Node{
		int v, w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}

