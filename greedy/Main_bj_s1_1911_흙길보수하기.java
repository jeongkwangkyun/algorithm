package b0329;

import java.io.*;
import java.util.*;


public class Main_bj_s1_1911_흙길보수하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Node> arr = new ArrayList<>();
		int N, L;
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken()) - 1;
			arr.add(new Node(start, end));
		}
		Collections.sort(arr);
		int idx = 0;
		int count = 0;
		for(Node node : arr) {
			while(true) {
				// start를 전꺼가 모두  덮는 상황 
				if(node.end <=idx) break;
				// 일부만 덮는 상황 
				if(idx >= node.start && idx < node.end ) {
					idx += L;
					count ++;
				}
				else {
					idx = node.start;
					idx += L - 1;
					count ++;
				}
			}
		}
		System.out.println(count);
		
	}
	private static class Node implements Comparable<Node>{
		int start, end;
		
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Node o) {
			if(this.start == o.start) {
				return o.end - this.end;
			}
			return this.start - o.start;
		}
	}
}
