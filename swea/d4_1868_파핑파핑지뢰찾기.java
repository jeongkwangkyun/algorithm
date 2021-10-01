package a1001;
import java.io.*;
import java.util.*;
public class Solution {
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1, 1,1,-1,-1};
	static int[] dy = {1,0,-1,0, 1,-1,1,-1};
	static int n;
	static Queue<int[]> queue= new LinkedList<int[]>();
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=Integer.parseInt(br.readLine());
		for(int t=1 ; t<=tc ; t++) {
			n=Integer.parseInt(br.readLine());
			map= new char[n][n];
			visited = new boolean[n][n];
			for(int i=0 ; i < n ;i++) {
				String tmp=br.readLine();
				for(int j=0 ; j< n ; j++) {
					map[i][j]=tmp.charAt(j);
					if(map[i][j]=='*') visited[i][j]=true;

				}
			}
			// map에 0,1,2,3 주변에 지뢰 남기기
			for(int i=0 ; i<n ;i++) {
				for(int j=0; j<n ;j++) {
					int cnt=0;
					for(int k=0; k<8 ; k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
						if(map[nx][ny]=='*') cnt+=1; 
					}		
					
					if(map[i][j]=='.')map[i][j]=(char)(cnt+'0');
				}
			}
			int total=0;
			for(int i=0 ; i<n ; i++) {
				for(int j=0 ;j<n; j++) {
					if(map[i][j]=='0' && visited[i][j]==false) {
						bfs(i,j);
						total+=1;
					}
				}
			}

			for(int i=0 ; i<n ; i++) {
				for(int j=0 ;j<n; j++) {
					if(visited[i][j]==false) {
						total+=1;
					}
				}
			}
			System.out.println("#"+t+" "+total);
		}

	}
	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		queue.add(new int[] {i,j});
		visited[i][j]=true;

		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			int x=cur[0];
			int y=cur[1];
			for(int k=0; k<8 ; k++) {
				int nx=x+dx[k];
				int ny=y+dy[k];
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

				if(visited[nx][ny]==false &&map[nx][ny]=='0') {
					visited[nx][ny]=true;
					queue.add(new int[] {nx,ny});
				}
				else if(visited[nx][ny]==false && map[nx][ny]!='0') {
					visited[nx][ny]=true;
				}
			}
		}

	}

}
