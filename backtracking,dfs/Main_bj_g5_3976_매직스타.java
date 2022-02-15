package b0215;

import java.io.*;
import java.util.*;

public class Main_bj_g5_3976_매직스타 {
	static char[][] map = new char[5][9];
	static boolean[] visited = new boolean[13];
	static int[][][] star = {
			{{0,4},{1,3},{2,2},{3,1}},
            {{3,1},{3,3},{3,5},{3,7}},
            {{0,4},{1,5},{2,6},{3,7}},
            {{1,1},{1,3},{1,5},{1,7}},
            {{1,1},{2,2},{3,3},{4,4}},
            {{4,4},{3,5},{2,6},{1,7}}
	};
	static ArrayList<Node> list = new ArrayList<>();
	static int size;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < 5 ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = tmp.charAt(j);
				if(tmp.charAt(j) == 'x') {
					list.add(new Node(i, j));
				}
				else if(tmp.charAt(j) != '.') {
					visited[tmp.charAt(j) - 'A' + 1] = true;
				}
			}
		}
		
		size = list.size();
		dfs(0, 0);
		
	}
	
	private static void dfs(int cnt, int idx) {
		if(cnt == size && check()) {
			for(int i = 0 ; i < 5 ; i++) {
				System.out.println(map[i]);
			}
			System.exit(0);
		}
		
		for(int i = 1 ; i <= 12 ; i++) {
			if(visited[i]) continue;
			
			Node cur = list.get(idx);
			visited[i] = true;
			map[cur.x][cur.y] = (char)(i + 64);
			dfs(cnt+1, idx+1);
			visited[i] = false;
			map[cur.x][cur.y] = 'x';
		}
	}

	private static boolean check() {
		for(int i = 0 ; i < 6 ; i++) {
			int sum = 0;
			for(int j = 0 ; j < 4 ; j ++) {
				sum += map[star[i][j][0]][star[i][j][1]] - 'A' + 1;
			}
			if(sum != 26) return false;
		}
		
		return true;
	}

	private static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}