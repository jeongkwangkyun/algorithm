package b0224;

import java.io.*;
import java.util.*;

public class Main_bj_g5_17070_파이프옮기기1 {
	static int N, answer;
	static int[][] map;
	// 동 남 동남 
	static int[] dx = {0,1,1};
	static int[] dy = {1,0,1};
	
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dir 0, 가로.  1 세로 2 대각
		dfs(0,1,0);
		System.out.println(answer);
		
	}

 	// 동 냠 동남 
	private static void dfs(int x, int y, int dir) {
		if(x == N-1 && y == N-1 && map[x][y] != 1) {
			answer += 1;
			return;
		}
		Loop : for(int i = 0 ; i < 3 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 > nx || nx >= N || 0 > ny || ny >= N || map[nx][ny] == 1) continue;
			
			// 방향 가로 
			if(dir == 0) {
				if(i == 1) continue;
				else if(i == 2) {
					if(!isAvailable(nx, ny)) continue Loop;	
				}
			}
			// 세로 
			else if(dir == 1) {
				if(i == 0) continue;
				else if(i == 2) {
					if(!isAvailable(nx, ny)) continue Loop;	
				}
			}
			else if(dir == 2){
				if(i == 2 && !isAvailable(nx, ny))  continue Loop;
			}
			
			dfs(nx,ny,i);
		}
	}

	private static boolean isAvailable(int x, int y) {
		boolean flag = true;
		int[] checkX = {-1,0};
		int[] checkY = {0,-1};
		for(int i = 0 ; i < 2; i++) {
			int nx = x + checkX[i];
			int ny = y + checkY[i];
			if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;
			if(map[nx][ny] == 1) flag =false;
		}
		return flag;
	}
}
