package b0317;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_s4_1920_수찾기 {
	static int N,M;
	static int[] nList, mList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nList = new int[100001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			nList[tmp] = 1; 
		}
		
		M = Integer.parseInt(br.readLine());
		mList = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			mList[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0 ; i < M ; i++) {
			if(nList[mList[i]] == 1) System.out.println(1);
			else System.out.println(0);
		}
	}
}
