package b0302;

import java.io.*;
import java.util.*;

public class Main_bj_g5_15591_Mootube {
	static int N, Q;
	static List<int[]>[] adjList; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N];
		for(int i = 0 ; i < N ; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < N-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int value = Integer.parseInt(st.nextToken());
			adjList[from].add(new int[] {to, value});
			adjList[to].add(new int[] {from, value});
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < Q ; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken())-1;
			
			boolean[] visited = new boolean[N];
			visited[start] = true;
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] {start});
			int count = 0;
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				for(int[] point : adjList[cur[0]]) {
					// k보다 작으면 해당 모든 유사도는 k 보다 작으므로 
					if(!visited[point[0]] && k <= point[1]) {
						count ++;
						visited[point[0]] = true;
						queue.add(new int[] {point[0]});
					}
						
				}
			}
			
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
}
