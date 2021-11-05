package a1018;

import java.io.*;
import java.util.*;

// 조합  
public class Main_15650_N과M_2 {
	static int n,m;
	static int[] number;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		n= Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		number = new int[m];
		
		combination(0,0);
		
	}
	
	private static void combination(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt==m) {
			for(int i=0; i<m; i++) {
				System.out.print(number[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start ;i<n ; i++) {
			number[cnt]=i+1;
			combination(cnt+1,i+1);
		}
	}
}
