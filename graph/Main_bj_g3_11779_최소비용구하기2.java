package b0331;

import java.io.*;
import java.util.*;

public class Main_bj_g3_11779_최소비용구하기2 {
	static int N, V, E, start, end;
	static int[] distance;
	static boolean[] visited;
	static int[] route;
	static ArrayList<Node>[] adjList;
	static ArrayList<Integer> routes;
	static StringBuilder sb = new StringBuilder();
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V];
		distance = new int[V];
		visited = new boolean[V];
		route = new int[V];
		
		Arrays.fill(distance, INF);
		Arrays.fill(route, -1);
		for(int i = 0 ; i < V ;i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Node(v, w));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) - 1;
		end = Integer.parseInt(st.nextToken()) - 1;
		
		distance[start] = 0;
		route[start] = -1;
		for(int i = 0 ; i < V ; i++) {
			int min = Integer.MAX_VALUE;
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
					route[next.v] = minVertex;
				}
			}
		}
		sb.append(distance[end]).append("\n");
		visited = new boolean[V];
		visited[start] = true;
		routes = new ArrayList<>();
		int now = end;
		while(now != -1) {
			routes.add(now);
			now = route[now];
		}
		sb.append(routes.size()).append("\n");
		
		for(int i = routes.size() - 1 ; i >= 0 ; i--) {
			sb.append(routes.get(i) + 1).append(" ");
		}
		System.out.println(sb);
	}

	private static class Node implements Comparable<Node>{
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}