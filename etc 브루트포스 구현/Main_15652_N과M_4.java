package a1018;

import java.io.*;
import java.util.*;

// 중복 조합 
public class Main_15652_N과M_4 {
	static int n,m;
	static int[] number;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		n= Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		number = new int[m];
		sb = new StringBuilder();
		Dcombination(0,0);
		System.out.println(sb);
	}
	
	private static void Dcombination(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt==m) {
			for(int i=0; i<m; i++) {
				sb.append(number[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start ;i<n ; i++) {
			number[cnt]=i+1;
			Dcombination(cnt+1,i);
		}
	}
}
