package samsung_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class code_battle_회문1 {
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	static int len;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		map = new char[8][8];
		for(int test_case = 1; test_case <= 10; test_case++) {
			len = Integer.parseInt(br.readLine());
			int ans = 0;
			for (int i = 0 ; i < 8 ; i++) {
				map[i] = br.readLine().toCharArray(); 
			}
			
			for (int i = 0 ; i < 8 ; i++) {
				for (int j = 0 ; j < 8 ; j++) {
					for (int k = 0 ; k < 2; k++) {						
						if (find(i, j, k)) ans ++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
	private static boolean find(int x, int y, int dir) {
		String tmp  = "";
		char buf;
		tmp += map[x][y];
		
		for (int i = 0 ; i < len - 1 ; i++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(0 > nx || nx >= 8 || 0 > ny || ny >= 8 ) return false;
			
			tmp += map[nx][ny];
			x = nx;
			y = ny;
		}
		StringBuilder sb = new StringBuilder(tmp);
		if (tmp.equals(sb.reverse().toString())) return true;
		
		return false;
	}

}
