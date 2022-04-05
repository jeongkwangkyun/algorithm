package b0405;

import java.io.*;
import java.util.*;

public class Main_bj_s4_10815_숫자카드 {
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		HashSet<Integer> hashSet = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			hashSet.add(Integer.parseInt(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			if(hashSet.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1).append(" ");
			}
			else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
		
	}

}
