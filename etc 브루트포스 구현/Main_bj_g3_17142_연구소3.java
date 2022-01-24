package b0121;

import java.io.*;
import java.util.*;

public class Main_bj_g3_17142_연구소3 {
	static int N, M, virusCnt, blankCnt, time;
	static int[][] map;
	static boolean[][] visited, tmpVisited;
	static int[] numbers;
	static ArrayList<Virus> virusList = new ArrayList<>();
	static Queue<Virus> queue = new LinkedList<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		tmpVisited = new boolean[N][N];
		time = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				// 0인 경우 빈칸 개수 ++
				if(temp == 0) {
					blankCnt += 1;
				}
				// 1인 경우 방문처리 
				else if(temp == 1) {
					visited[i][j] = true;
				}
				// 2인 경우 바이러스 리스트와 개수 
				else if(temp == 2) {
					virusList.add(new Virus(i,j));
					virusCnt += 1;
				}
			}
		}
		numbers = new int[M];
		combination(0,0);
		if(time == Integer.MAX_VALUE) time = -1;
		System.out.println(time);
	}
	//조합 이용하기, M개의 바이러스를 활성화 시킬 때 
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			//visited 복사하기
			copyVisited();
			// bfs에서 사용할 큐에 바이러스 넣어주고 방문처리 
			for(int i = 0 ; i < numbers.length ; i++) {
				queue.offer(new Virus(virusList.get(numbers[i]).x, virusList.get(numbers[i]).y));
				tmpVisited[virusList.get(numbers[i]).x][virusList.get(numbers[i]).y] = true;
			}
			time = Math.min(time, bfs(blankCnt));
			return;
		}

		for(int i = start ; i < virusCnt ; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
			
		}
	}

	// cnt 개수비교를 통해서 0이 되면 탐색 중단 
	private static int bfs(int cnt) {
		int time = 0;
		
		while(!queue.isEmpty()) {
			int size = 	queue.size();
			if(cnt == 0) {
				queue.clear();
				return time;
			}
			time += 1;
			while(size-- > 0) {
				Virus virus = queue.poll();
				for(int i = 0 ; i < 4 ; i ++) {
					int nx = virus.x + dx[i];
					int ny = virus.y + dy[i];

					if(0 > nx || nx >= N || 0 > ny || ny>= N) continue;
					// 이미 방문한 곳이나 벽인 경우 
					if(tmpVisited[nx][ny] == true || map[nx][ny] == 1)  continue;
					// 바이러스가 이미 있는 경우
					if(map[nx][ny] == 2) {
						tmpVisited[nx][ny] = true;
						queue.offer(new Virus(nx, ny));
					}
					// 0 빈칸 방문한 경우, 빈칸에 바이러스가 확산됐으므로 cnt --
					else {
						tmpVisited[nx][ny] = true;
						queue.offer(new Virus(nx, ny));
						cnt -= 1;
					}
				}
			}
		}

		return Integer.MAX_VALUE;
	}

	private static void copyVisited() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				tmpVisited[i][j] = visited[i][j];
			}
		}
	}
	// 바이러스 객체 
	static class Virus{
		int x,y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
