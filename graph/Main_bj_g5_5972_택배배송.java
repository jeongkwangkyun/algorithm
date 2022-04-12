package b0411;

import java.io.*;
import java.util.*;

public class Main_bj_g5_5972_택배배송 {
	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Node>[] adjList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];
		distance = new int[N];
		visited = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			adjList[i] = new ArrayList<Node>();
			distance[i] = INF;
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Node(v, w));
			adjList[v].add(new Node(u, w));
		}

		distance[0] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int min = node.w;
			int minVertex = node.v;
			
			if(!visited[minVertex]) visited[minVertex] = true;
			else continue;
			
			for(Node next : adjList[minVertex]) {
				if(distance[next.v] > distance[minVertex] + next.w) {
					distance[next.v] = distance[minVertex] + next.w;
					pq.offer(new Node(next.v, distance[next.v]));
				}
			}
		}
		
		System.out.println(distance[N - 1]);
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