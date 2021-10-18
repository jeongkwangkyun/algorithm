package a1018;

import java.io.*;
import java.util.*;

// 중복 순열   
public class Main_15651_N과M_3 {
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
		Dpermutation(0);
		System.out.println(sb);
	}
	
	private static void Dpermutation(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==m) {
			for(int i=0; i<m; i++) {
				sb.append(number[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0 ;i<n ; i++) {
			number[cnt]=i+1;
			Dpermutation(cnt+1);
		}
	}
}
