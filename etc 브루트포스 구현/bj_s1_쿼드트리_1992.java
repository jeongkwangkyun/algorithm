package a0818;
import java.awt.Label;
import java.io.*;
import java.util.*;
public class Main_bj_s1_쿼드트리_1992_서울_12반_정광균 {

	static int[][] map;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		//map 크기 선언
		map=new int[n][n];
		// 값 넣어주기
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j]=tmp.charAt(j)-'0';
			}
		}
		// size,x_start,x_end,y_start,y_end
		find(n,0,n,0,n);
		System.out.println(sb);
	}
	// size를 줄여가면서 조건 맞춰주기.
	static void find(int size,int x_start,int x_end,int y_start,int y_end) {

		boolean flag=true;
		int tmp=map[x_start][y_start];
		label :for(int i=x_start;i<x_end;i++) {
			for(int j=y_start;j<y_end;j++) {
				if(map[i][j]!=tmp) {
					flag=false;
					break label;
				}
			}
		}
		if(flag==true) {
			sb.append(map[x_start][y_start]);
			return;
		}
		else {
			//1사분면
			sb.append('(');
			find(size/2,x_start,x_start+size/2,y_start,y_start+size/2);
			//2사분면
			find(size/2,x_start,x_start+size/2,y_start+size/2,y_end);
			//3사분면
			find(size/2,x_start+size/2,x_end,y_start,y_start+size/2);
			//4사분면
			find(size/2,x_start+size/2,x_end,y_start+size/2,y_end);
			sb.append(')');
		}
	}

}
