package b0414;

import java.io.*;
import java.util.*;

public class Main_bj_g5_14226_이모티콘 {
	static boolean[][] visited;
	static int S;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		
		bfs();
	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, 0, 0));
		// 화면, 클립보드 
		visited = new boolean[1001][1001];
		visited[1][0] = true;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			// 조건에 해당하면 출력하고 멈추기 
			if(cur.monitor == S) {
				System.out.println(cur.time);
				break;
			}
			
			// 1번조건 - 클립보드 = 화면 
			if(cur.monitor != 0 && !visited[cur.monitor][cur.monitor]) {
				queue.offer(new Node(cur.monitor, cur.monitor, cur.time + 1));
				visited[cur.monitor][cur.monitor] = true;;
			}
				
			// 2번조건 화면 += 클립보드 
			if(cur.clipBoard != 0 && cur.monitor + cur.clipBoard <= 1000 &&!visited[cur.clipBoard + cur.monitor][cur.clipBoard] ) {
				queue.offer(new Node(cur.monitor + cur.clipBoard, cur.clipBoard, cur.time + 1));
				visited[cur.clipBoard + cur.monitor][cur.clipBoard] = true;
			}
			
			// 3번조건 화면 -= 1
			if(cur.monitor - 1 >= 0 && !visited[cur.monitor - 1][cur.clipBoard]) {
				queue.offer(new Node(cur.monitor - 1, cur.clipBoard, cur.time + 1));
				visited[cur.monitor - 1][cur.clipBoard] = true;
			}
		}
		
	}
	
	private static class Node{
		int monitor, clipBoard, time;
		
		public Node(int monitor, int clipBoard, int time) {
			this.monitor = monitor;
			this.clipBoard = clipBoard;
			this.time = time;
		}
	}
}
