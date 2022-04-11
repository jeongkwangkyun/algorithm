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
		
		for(int i = 0 ; i < N ; i++) {
			int min = INF;
			int minVertex = -1;
			
			for(int j = 0 ; j < N ; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					minVertex = j;
				}
			}
			
			if(minVertex == -1) break;
			visited[minVertex] = true;
			
			for(Node next : adjList[minVertex]) {
				if(!visited[next.v] && distance[next.v] > next.w + min) {
					distance[next.v] = next.w + min;
				}
			}
		}
		
		System.out.println(distance[N - 1]);
	}
	
	private static class Node{
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

}
