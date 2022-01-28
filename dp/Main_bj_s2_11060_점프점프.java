package b0128;

import java.io.*;
import java.util.*;

public class Main_bj_s2_11060_점프점프 {
	static int N;
	static int[] numArr, dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		numArr = new int[N];
		dp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		go(0, 0);
		if(N == 1) {
			System.out.println(0);
		}else if(dp[N-1] == Integer.MAX_VALUE){
			System.out.println(-1);
		}else {			
			System.out.println(dp[N-1]+1);
		}
	}

	private static void go(int cnt, int index) {
		if(index == N-1) {
			return;
		}
		int number = numArr[index];
		for(int i = 1 ; i <= number ; i++) {
			int curIndex = index + i;
			if(N-1 < curIndex) break;
			if(dp[curIndex] < cnt) break;
			
			dp[curIndex] = cnt;
			go(cnt + 1, curIndex);
		}
		
	}
}
