package b0305;

import java.io.*;
import java.util.*;

public class Main_bj_s3_18429_근손실 {
	static int N, K, answer;
	static int[] plan, num;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		plan = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		num = new int[N];
		isSelected = new boolean[N];
		permutation(0, 500);
		System.out.println(answer);
		
	}
	private static void permutation(int cnt, int power) {
		if(cnt == N) {
			answer += 1;
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(isSelected[i]) continue;
			
			
			num[cnt] = i;
			int cur = plan[num[cnt]]- K + power;
			if(plan[num[cnt]]- K + power < 500) continue;
			
			isSelected[i] = true;
			permutation(cnt + 1, plan[num[cnt]]- K + power);
			isSelected[i] = false;

		}
	}

}
