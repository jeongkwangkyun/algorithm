package b0103;

import java.io.*;
import java.util.*;

public class Main_bj_s4_1026_보물 {
	static int N, answer;
	static int[] A,B;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i<N ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i<N ; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for(int i = 0 ; i < N ; i++) {
			answer += B[N-i-1] * A[i];
		}
		
		System.out.println(answer);
	}
}
