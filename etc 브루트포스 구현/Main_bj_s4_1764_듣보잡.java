package b0424;

import java.io.*;
import java.util.*;

public class Main_bj_s4_1764_듣보잡 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> hashSet = new HashSet<>();
		ArrayList<String> answer = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i++) {
			String input = br.readLine();
			hashSet.add(input);
		}
		
		for(int i = 0 ; i < M ; i++) {
			String input = br.readLine();
			if(hashSet.contains(input)) answer.add(input);
		}
		
		Collections.sort(answer);
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size() + "\n");
		for(int i = 0 ; i < answer.size() ; i++) {
			sb.append(answer.get(i) + "\n");
		}
		System.out.println(sb);
	}

}
