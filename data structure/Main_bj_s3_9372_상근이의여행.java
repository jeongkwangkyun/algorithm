package b0215;

import java.io.*;
import java.util.*;

public class Main_bj_s3_9372_상근이의여행 {
	static int T, N, M, maxValue;
	static List<Integer>[] adjList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] country;
		for(int i = 0 ; i < T ; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[N];
			for(int j = 0 ; j < N ; j++) {
				adjList[j] = new ArrayList<Integer>();
			}
			
			for(int j = 0 ; j < M ; j++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				
				adjList[from].add(to);
				adjList[to].add(from);
			}
			
			sb.append(N-1).append("\n");
		}
		System.out.println(sb);
	}
	
}
