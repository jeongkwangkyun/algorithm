package a0823;
import java.util.Scanner;


import java.io.*;
import java.util.*;

public class bj_g5_암호만들기 {
	static int n,m;
	static String[] numbers;
	static String[] arr;
	static boolean isSelected[];
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		numbers=new String[m];

		arr=br.readLine().split(" ");
		Arrays.sort(arr);
		
		combination(0,0,0,0);
		System.out.print(sb);
	}

	private static void combination(int cnt, int start,int mo_cnt,int ja_cnt) {
		// TODO Auto-generated method stub
		
		if(cnt==m) {
			if(1<=mo_cnt && ja_cnt>=2) {
				String[] tmp=Arrays.copyOf(numbers, m);
				Arrays.sort(tmp);
				for(int i=0;i<m;i++) {
					sb.append(tmp[i]);
				}
				sb.append("\n");
				
			}
			
			return;
		}
		
		for(int i=start;i<n;i++) {
			numbers[cnt]=arr[i];
			//파라미터 넘기는거.. mo_cnt 해버려서 계속 값이 늘어나버려따..
			if(arr[i].equals("a")||
					arr[i].equals("o")||
					arr[i].equals("i")||
					arr[i].equals("u")||
				
					arr[i].equals("e")) combination(cnt+1, i+1,mo_cnt+1,ja_cnt);
			else combination(cnt+1, i+1,mo_cnt,ja_cnt+1);
		}
		
	}
}

