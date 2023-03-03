package samsung_practice;

import java.io.*;
import java.util.*;

public class code_battle_공통조상 {
	static Node[] tree;
	static ArrayList<Integer>[] parentList;
	static boolean[] visited;
	static int root;
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int V, E;
			root = 0;
			cnt = 0;
			boolean[] isPossible;
 			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			tree = new Node[V + 1];
			parentList = new ArrayList[V + 1];
			visited = new boolean[V + 1];
			
			for (int i = 0 ; i < V + 1 ; i++) {
				tree[i] = new Node();
				parentList[i] = new ArrayList<>();
			}
			
			for (int i = 0 ; i < E ; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parentList[child].add(parent);
				
				if (tree[parent].left == 0) tree[parent].left = child;
				else tree[parent].right = child;
			}
			dfs(a);
			dfs(b);
			count_tree(root);
			sb.append("#").append(test_case).append(" ").append(root).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	private static void count_tree(int num) {
		cnt += 1;
		if (tree[num].left != 0) count_tree(tree[num].left);
		if (tree[num].right != 0) count_tree(tree[num].right);
	}
	private static void dfs(int cur) {
		visited[cur] = true;
		int size = parentList[cur].size();
		
		for (int i = 0 ; i < size ; i++) {			
			int next = parentList[cur].get(i);
			if (visited[next]) root = next;
			else if (parentList[next].size() == 0) root = next;
			else
				dfs(next);
		}
	}
	private static class Node {
		int data;
		int left;
		int right;
	}
}
