package a0824;

import java.io.*;
import java.util.*;


public class d4_서로소집합_3289 {
	// TODO Auto-generated method stub
	static int[] parents;
	static int N,M;
	
	private static void make() {
		//모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i < N; i++) {
			parents[i]=i;
		}
	}
	
	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if(a==parents[a]) return a; // 자신이 대표자
		return parents[a]=find(parents[a]); //자신이 속한 집합의 대표자를 자신의 부모로
	}
	// 두 원소를 하나의 집합으로 합치기 (대표자를 이용해서 합침)
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false; // 이미 같은 집합으로 합치지 않음
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		for(int tc=1;tc<=t;tc++) {
			st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			parents=new int[N];
			make();
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine()," ");
				int cmd=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken())-1;
				int b=Integer.parseInt(st.nextToken())-1;
				
				if(cmd==0) union(a,b);
				else {
					if(find(a)==find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
