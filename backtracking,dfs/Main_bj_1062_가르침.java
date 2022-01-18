package b0118;

import java.io.*;
import java.util.*;

public class Main_bj_1062_가르침 {
	static int N, K, max;
	static boolean[] isSelected = new boolean[26];
	static String[] strArr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(K < 5) {
			System.out.println(0);
			return;
		}else if(K == 26) {
			System.out.println(N);
			return;
		}
		else {		
			strArr = new String[N];
			for(int i = 0 ; i < N ; i++) {
				String tmp = br.readLine();
				strArr[i] = tmp.substring(4, tmp.length()-4);
			}
			isSelected['a'-97] = true;
			isSelected['n'-97] = true;
			isSelected['t'-97] = true;
			isSelected['i'-97] = true;
			isSelected['c'-97] = true;
			K -= 5;
			combination(0,0);
			System.out.println(max);
		}
	}
	private static void combination(int start, int cnt) {
		if(max == N) {
			return;
		}
		if(cnt == K) {
			int flagCnt = 0;
			for(int i = 0 ; i < N ; i++) {
				boolean flag = true;
				for(int j = 0 ; j < strArr[i].length() ; j++) {
					if(!isSelected[strArr[i].charAt(j) - 97]) {
						flag = false;
						break;
					}
				}
				if(flag == true) {
					flagCnt ++;
				}
			}
			max = Math.max(max, flagCnt);
			return;
		}
		
		for(int i = start ; i < 26 ; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				combination(i+1, cnt+1);
				isSelected[i] = false;
			}
		}
	}
}
