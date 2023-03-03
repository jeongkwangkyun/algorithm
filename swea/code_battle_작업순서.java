package samsung_practice;

import java.io.*;
import java.util.*;

public class code_battle_작업순서 {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>[] parentList;
	static int[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= 1; test_case++) {
			
			int V, E;
			boolean[] isPossible;
 			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parentList = new ArrayList[V + 1];
			
			isPossible = new boolean[V + 1];
			visited = new int[V + 1];
			
			for (int i = 0 ; i < V + 1 ; i++) {
				parentList[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0 ; i < E ; i++) {
				int child = Integer.parseInt(st.nextToken());
				int parent = Integer.parseInt(st.nextToken());
				
				isPossible[parent] = true;
				parentList[child].add(parent);
				visited[parent] += 1;
			}
			
			sb.append("#").append(test_case).append(" ");
			for (int i = 1 ; i < V + 1 ; i++) {
				// dfs 돌리자 
				if (!isPossible[i]) {
					dfs(i);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur) {
		sb.append(cur).append(" ");
		int size = parentList[cur].size();
		
		for (int i = 0 ; i < size ; i++) {
			int next = parentList[cur].get(i);
			visited[next] -= 1;
			if (visited[next] == 0) {
				dfs(next);				
			}
		}
		return;
	}

}
