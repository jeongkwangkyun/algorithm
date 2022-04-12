package b0412;

import java.util.*;
import java.io.*;

public class Main_bj_s1_2138_전구와스위치 {
	static int N;
	static String in, out;
	static int[] input, output;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
 
		output = new int[N];
		
		in = br.readLine();
		out = br.readLine();
		for(int i = 0 ; i < N ; i++) {
			input[i] = in.charAt(i) - '0';
			output[i] = out.charAt(i) - '0';
		}
		int[] list1 = Arrays.copyOf(input, N);
		
		// 스위치사용 
		int[] list2 = Arrays.copyOf(input, N);
		
		list2 = switchOn(list2, 0, 1);
		
		greedy(1, 0, list1);
		greedy(1, 1, list2);
		
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
	private static void greedy(int idx, int cnt, int[] list) {
		if(idx == N ) {
			// 마지막 값이 같지 않다면 결국 output을 만들지 못한다 
			if(list[idx - 1] == output[idx - 1]) answer = Math.min(answer, cnt);
			return;
		}
		
		else {
			// 같은경우 
			if(list[idx - 1] != output[idx - 1]) {
				list = switchOn(list, idx - 1, idx + 1);
				greedy(idx + 1, cnt + 1, list);
			}
			// 다른경우 
			else greedy(idx + 1, cnt, list);
		}
	}
	
	private static int[] switchOn(int[] list, int start, int end) {
		for(int i = start ; i <= end ; i++) {
			if(0 > i || i >= N) continue;
			
			if(list[i] == 0) list[i] = 1;
			else list[i] = 0;
		}
		
		return list;
	}
}