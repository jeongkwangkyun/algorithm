package b0311;

import java.io.*;
import java.util.*;

public class Main_bj_g4_16954_움직이는미로탈출 {
	static char[][] map = new char[8][8];
	static boolean flag;
	// 북 북동 동 남동 남 남서 서 북서 제자
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0 ; i < 8 ; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < 8 ; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		game(0, 7, 0, map);
		if(flag == true) System.out.println(1);
		else System.out.println(0);
	}
	
	// 캐릭터 - > 벽
	private static void game(int cnt, int x, int y, char[][] map) {
		if(cnt == 8) {
			flag = true;
			return;
		}
		
		if(flag == true) return;
		
		for(int i = 0 ; i < 9 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 > nx || nx >= 8 || 0 > ny || ny >= 8 || map[nx][ny] == '#') continue;
			
			// 가능한지 체크 
			if(nx - 1 < 0) {
				flag = true;
				return;
			}
			if(map[nx-1][ny] == '#') continue;
			
			// copy
			char[][] copy = new char[8][8];
			for(int index = 0 ; index < 8 ; index ++) {
				copy[index] = map[index].clone();
			}
			
			// 중력 
			for(int col = 0 ; col < 8 ; col ++) {
				for(int row = 6 ; row >= 0 ; row --) {
					copy[row + 1][col] = copy[row][col];
				}
				copy[0][col] = '.';
			}
			game(cnt + 1, nx, ny, copy);
		}
		return;
	}
}


