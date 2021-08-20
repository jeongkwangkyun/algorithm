package Java_0802;
import java.io.*;
import java.util.*;
public class Main {

	static boolean[][] map;
	static StringBuilder sb=new StringBuilder();
	// x값
	static int[] dx= {-1,0,1};
	static int n,m,total;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		//map 크기 선언
		map=new boolean[n][m];
		
		// 값 넣어주기
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			for(int j=0;j<m;j++) {
				if(tmp.charAt(j)=='x')
					map[i][j]=true;
			}
		}
		//행별로 dfs 실행
		for(int i=0;i<n;i++) {
			dfs(i,0);
		}
		
		System.out.println(total);
	}

	//그리디하게 
	private static boolean dfs(int x, int y) {
		// TODO Auto-generated method stub
		for(int k=0; k<3;k++) {
			//y값은 무조건 1증가 x는 dx따라서 
			int nx=x+dx[k];
			int ny=y+1;
			
			if(0<=nx && nx<n && map[nx][ny]==false) {
				//마지막행 도달시
				if(ny==m-1) {
					total++;
					return true;
				}
				//y+1 다음행이 true값 바꿔주고 
				map[nx][ny]=true;
				// dfs다음값 넣어주기
				if(dfs(nx,ny)) {
					return true;
				}
			}
		}
		//for문을 다돌고 만약 마지막열에 도달하지 않는다면 모두 false값으로 돌려주기
		return false;
	}

}
