package a0824;

import java.io.*;
import java.util.*;
class xy{
	int x;
	int y;
	public xy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
//bfs문 하나만 쓰려고했는데 더 오래걸림,,
// 메모리 초과 안나니까 나눠서 짜는게 더 효율적
public class Main_bj_g5_적록색약_10026_서울_12반_정광균 {
	static int n,cnt1,cnt2;
	static char[][] graph;
	static boolean[][] check,check2;
	static Queue<xy> queue=new LinkedList<xy>();
	static StringBuilder sb=new StringBuilder();
	// 상 우 하 좌
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws Exception {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		n=Integer.parseInt(st.nextToken());
		graph=new char[n][n];

		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			for(int j=0;j<n;j++) {
				graph[i][j]=tmp.charAt(j);
			}
		}
		check=new boolean[n][n];
		check2=new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				char color=graph[i][j];
				if(check[i][j]==false) {
					bfs(i,j,color,true);
					cnt1+=1;
				}
				if(check2[i][j]==false) {
					bfs(i,j,color,false);
					cnt2+=1;
				}
			}
		}
		System.out.println(cnt1+" "+cnt2);
	}
	private static void bfs(int x, int y, char color,boolean version) {
		// TODO Auto-generated method stub
		if(version==true) {
			check[x][y]=true;

		}
		else {
			check2[x][y]=true;
		}
		queue.offer(new xy(x,y));

		while(!queue.isEmpty()) {
			int q_x=queue.peek().x;
			int q_y=queue.peek().y;
			queue.poll();
			for(int i=0;i<4;i++) {
				int nx=q_x+dx[i];
				int ny=q_y+dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<n ) {
					if(version==true && graph[nx][ny]==color&& check[nx][ny]==false) {
						queue.offer(new xy(nx,ny));
						check[nx][ny]=true;	
					}else if(version==false && graph[nx][ny]==color&& check2[nx][ny]==false) {
						queue.offer(new xy(nx,ny));
						check2[nx][ny]=true;	
					}
					else if(version==false&&color=='R' &&graph[nx][ny]=='G'&& check2[nx][ny]==false){
						queue.offer(new xy(nx,ny));
						check2[nx][ny]=true;						
					}else if(version==false&&color=='G' &&graph[nx][ny]=='R'&& check2[nx][ny]==false){
						queue.offer(new xy(nx,ny));
						check2[nx][ny]=true;						
					}
				}
			}
		}

	}
	//	private static void bfs2(int x, int y, char color) {
	//		// TODO Auto-generated method stub
	//		check2[x][y]=true;
	//		queue.offer(new xy(x,y));
	//		
	//		while(!queue.isEmpty()) {
	//			int q_x=queue.peek().x;
	//			int q_y=queue.peek().y;
	//			queue.poll();
	//			for(int i=0;i<4;i++) {
	//				int nx=q_x+dx[i];
	//				int ny=q_y+dy[i];
	//				if(0<=nx && nx<n && 0<=ny && ny<n && check2[nx][ny]==false) {
	//					if(graph[nx][ny]==color) {
	//						queue.offer(new xy(nx,ny));
	//						check2[nx][ny]=true;						
	//					}
	//					else if(color=='R' &&graph[nx][ny]=='G'){
	//						queue.offer(new xy(nx,ny));
	//						check2[nx][ny]=true;						
	//					}else if(color=='G' &&graph[nx][ny]=='R'){
	//						queue.offer(new xy(nx,ny));
	//						check2[nx][ny]=true;						
	//					}
	//				}
	//			}
	//		}
	//	}
}

