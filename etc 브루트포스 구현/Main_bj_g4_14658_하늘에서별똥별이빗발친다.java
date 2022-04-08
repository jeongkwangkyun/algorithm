package b0409;

import java.io.*;
import java.util.*;

public class Main_bj_g4_14658_하늘에서별똥별이빗발친다 {
	static int N, M, L, K, answer;
	static ArrayList<Node> stones = new ArrayList<>(); 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			stones.add(new Node(x, y));
		}
		answer = 0;
		
		// K 번째 
		for(int i = 0 ; i < K ; i++) {
			for(int j = 0 ; j < K ; j++) {
				find(stones.get(i).x, stones.get(j).y);
			}
		}
		
		System.out.println(K - answer);

	}
	private static void find(int x, int y) {
		int cnt = 0;
		for(int i = 0 ; i < K ; i++) {
			if(x <= stones.get(i).x && stones.get(i).x <= x + L && 
					y <= stones.get(i).y && stones.get(i).y <= y + L) cnt++;
		}
		answer = Math.max(answer, cnt);
		
	}
	private static class Node{
		int x, y;
		
		public Node(int x , int y) {
			this.x = x;
			this.y = y;
		}
	}
}
