
import java.io.*;
import java.util.*;

public class Main {
	static int min_val=0, n , m;
	static int[][] map;
	static Queue<int[]> queue= new LinkedList<int[]>();
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());

		map=new int[n][m];

		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0 ; j<m ; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) queue.add(new int[] {i,j});
			}
		}
		bfs();
		boolean flag=false;
		loop : for(int i=0; i<n; i++) {
			for(int j=0; j<m;j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					flag=true;
					break loop;
				}
				else if(map[i][j]!=-1) {
					min_val=Math.max(min_val, map[i][j]);
				}
			}
		}
		if(flag==false) System.out.println(min_val-1);

	}
	private static void bfs() {
		// TODO Auto-generated method stub
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			int x=cur[0];
			int y=cur[1];

			for(int k=0; k<4 ; k++) {
				int nx= x+dx[k];
				int ny= y+dy[k];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(map[nx][ny]!=-1) {
						if(map[nx][ny]==0) {
							map[nx][ny]=map[x][y]+1;
							queue.offer(new int[] {nx,ny});
						}
						else {
							if(map[nx][ny]>map[x][y]+1) {
								map[nx][ny]=map[x][y]+1;
								queue.offer(new int[] {nx,ny});
							}

						}
					}
				}
			}
		}
	}

}

