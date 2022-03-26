package b0326;

import java.io.*;
import java.util.*;

public class Main_bj_g5_14395_4연산 {
	static long s, t;
	static HashSet<Long> set = new HashSet<>();
	static Queue<Node> queue = new LinkedList<>();
	static String[] dir = {"*","+","-","/"};
	static long l = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Long.parseLong(st.nextToken());
		t = Long.parseLong(st.nextToken());
		
		if(s == t) {
			System.out.println(0);
		}
		else System.out.println(bfs());
		
	}
	
	private static String bfs() {
		queue.offer(new Node(s, ""));
		set.add(s);
		while(! queue.isEmpty()) {
			Node cur = queue.poll();
			if(cur.num == t) {
				return cur.word;
			}
			if(cur.num == 0) continue;
			for(int i = 0 ; i < 4 ; i++) {
				long nextNum = calculate(cur.num, i);
				if(set.contains(nextNum)) continue;
				set.add(nextNum);
				queue.offer(new Node(nextNum, cur.word + dir[i]));
			}
		}
		
		return "-1";
	}

	private static long calculate(long num, int i) {
		if(i == 0 ) return num * num;
		else if(i == 1) return num + num;
		else if(i == 2) return num - num;
		else if(i == 3) return num / num;
		
		return 0;
	}

	private static class Node{
		long num;
		String word;
		public Node(long n, String code) {
			this.num = n;
			this.word = code;
		}
		
	}
}
