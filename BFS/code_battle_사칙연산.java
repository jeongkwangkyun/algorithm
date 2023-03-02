package samsung_practice;

import java.io.*;
import java.util.*;

public class code_battle_사칙연산 {
	static int N;
	static char[] tree;
	static int[] sort_tree;
	static int idx;
	static StringBuilder sb = new StringBuilder();
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			boolean flag = true;
			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];
			idx = 0;
			for(int i = 1 ; i <= N ; i++) {
				String[] tmp = br.readLine().split(" ");
				tree[i] = tmp[1].charAt(0);
			}
			sort_tree = new int[N];
			sb.append("#").append(test_case).append(" ");
			inorder(1);
			for (int i = 0 ; i < idx - 1 ; i++) {
				int cur = sort_tree[i];
				int next = sort_tree[i + 1];
				// 현재 숫자인데 다음도 숫자
				if ((0 <= cur && cur <= 9) && (0<= next && next <= 9)) {
					flag = false;
					break;
				}
				else if ((0 > cur || cur > 9) && (0 > next || next > 9)) {					
					flag = false;
					break;
				}
					
			}
			if (flag) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
 	
	private static void inorder(int node) {
		if (node < 1 || N + 1 <= node) return;
		if (tree[node] == 0) return;
		
		inorder(2 * node);
		sort_tree[idx++] = tree[node] - '0';
		inorder(2 * node + 1);
	}
}
