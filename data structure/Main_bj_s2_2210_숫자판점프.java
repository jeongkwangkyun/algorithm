package b0419;

import java.io.*;
import java.util.*;

public class Main_bj_s2_2210_숫자판점프 {
	static int[][] map = new int[5][5];
	static HashSet<String> hashSet = new HashSet<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0 ; i < 5 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				bfs(i, j);
			}
		}
		System.out.println(hashSet.size());
	}

	private static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(i, j, Integer.toString(map[i][j]), 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(int idx = 0 ; idx < 4; idx++) {
				int nx = cur.x + dx[idx];
				int ny = cur.y + dy[idx];
				
				if(cur.cnt == 5) {
					hashSet.add(cur.word);
					continue;
				}
				
				if(0 > nx || nx >= 5 || 0 > ny || ny >= 5) continue;
				
				String nextWord = cur.word + Integer.toString(map[nx][ny]);
				
				
				queue.offer(new Node(nx, ny, nextWord, cur.cnt + 1));
			}
		}
		
	}
	private static class Node{
		int x, y, cnt;
		String word;
		
		public Node(int x, int y, String word, int cnt) {
			this.x = x;
			this.y = y;
			this.word = word;
			this.cnt = cnt;
		}
	}
}
