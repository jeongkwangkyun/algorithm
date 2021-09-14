package a0824;

import java.io.*;
import java.util.*;

class Node{
	int vertex,weight;

	public Node(int vertex, int weight) {
		super();
		this.vertex = vertex;
		this.weight = weight;
	}
}
public class bj_g5_최단경로_1753 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V=Integer.parseInt(st.nextToken()); 
		int E=Integer.parseInt(st.nextToken()); 
		int start=Integer.parseInt(br.readLine())-1;

		List<Node>[] adjList=new ArrayList[V];
		for(int i=0; i<V;i++) {
			adjList[i]=new ArrayList<Node>();
		}
		final int INFINITY = Integer.MAX_VALUE;

		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		Arrays.fill(distance, INFINITY);

		for(int i=0; i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u=Integer.parseInt(st.nextToken())-1;
			int v=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			adjList[u].add(new Node(v,w));
		}
		
		distance[start]=0;

		for(int i=0;i<V;++i) {
			int min=INFINITY;
			int minVertex=-1;
			for(int j=0;j<V;++j) {
				if(!visited[j] && distance[j] <min) {
					min = distance[j];
					minVertex=j;
				}
			}
			if(minVertex==-1) break;
			visited[minVertex]=true;

			for(Node next:adjList[minVertex]) {
				if( !visited[next.vertex] &&  distance[next.vertex]>min+next.weight) {
					distance[next.vertex]=min+next.weight;
				}
			}
		}
		for(int i=0;i<V;i++) {
			if(distance[i]==INFINITY) {
				System.out.println("INF");
			
			}
			else {
				System.out.println(distance[i]);
			}
		}
		br.close();
	}

}

