package b0222;

import java.io.*;
import java.util.*;

public class Main_bj_g3_9466_텀프로젝트 {
	static boolean[] isSelected, isFinished;
	static int[] numbers;
	static int T, N, answer, minus;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase = 0 ; testCase < T ; testCase++) {
			N = Integer.parseInt(br.readLine());
			answer = N;
			numbers = new int[N + 1];
			isSelected = new boolean[N + 1];
			isFinished = new boolean[N + 1];
			minus = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= N ; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1 ; i <= N ; i++) {
				dfs(i);
			}
			answer -= minus;
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int now) {
		if(isSelected[now]) return;
		
		isSelected[now] = true;
		int next = numbers[now];
		
		if(isSelected[next] == false) {
			dfs(next);
		}
		else {
			if(isFinished[next] == false) {
				minus ++;
				for(int i = next ; i != now ; i = numbers[i]) {
					minus ++;
				}
			}
		}
		
		isFinished[now] = true;
	}
}
