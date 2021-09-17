package a0917;

import java.io.*;
import java.util.*;


// 1. 섬을 bfs돌려서 1,2,3,4, 번호로 지정해주고 헷갈려서 2부터 시작 2,3,4,5
// 2. 다리 놔주기 -> 반례 생각해서 한 방향으로 거리를 계산하고 다른 섬에 닿는 다면 edgeList에 넣어주기
// 3. prim 알고리즘 
public class bj_g2_다리만들기 {
	static int n,m,V;
	static int island_cnt=2;
	static int[][] graph;
	static int[][] check;
	static Queue<int[]> queue=new LinkedList<int[]>();
	static List<Edge>[] edgeList;
	static boolean[] visited;
	
	//상 우 하 좌
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	
	
	// edge 값
	static class Edge implements Comparable<Edge>{
		int v, w;

		Edge(int e, int v) {
			this.v = e;
			this.w = v;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph=new int[n][m];
		
		
		// graph에 값
		for(int i=0; i < n; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		// bfs 돌려서 섬 번호 붙여주기
		for(int i=0;i<n;i++) {
			for(int j=0;j<m ; j++) {
				if(graph[i][j]==1) {
					bfs(i,j);
					island_cnt++;
				}
			}
		}
		// 섬 갯수를 V 간선 갯수로 초기화
		V=island_cnt-2;
		edgeList = new ArrayList[V];
		visited=new boolean[V];
		
		// edgelist 사용
		for(int i=0;i<V;i++) {
			edgeList[i] = new ArrayList<Edge>();
		}
		
		// make bridge
		for(int i=0;i<n;i++) {
			for(int j=0; j<m; j++) {
				if(graph[i][j]!=0) {
					make_bridge(i,j);
				}
			}
		}
		
		//prim 알고리즘
		prim();
		
		
	}

	private static void prim() {
		// TODO Auto-generated method stub
		// 다리가 없는 섬이라면  -1 출력
		for(int i=0 ; i<V ;i++) {
			if (edgeList[i].isEmpty()) {
				System.out.println(-1);
				return;
			}
		}
		// pq써서 시간 단축
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		
		int result=0;
		int cnt=0;
		
		for(Edge e: edgeList[0]) {
			pq.add(e);
		}
		// 임의의 점
		visited[0]=true;
		while(!pq.isEmpty()) {
			Edge cur=pq.poll();
			
			if(visited[cur.v]) continue;
			// 가중치 더해주기
			result+=cur.w;  
			
			// 방문처리
			visited[cur.v]=true;
			
			//v-1 일때 완성
			if(cnt++ == V-1) break; 
			
			for(Edge e:edgeList[cur.v]) {
				// 방문한 정점 continue
				if(visited[e.v]) continue;
				// 방문 안했다면 pq넣어주기
				pq.add(e);
			}
		}
		for(int i=0;i<V;i++) {
			// 반례 : 모든 구역을 연결 못하는 상황 ,, 임의의 점을 찍기 때문에 다리는 있어도 연결이 끊어질 수 있다
			if (visited[i]==false) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(result);
		
	}

	// 같은 지역인 섬을 묶어주기 2번 부터 시작
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		queue.add(new int[] {x,y});
		graph[x][y]=island_cnt;
		
		while(! queue.isEmpty()) {
			int cur[]=queue.poll();
			for(int i=0; i<4;i++) {
				int nx=cur[0]+dx[i];
				int ny=cur[1]+dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<m) {					
					if(graph[nx][ny]==1) {
						graph[nx][ny]=island_cnt;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
	}
	// 다리를 놔줘서 다리 길이를 edgeList에 삽입
	private static void make_bridge(int x, int y) {
		int tmp;			
		
		for(int i=0;i<4;i++) {
			tmp=0;
			queue.add(new int[] {x,y});
			while(!queue.isEmpty()) {
				int[] cur=queue.poll();
				//방향 i로 지정 
				int nx=cur[0]+dx[i];
				int ny=cur[1]+dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					//0이면 다리 길이 증가 와 큐 삽입
					if(graph[nx][ny]==0) {
						tmp+=1;
						queue.add(new int[] {nx,ny});
					}
					
					else {
					// 다리 길이가 2 이상 일시
						if(tmp>1) {
							//반례 ㄷ자 형 섬이 있을수도 있으므로
							if(graph[x][y]-2 != graph[nx][ny]-2) {								
								edgeList[graph[x][y]-2].add(new Edge(graph[nx][ny]-2,tmp));
							}
						}
					}
				}
			}
		}

		
	}
}
