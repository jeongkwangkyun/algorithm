package b0124;

import java.io.*;
import java.util.*;

public class Main_bj_g4_17779_게리맨더링2{
	static int N, totalPeople, min;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				totalPeople += map[i][j];
			}
		}
		for(int x = 0 ; x < N ; x++) {
			for(int y = 0 ; y < N ; y++) {
				for(int d1 = 1 ; d1 < N ; d1++) {
					for(int d2 = 1; d2 < N ; d2++) {
						if(x + d1 + d2 >= N) continue;
						if(y - d1 < 0 || y + d2 >= N) continue;
						
						garrymandering(x, y, d1, d2);
					}
				}
			}
		}
		System.out.println(min);
	}
	
	private static void garrymandering(int x, int y, int d1, int d2) {
		boolean[][] boarder = new boolean[N][N];
		int [] peopleSum = new int[5]; 
		
		for(int i = 0 ; i <= d1 ; i++) {
			boarder[x + i][y - i] = true;
			boarder[x + d2 + i][y + d2 - i] = true;
		}
		
		for(int i = 0 ; i <= d2 ; i++) {
			boarder[x + i][y + i] = true;
			boarder[x + d1 + i][y - d1 + i] = true;
		}
		
		//1
		for(int i = 0 ; i < x + d1 ; i++) {
			for(int j = 0 ; j <= y ; j++) {
				if(boarder[i][j] == true) break;
				peopleSum[0] += map[i][j];
			}
		}
		//2
		for(int i = 0 ; i <= x + d2 ; i++) {
			for(int j = N-1 ; j > y ; j--) {
				if(boarder[i][j] == true) break;
				peopleSum[1] += map[i][j];
			}
		}
		//3
		for(int i = x + d1 ; i < N ; i++) {
			for(int j = 0 ; j < y - d1 + d2 ; j++) {
				if(boarder[i][j] == true) break;
				peopleSum[2] += map[i][j];
			}
		}
		//4
		for(int i = x + d2 +1 ; i < N ; i++) {
			for(int j = N-1 ; j >= y - d1 + d2 ; j--) {
				if(boarder[i][j] == true) break;
				peopleSum[3] += map[i][j];
			}
		}
		
		peopleSum[4] = totalPeople;
		for(int i = 0 ; i < 4 ; i++) {
			peopleSum[4] -= peopleSum[i];
		}
		
		Arrays.sort(peopleSum);
		
		min = Math.min(peopleSum[4]-peopleSum[0], min);
	}
	
	
}