package a0820;

import java.io.*;
import java.util.*;

public class d4_준환이의양팔저울_3234 {
	static int result;

	//순열
	static void dfs(int cnt,int left, int right, int[] weight, boolean [] visit) {
		if(left<right) return;
		if(cnt==weight.length) {
			result++;
			return;
		}
		for(int i=0; i<weight.length ; i++) {
			if(visit[i]) continue;
			visit[i]=true;
			// 부분집합
			dfs(cnt+1,left+weight[i],right,weight,visit);
			dfs(cnt+1,left,right+weight[i],weight,visit);
			visit[i]=false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		System.setIn(new FileInputStream("res/input_d4_3234.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();

		for(int t=1;t<=tc;t++) {
			int n=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int[] weight=new int[n];
			for(int i=0; i<n ; i++) {
				weight[i]=Integer.parseInt(st.nextToken());

			}
			result=0;
			dfs(0,0,0,weight,new boolean[n]);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	
	}
}
