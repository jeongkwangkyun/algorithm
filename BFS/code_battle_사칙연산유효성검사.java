package samsung_practice;

import java.io.*;
import java.util.*;

public class code_battle_사칙연산유효성검사 {
	static int N;
	static int idx;
	static StringBuilder sb = new StringBuilder();
	static Node[] node = new Node[1001];
	static int ans;
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			N = Integer.parseInt(br.readLine());
			idx = 0;
			
			for(int i = 1 ; i <= N ; i++) {
				st = new StringTokenizer(br.readLine());
				node[i] = new Node();
				st.nextToken();
				String oper = st.nextToken();
				if (oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
					node[i].oper = oper;
					node[i].left = Integer.parseInt(st.nextToken());
					node[i].right = Integer.parseInt(st.nextToken());
				}
				else node[i].data =Integer.parseInt(oper);
			}
			sb.append("#").append(test_case).append(" ");
			ans = postOrder(1);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
 	
	private static int postOrder(int idx) {
		Node cur = node[idx];
		String oper = node[idx].oper;
		
		if (oper != null && oper.equals("+"))
			ans = postOrder(node[idx].left) + postOrder(node[idx].right);
		else if (oper != null && oper.equals("-"))
			ans = postOrder(node[idx].left) - postOrder(node[idx].right); 
		else if (oper != null && oper.equals("*"))
			ans = postOrder(node[idx].left) * postOrder(node[idx].right);
		else if (oper != null && oper.equals("/"))
			ans = postOrder(node[idx].left) / postOrder(node[idx].right);
		else
			ans = node[idx].data;
		
		return ans;
			
	}
	
	public static class Node {
		int left;
		int right;
		int data;
		String oper;
	}
}
