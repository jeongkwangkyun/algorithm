package practice_0306;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class practice_Dijikstra_PQ {
	static ArrayList<Node>[] adjList;
	static boolean[] visited;
	static int[] distance;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];
		distance = new int[N];
		visited = new boolean[N];
		
		for (int i = 0 ; i < N ; i++) {
			adjList[i] = new ArrayList<Node>();
			distance[i] = INF;
		}
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Node(v, w));
			adjList[v].add(new Node(u, w));
		}
		
		distance[0] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int min = node.w;
			int minVertext = node.v;
			
			if (!visited[minVertext]) visited[minVertext] = true;
			else continue;
			
			for (Node next : adjList[minVertext]) {
				if (distance[next.v] > distance[minVertext] + next.w) {
					distance[next.v] = distance[minVertext] + next.w;
					pq.add(new Node(next.v, distance[next.v]));
				}
			}
		}
		System.out.println(distance[N - 1]);
	}

	
	
	private static class Node implements Comparable<Node>{
		int v, w;	
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}


		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
	}
}
