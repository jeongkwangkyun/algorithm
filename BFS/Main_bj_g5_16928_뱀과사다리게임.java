package b0327;

import java.io.*;
import java.util.*;

public class Main_bj_g5_16928_뱀과사다리게임 {
	static int[] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new int[100];
		
		//사다리 
		int N = Integer.parseInt(st.nextToken());
		//뱀 
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start - 1] = end - 1;
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start - 1] = end - 1;
		}
		
		bfs();
		
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[100];
		
		queue.offer(0);
		visited[0] = true;
		int time = 0;
		while(! queue.isEmpty()) {
			time ++;
			int size = queue.size();
			for(int i = 0 ; i < size ; i++) {				
				int cur = queue.poll();
				for(int plus = 1 ; plus <= 6 ; plus ++) {
					int nx = cur + plus;
					
					if(0 > nx || nx > 99 || visited[nx]) continue;
					
					if(nx == 99) {
						queue.clear();
						System.out.println(time);
						return;
					}
					
					if(map[nx] == 0) {						
						queue.add(nx);
						visited[nx] = true;
						
					}
					else {
						if(visited[map[nx]]) continue;
						queue.add(map[nx]);
						visited[map[nx]] = true;
						
					} 
					
				}
				
			}
			
		}
		
	}

}
