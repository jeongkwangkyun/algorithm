package b0228;

import java.io.*;
import java.util.*;

public class Main_bj_g4_17281_공 {
	static int N, max, temp;
	static boolean[] isSelected;
	static int[][] order;
	static int[] number;
	static List<Integer> list =  new ArrayList<Integer>(); 
	static int[] stadium = new int[3]; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		order = new int[N][9];
		isSelected = new boolean[9];
		number = new int[9];
		
		number[3] = 0;
		isSelected[0] = true;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9 ; j++) {
				order[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permutation(0);
		System.out.println(max);
	}
	private static void permutation(int cnt) {
		if(cnt == 9) {
			gameStart();
			return;
		}
		
		if(cnt == 3) {
			number[cnt] = 0;
			permutation(cnt + 1);
			return;
		}
		
		for(int i = 0 ; i < 9 ; i++) {
			if(isSelected[i]) continue;
			
			number[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
	private static void gameStart() {
		int outCount = 0;
		int playerIndex = 0;
		int turn = 0;
		temp = 0;
		while(turn < N) {
			int point = order[turn][number[playerIndex++]];
			
			if(point == 0) outCount ++;
			
			else list.add(point);
			
			if(playerIndex == 9) playerIndex = 0;
			
			if(outCount == 3) {
				sumPoint();
				list.clear();
				outCount = 0;
				turn ++;
			}
			
		}
		max = Math.max(temp, max);
	}
	
	private static void sumPoint() {
		int sum = 0;
		for(int i = list.size() - 1 ; i >= 0 ; i--) {
			sum += list.get(i);
			if(sum >= 4) {
				temp += i + 1;
				break;
			}
		}
	}
}
