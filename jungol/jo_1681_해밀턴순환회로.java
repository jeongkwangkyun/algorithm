package a0923;

import java.io.*;
import java.util.*;


public class jo_1681_해밀턴순환회로 {
	static int[][] map;
	static int n , min_val=100000;
	static int[] numbers;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		if(n!=1) {
			StringTokenizer st;
			map=new int[n][n];
			numbers=new int[n-1];
			isSelected = new boolean[n-1];

			for(int i=0 ; i <n ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0 ; j<n; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}

			permutation(0, 0);
			if(min_val==Integer.MAX_VALUE) System.out.println(0);
			else {			
				System.out.println(min_val);
			}			
		}
		
		else {
			System.out.println(2*Integer.parseInt(br.readLine()));
		}

	}

	private static void permutation(int cnt, int val) {
		// TODO Auto-generated method stub
		if(val>=min_val) return;

		if(cnt==n-1) {
			int tmp;
			tmp=val+map[numbers[n-2]][0];
			min_val=Math.min(tmp, min_val);
			
			return;
		}

		for(int i=0; i<n-1; i++) {
			if(isSelected[i]) continue;

			int plus;
			numbers[cnt]=i+1;
			isSelected[i]=true;

			if(cnt==0) plus=map[0][numbers[0]];

			else plus=map[numbers[cnt-1]][numbers[cnt]];
			
			if(plus==0) plus=100001;
			permutation(cnt+1, val+plus);
			isSelected[i]=false;
		}

	}

}
