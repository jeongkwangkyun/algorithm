import java.io.*;
import java.util.*;

class Shark implements Comparable<Shark>{
	int row, col, cnt, size, eat;

	public Shark(int row, int col, int cnt, int eat, int size) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.eat = eat;
		this.size = size;
	}

	@Override
	public int compareTo(Shark o) {
		// TODO Auto-generated method stub
		if(this.row == o.row) {
			return Integer.compare(this.col, o.col);
		}
		return Integer.compare(this.row, o.row);
	}
	
}

public class bj_g4_아기상어_16236 {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int[][] map;
	static boolean[][] visit;
	static int N, ans;
	static Queue<Shark> q= new LinkedList<>();
	static PriorityQueue<Shark> pq= new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		map=new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N ; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//물고기 처음 위치 
				if(map[i][j]==9) {
					map[i][j]=0;
					visit[i][j]=true;
					q.add(new Shark(i,j,0,0,2));
				}
			}
		}
		
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		while(!q.isEmpty()) {
			
			if(pq.size() > 0) {
				Shark shark = pq.poll();
				//위치 변경 
				map[shark.row][shark.col] = 0;
				// q,pq 비우기,, 새로운 위치에서 시작 
				pq.clear();
				q.clear();
				
				visit = new boolean[N][N];
				// 먹은 물고기가 자신의 사이즈와 같은경우 레벨업 
				if(shark.eat == shark.size) {
					shark.size = shark.size +1;
					shark.eat=0;
				}
				// 물고기를 먹은 시점 = 이동한 횟수 
				ans = shark.cnt;
				// 먹고나서 현재위치에서 다시 재시
				q.add(new Shark(shark.row, shark.col, shark.cnt, shark.eat, shark.size));
			}
			// q 사이즈만큼 한사이클의 q 관리하기 위해 -- ex 토마토 문제 
			int size = q.size();
			
			for(int i=0; i<size ; i++) {
				Shark shark= q.poll();
				
				for(int j=0;j<4;j++) {
					int nx = shark.row + dx[j];
					int ny = shark.col + dy[j];
					// 맵 벗어날 경우 
					if(nx<0 || nx >=N || ny<0 || ny>=N) continue;
					//사이즈 큰 경우 
					if(visit[nx][ny]|| (map[nx][ny]>shark.size)) continue;
					// 작을 경우 
					if(map[nx][ny] >0 && map[nx][ny] <shark.size) {
						// pq에 값 잡을 수 있는 물고기 넣기 
						pq.add(new Shark(nx, ny, shark.cnt+1, shark.eat+1, shark.size));
					}
					
					visit[nx][ny] = true;
					q.add(new Shark(nx, ny, shark.cnt+1, shark.eat, shark.size));
				}
			}
		}
	}

}
