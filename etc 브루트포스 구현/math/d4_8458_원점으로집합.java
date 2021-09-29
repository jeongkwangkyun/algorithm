package a0928;

import java.io.*;
import java.util.*;

public class d4_8458_원점으로집합 {
	
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		next:for(int tc=1;tc<=t;tc++) {
			
			int N=Integer.parseInt(br.readLine());
			int[] arr=new int[N];
			int max=0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				
				arr[i]=Math.abs(x)+Math.abs(y);
				max=Math.max(max, arr[i]);
				
			}
			for(int i=1;i<N; i++) {
				if((arr[0]%2) != (arr[i]%2)) { //홀수, 짝수 있으면 해답 없음
					System.out.println("#"+tc+" -1");
					continue next;
				}
			}
			
			int sum=0;
			for(int i=0 ; ; i++) {
				sum+=i;
				if(sum>=max && (sum%2)==(max%2)) {
					System.out.println("#"+tc+" "+i);
					continue next;
				}
			}
			
			
		}
		System.out.println(sb);
		br.close();
	}

}
