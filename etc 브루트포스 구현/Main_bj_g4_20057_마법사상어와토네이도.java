package b0108;
import java.io.*;
import java.util.*;

public class Main_bj_g4_20057_마법사상어와토네이도 {
	static int N, curX, curY, curDir, answer;
	static int[][] map;
	//서 남 동 북 
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[][][] direct = { 
			// 모래 위치 기준으로 방향에 따라서 나눠주기 
			//서 
			{ { 1, -1, 2, -2, 0, 1, -1, 1, -1, 0 }, { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 } },
			// 남 
			{ { -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 }, { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 } },
			// 동 
			{ { 1, -1, 2, -2, 0, 1, -1, 1, -1, 0 }, { -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 } },
			// 북 
			{ { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 }, { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 } } 
	};
	static int[] percent = {1, 1, 2, 2, 5, 7, 7, 10, 10};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		answer = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		curX = N/2;
		curY = N/2;

		int idx = -1;
		int len = 0;
		curDir = 0;
		while(true) {
			if(++idx%2 == 0) {
				len ++;
			}
			for(int i = 0 ; i < len ; i++) {
				sandMove();
				windMove();
			}

			curDir = (curDir+1) % 4;

			if(len == N) {
				break;
			}
		}
		System.out.println(answer);
	}

	private static void windMove() {
		curX = curX + dx[curDir];
		curY = curY + dy[curDir];
	}

	private static void sandMove() {
		int nx = curX + dx[curDir];
		int ny = curY + dy[curDir];
		int sandX = nx;
		int sandY = ny;
		if(0> nx || nx>= N || 0>ny || ny>=N) return;

		int sand = map[nx][ny];

		if(sand == 0) return;

		for(int i = 0 ; i < 9 ; i++) {
			nx = sandX + direct[curDir][0][i];
			ny = sandY + direct[curDir][1][i];

			int amount = map[sandX][sandY] * percent[i] / 100;
			sand -= amount;

			if(0> nx || nx>= N || 0>ny || ny>=N) {
				answer += amount;
			}
			else map[nx][ny] += amount;
		}

		nx = sandX + direct[curDir][0][9];
		ny = sandY + direct[curDir][1][9];

		if(0> nx || nx>= N || 0>ny || ny>=N) {
			answer += sand;
			map[curX][curY] = 0;
		}
		else map[nx][ny] += sand;
	}

}
