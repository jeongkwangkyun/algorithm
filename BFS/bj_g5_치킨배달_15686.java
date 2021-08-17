package a0813;
import java.io.*;
import java.util.*;

public class Main_bj_g5_치킨배달_15686_서울_12반_정광균 {
	static int[][] graph;
	static int n,m,m_cnt=0;
	static ArrayList<Integer> store =new ArrayList<Integer>();
	static int total_min=Integer.MAX_VALUE;
	static int tmp_min;
	static int[][] check;
	static int[] numbers;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static Queue<Integer> queue= new LinkedList<Integer>();

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_g5_15686.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		graph=new int[n][n]; //전체 맵

		// graph와 store에 값 넣어주기
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
				if(graph[i][j]==2) {
					store.add(i);
					store.add(j);
					m_cnt+=1;
				}
			}
		}
		numbers=new int[m*2];
		combination(0,0);
		System.out.println(total_min);
	}
	private static void combination(int cnt,int start) {
		// TODO Auto-generated method stub
		if(cnt==m) {
			// bfs 문
			find();
			total_min=Math.min(total_min, tmp_min);
			return;
		}
		for(int i=start;i<m_cnt;i++) {
			numbers[cnt*2]=store.get(i*2);
			numbers[cnt*2+1]=store.get(i*2+1);
			combination(cnt+1,i+1);
		}
	}
	private static void find() {
		// TODO Auto-generated method stub
		tmp_min=0;
		check= new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				check[i][j]=-1;
			}
		}
		for(int i=0;i<m;i++) {
			int x=numbers[i*2];
			int y=numbers[i*2+1];
			check[x][y]=0;
			queue.offer(x);
			queue.offer(y);
			while(!queue.isEmpty()) {
				x=queue.poll();
				y=queue.poll();
				for(int j=0;j<4;j++) {
					int nx=x+dx[j];
					int ny=y+dy[j];
					if(0<=nx && nx<n && 0<=ny && ny<n ) {
						if(check[nx][ny]==-1) {
							check[nx][ny]=check[x][y]+1;
							queue.offer(nx);
							queue.offer(ny);
						}
						else if(check[nx][ny]!=-1) {
							if(check[nx][ny]>check[x][y]+1) {
								check[nx][ny]=check[x][y]+1;
								queue.offer(nx);
								queue.offer(ny);
							}
						}
					}
				}
			}
		}
		
		for(int j=0;j<n;j++) {
			for(int k=0;k<n;k++) {
				if(graph[j][k]==1) {
					tmp_min+=check[j][k];
				}
			}
		}
	}
}
