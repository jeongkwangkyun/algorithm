package Java_0802;

import java.io.*;
import java.util.*;

public class Main_bj_g4_알파벳_1987{

	static char[][] map;
	static StringBuilder sb=new StringBuilder();
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int n,m;
	static int cnt=1;
	static int total=1;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		//map 크기 선언
		map=new char[n][m];
		boolean[][] check= new boolean[n][m];
		// character 값 넣어주기
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=tmp.charAt(j);
			}
		}
		// 현재 가지고 있는 문자들을 가지고있는 배열 
		ArrayList<Character> isSelected=new ArrayList<Character>();
		//dfs로,,, 
		dfs(0,0,check,isSelected);
		
		System.out.println(total);
	}

	//그리디하게 
	private static void dfs(int x, int y, boolean[][] check,ArrayList<Character> isSelected) {
		// TODO Auto-generated method stub
		//현재 문자를 삽입해주고,check로 방문한곳 true 
		isSelected.add(map[x][y]);
		check[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(0<=nx && nx<n &&0<=ny && ny<m && check[nx][ny]==false) {
				//한번도 방문안하고 문자를 갖고 있지 않다면 조건 통과 
				if(isSelected.contains(map[nx][ny])==false) {
					// 최종값과 cnt+1(nx,ny가 조건에 맞아서 통과됐으므로) 비
					total=Math.max(total, ++cnt);

					dfs(nx,ny,check,isSelected);
				}
			}
		}
		// 순열 false 다시 해주는 것처럼 다시 false랑 리스트에 문자 지우기
		--cnt;
		
		isSelected.remove(Character.valueOf(map[x][y]));
		check[x][y]=false;
		return;
		
	}

}
