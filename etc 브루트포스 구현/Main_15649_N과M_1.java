package a1018;

import java.io.*;
import java.util.*;

// 순열 
public class Main_15649_N과M_1 {
	static int n,m;
	static int[] number;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		n= Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		number = new int[m];
		isSelected = new boolean[n];
		permutaion(0);
		
	}
	
	private static void permutaion(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==m) {
			for(int i=0; i<m; i++) {
				System.out.print(number[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0 ;i<n ; i++) {
			if(isSelected[i]) continue;

			
			number[cnt]=i+1;
			isSelected[i]=true;
			
			permutaion(cnt+1);
			isSelected[i]=false;
		}
	}
}
