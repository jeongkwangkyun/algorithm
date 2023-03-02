package samsung_practice;

import java.io.*;
import java.util.*;

public class code_battle_중위순회 {
	static int N;
	static char[] tree;
	static StringBuilder sb = new StringBuilder();
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];
			for(int i = 1 ; i <= N ; i++) {
				String[] tmp = br.readLine().split(" ");
				tree[i] = tmp[1].charAt(0);
			}
			
			sb.append("#").append(test_case).append(" ");
			inorder(1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
 	
	private static void inorder(int node) {
		if (node < 1 || N + 1 <= node) return;
		if (tree[node] == 0) return;
		
		inorder(2 * node);
		sb.append(tree[node]);
		inorder(2 * node + 1);
	}
}
