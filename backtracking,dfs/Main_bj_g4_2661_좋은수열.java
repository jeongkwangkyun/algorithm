package b0314;

import java.io.*;
import java.util.*;

public class Main_bj_g4_2661_좋은수열 {
	static int N;
	static int[] numbers;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		dfs(0, "");
	}
	private static void dfs(int cnt, String answer) {
		if(cnt == N) {
			
			System.out.print(answer);
			System.exit(0);
		}	
		
		for(int i = 1 ; i <= 3 ; i++) {
			numbers[cnt] = i;
			if(isAvailiable(answer + i)) dfs(cnt + 1, answer + i);
		}
	}
	private static boolean isAvailiable(String s) {
		int size = s.length() / 2;
		
		for(int i = 1 ; i <= size ; i++) {
			if(s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) return false;
		}
		return true;
	}
}


