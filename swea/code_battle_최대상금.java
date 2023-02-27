package samsung_practice;

import java.io.*;
import java.util.*;

public class code_battle_최대상금 {
	static int n, cnt;
	static int ans;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(br.readLine());
		char[] numbers;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			
			String num = st.nextToken();
			max = 0;
			numbers = num.toCharArray();
			n = num.length();
			cnt = Integer.parseInt(st.nextToken());
			if (n < cnt) cnt = n;
			dfs(cnt, 0, numbers);
			
			System.out.println("#" + test_case + " "+ max);
		}
		
	}
	private static void dfs(int cnt, int start, char[] numbers) {
		if (cnt == 0) {
			max = Math.max(max, Integer.parseInt(new String(numbers)));
			return;
		}
		
		for (int i = start ; i < n - 1; i++) {
			for (int j = i + 1; j < n ; j++) {
				int from = Integer.parseInt(String.valueOf(numbers[i]));
				int to = Integer.parseInt(String.valueOf(numbers[j]));
				
				numbers[i] = (char) (to + '0');
				numbers[j] = (char) (from + '0');
				dfs(cnt - 1, i, numbers);
				numbers[i] = (char) (from + '0');
				numbers[j] = (char) (to + '0');
				
			}
		}
	}

	

}
