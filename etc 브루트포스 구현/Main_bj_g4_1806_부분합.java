package b0408;

import java.io.*;
import java.util.*;

public class Main_bj_g4_1806_부분합 {
	static int N, S;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0, right = 0;
		int sum = arr[0];
		
		while(left <= arr.length - 1) {
			if(right == N -1 && sum < S) {
				break;
			}
			if(sum < S) {
				right ++;
				sum += arr[right];	
			}
			else {
				int len = right - left + 1;
				min = Math.min(len, min);
				sum -= arr[left++];
			}
		}
		if(min == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);
	}
}
