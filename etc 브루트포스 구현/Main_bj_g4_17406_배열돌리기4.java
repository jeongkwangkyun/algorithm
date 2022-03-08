package b0308;

import java.io.*;
import java.util.*;

public class Main_bj_g4_17406_배열돌리기4 {
	static int N, M, K, min = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] arr;
	static boolean[] isSelected;
	static int[] numbers;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		arr = new int[K][3];
		isSelected = new boolean[K];
		numbers = new int[K];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0);
		System.out.println(min);
	}
	
	private static void permutation(int cnt) {
		if(cnt == K) {
			int[][] copyMap = new int[N][M];
			for(int i = 0 ; i < N ; i++) {
				copyMap[i] = map[i].clone();
			}
			
			for(int i = 0 ; i < K ; i++) {	
				int lx = arr[numbers[i]][0] - arr[numbers[i]][2] - 1;
				int ly = arr[numbers[i]][1] - arr[numbers[i]][2] - 1;
				int rx = arr[numbers[i]][0] + arr[numbers[i]][2] - 1;
				int ry = arr[numbers[i]][1] + arr[numbers[i]][2] - 1;
				rotate(lx, ly, rx, ry, copyMap);
			}
			
			for(int i = 0 ; i < N ; i++) {
				int answer = 0;
				
				for(int j = 0 ; j < M ; j++) {
					answer += copyMap[i][j];
				}
				
				min = Math.min(min, answer);
			}
			return;
		}
		
		for(int i = 0 ; i < K ; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			numbers[cnt] = i;
			
			permutation(cnt + 1);
			isSelected[i] = false;
			
		}
	}

	private static void rotate(int lx, int ly, int rx, int ry, int[][] copy) {
		//기저조건 
		if(lx == rx && ly == ry) {
			return;
		}
		// 오른 위, 오른 아래, 왼 아래 
		int[] temp = new int[3];
		temp[0] = copy[lx][ry];
		temp[1] = copy[rx][ry];
		temp[2] = copy[rx][ly];
		
		// 오른쪽 회전 
		for(int i = ry ; i  > ly ; i--) {
			copy[lx][i] = copy[lx][i-1];
		}
		
		// 아래 회전 
		for(int i = rx ; i > lx ; i--) {
			if(i == lx + 1) copy[i][ry] = temp[0];
			else copy[i][ry] = copy[i-1][ry];
		}
		
		// 왼 회전 
		for(int i = ly ; i < ry ; i++) {
			if(i == ry - 1) copy[rx][i] = temp[1];
			else copy[rx][i] = copy[rx][i + 1];
		}
		// 위 회전 
		for(int i = lx ; i < rx ; i++) {
			if(i == rx - 1) copy[i][ly] = temp[2];
			else copy[i][ly] = copy[i + 1][ly];
		}
		rotate(lx + 1, ly + 1, rx - 1, ry - 1, copy);
	}

}
