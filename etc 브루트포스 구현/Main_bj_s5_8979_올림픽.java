package b0416;

import java.io.*;
import java.util.*;

public class Main_bj_s5_8979_올림픽 {
	static int N, K;
	static PriorityQueue<Node> queue = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			queue.offer(new Node(idx, gold, silver, bronze));
		}
		
		int idx = 1;
		Node before = queue.poll();
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			if(before.idx == K) {
				break;
			}
			
			if(before.gold != cur.gold || before.silver != cur.silver || before.bronze != cur.bronze) {
				idx ++;
			}
			before = cur;
			
		}
		System.out.println(idx);
	}
	private static class Node implements Comparable<Node>{
		int idx, gold, silver, bronze;
		
		public Node(int idx, int gold, int silver, int bronze) {
			this.idx = idx;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
		public int compareTo(Node o) {
			if(o.gold == this.gold) {
				if(o.silver == this.silver) {
					return o.bronze - this.bronze;
				}
				return o.silver - this.silver;
			}
			return o.gold - this.gold;
		}
	}
}
