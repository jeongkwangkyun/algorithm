package b0423;

import java.io.*;
import java.util.*;

public class Main_bj_s1_1325_효율적인해킹 {
	static int N, M;
	static boolean[] visited;
	static int[] cnt;

	static HashMap<Integer, Integer> hashMap = new HashMap<>();
	static ArrayList<Integer>[] computer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		computer = new ArrayList[N + 1];
		cnt = new int[N + 1];
		
		for(int i = 1 ; i <= N ; i++) {
			computer[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			computer[a].add(b);
		}
		
		for(int i = 1 ; i <= N ; i++) {
			visited =new boolean[N + 1];
			dfs(i);
		}
		
		StringBuilder sb = new StringBuilder();
		 int max = 0;
		 
        for(int i = 1; i <= N; i++){
            max = Math.max(max, cnt[i]);
        }
 
        for(int i = 1; i <= N; i++){
            if(max == cnt[i]) sb.append(i + " ");
        }
		System.out.println(sb);
		
	}
	private static void dfs(int i) {
		visited[i] = true;
		for(int next : computer[i]) {
			if(!visited[next]) {
				cnt[next] ++;
				dfs(next);
			}
		}
	}

}
