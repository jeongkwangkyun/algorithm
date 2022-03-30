package b0330;

import java.io.*;
import java.util.*;

public class Main_bj_g3_1238_파티 {
	static int V, E, X;
	static final int INF = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[] distance;
	static List<Node>[] adjList;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		
		adjList = new ArrayList[V];
		for(int i = 0 ; i < V ; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adjList[v].add(new Node(e, w));
		}
		
		for(int i = 0 ; i < V ; i++) {
			if(i == X) continue;
			int time = 0;
			time += dijikstra(i, X);
			time += dijikstra(X, i);
			max = Math.max(max, time);
		}
		System.out.println(max);
	}
	
	private static int dijikstra(int start, int end) {
		visited = new boolean[V];
		distance = new int[V];
		Arrays.fill(distance, INF);
		
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
				if(!visited[next.v] && distance[next.v] > min + next.w){
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
