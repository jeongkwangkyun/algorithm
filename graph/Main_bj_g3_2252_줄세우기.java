package b0321;

import java.io.*;
import java.util.*;

public class Main_bj_g3_2252_줄세우기 {
	static int N,M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N + 1];
		List<List<Integer>> array = new ArrayList<List<Integer>>();
		
		for(int i = 0 ; i < N + 1 ; i++) {
			array.add(new ArrayList<Integer>());
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			array.get(c1).add(c2);
			indegree[c2] ++;
		}
		
		topologicalSort(indegree, array);
		
	}

	private static void topologicalSort(int[] indegree, List<List<Integer>> array) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> answer = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= N ; i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(! queue.isEmpty()) {
			int node = queue.poll();
			answer.offer(node);
			
			for(Integer i : array.get(node)) {
				indegree[i] --;
				
				if(indegree[i] == 0) {					
					queue.offer(i);
				}
			}
		}
		
		while(! answer.isEmpty()) {
			sb.append(answer.poll()).append(" ");
		}
		
		System.out.println(sb);
	}

}
