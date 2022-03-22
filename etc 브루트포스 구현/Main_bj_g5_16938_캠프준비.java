package b0322;

import java.io.*;
import java.util.*;

public class Main_bj_g5_16938_캠프준비 {
	static int N ,L, R, X, answer;
	static int[] problems;
	static int[] numbers;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		problems = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			problems[i] = Integer.parseInt(st.nextToken());
		}
		
		// cnt, size, start, min, max
		for(int size = 2 ; size <= N ; size++) {			
			numbers = new int[size];
			subset(0, size, 0, 0);
		}
		System.out.println(answer);
	}
	private static void subset(int cnt, int size, int start, int plus) {
		if(cnt == size) {
			if(!(L <= plus && plus <= R)) return;
			
			int min = 9999999;
			int max = 0;
			
			for(int i = 0 ; i < size ; i++) {
				min = Math.min(min, numbers[i]);
				max = Math.max(max, numbers[i]);
			}
			if(!(max - min >= X)) return;
			answer ++;
			return;
		}
		
		for(int i = start ; i < N ; i++) {
			numbers[cnt] = problems[i];
			subset(cnt + 1 , size, i + 1, plus + problems[i]);
		}
		
	}

}
