package b0228;

import java.io.*;
import java.util.*;

public class Main_bj_s1_2251_물통 {
	static int[] arr = new int[3];
	static boolean[][] visited;
	static Set<Integer> answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		visited = new boolean[201][201];
		
		for(int i = 0 ; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = new TreeSet();
		
		dfs(0, 0, arr[2]);
		for(int num : answer) {
			System.out.print(num+" ");
		}
	}
	private static void dfs(int a, int b, int c) {
		if(visited[a][b]) return;
		
		if(a == 0) answer.add(c);
		
		visited[a][b] = true;
		// 0 -> 1
		if(a+b > arr[1]) {
			dfs((a+b)-arr[1], arr[1], c);
		}
		else {
			dfs(0, a+b, c);
		}
		
		//1 - > 0
		if(a+b > arr[0]) {
			dfs(arr[0], (a+b)-arr[0], c);
		}
		else {
			dfs(a+b, 0, c);
		}
		
		// 2-> 0
		if(a+c > arr[0]) {
			dfs(arr[0], b, (a+c)-arr[0]);
		}else {
			dfs(a+c,b,0);
		}
		
		// 2 - > 1
		if(b+c > arr[1]) {
			dfs(a, arr[1], b+c-arr[1]);
		}
		else {
			dfs(a, b+c, 0);
		}
		
		// 1 ->2
		dfs(a, 0, b+c);
		// 0 ->2
		dfs(0, b, a+c);
	}
}
