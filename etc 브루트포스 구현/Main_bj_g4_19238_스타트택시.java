package b0103;

import java.io.*;
import java.util.*;

public class Main_bj_g4_19238_스타트택시 {
	static int N, M, fuel;
	static int map[][];
	static Passesnger[] passengers;
	static Queue<Integer>[][] passengerMap;
	static Taxi taxi;
	static int[] dirRow = {-1,0,1,0};
	static int[] dirCol = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		// 벽이 있는것만 map 고려 
		map = new int[N+1][N+1];
		passengers = new Passesnger[M+1];
		// 승객들만 있는 map 
		passengerMap = new LinkedList[N+1][N+1];
		for(int i = 1; i <= N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j <= N ; j++) {
				passengerMap[i][j] = new LinkedList<Integer>();
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int startRow = Integer.parseInt(st.nextToken());
		int startCol = Integer.parseInt(st.nextToken());
		taxi = new Taxi(startRow, startCol, 0);
		for(int i = 1 ; i <= M ; i++) {
			st= new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int dr = Integer.parseInt(st.nextToken());
			int dc = Integer.parseInt(st.nextToken());
			// 승객들 맵에 idx 넣
			passengerMap[sr][sc].add(i);
			// 승객 정보 저장 출발row, 출발 col, 도착row, 도착col, idx
			passengers[i] = new Passesnger(sr, sc, dr, dc, i);
		}
		
		for(int i = 0; i < M ; i++) {
			// 태울 출발 승객 찾기 
			if(! searchPassenger()) {
				System.out.println(-1);
				return;
			}
			// 출발승객을 찾는데 걸린 시간 
			int startTime = taxi.time;
			// 출발지와 목적지가 서로 다른상황,, poll 
			int idx = passengerMap[taxi.row][taxi.col].poll();
			// 목적지 찾기 도달할 수 없다면 -1 출력 
			if(! goDest(passengers[idx].dr, passengers[idx].dc)) {
				System.out.println(-1);
				return;
			}
			// 출발 고객 찾는시간 + 도착지 도달한 시간 
			fuel -= taxi.time ;
			
			if(fuel < 0) {
				System.out.println(-1);
				return;
			}
			else {
				fuel += (2 * (taxi.time - startTime));
				taxi.time = 0;
			}
		}
		System.out.println(fuel);
		return;
	}
	
	private static boolean goDest(int dr, int dc) {
		Queue<Taxi> queue = new LinkedList<>();
		queue.offer(taxi);
		boolean[][] visited = new boolean[N+1][N+1];
		visited[taxi.row][taxi.col] = true;
		
		while(!queue.isEmpty()) {
			Taxi cur = queue.poll();
			if(cur.row == dr && cur.col == dc) {
				taxi = cur;
				return true;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int nextRow = cur.row + dirRow[i];
				int nextCol = cur.col + dirCol[i];
				if(nextRow < 1 || nextCol < 1 || nextRow > N || nextCol > N || visited[nextRow][nextCol] || map[nextRow][nextCol] == -1) continue;
				
				visited[nextRow][nextCol] = true;
				queue.offer(new Taxi(nextRow, nextCol, cur.time+1));
			}
		}
		return false;
	}

	private static boolean searchPassenger() {
		ArrayList<Taxi> candidatePassengers = new ArrayList<>();
		Queue<Taxi> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][N+1];
		queue.offer(taxi);
		visited[taxi.row][taxi.col] = true;
		while(!queue.isEmpty()) {
			Taxi cur = queue.poll();
			// 모든 승객들을 태운것을 고려해서 가장먼저 태운 승객보 compareTo로 time이 더 걸린다 continue
			if(!candidatePassengers.isEmpty() && candidatePassengers.get(0).time < cur.time) continue;
			// 시간이 덜 걸린다면 add 
			if(!passengerMap[cur.row][cur.col].isEmpty()) {
				candidatePassengers.add(cur);
				continue;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int nextRow = cur.row + dirRow[i];
				int nextCol = cur.col + dirCol[i];
				if(nextRow < 1 || nextRow > N || nextCol < 1 || nextCol > N || visited[nextRow][nextCol] || map[nextRow][nextCol] == -1) continue;
				
				visited[nextRow][nextCol] = true;
				queue.offer(new Taxi(nextRow, nextCol, cur.time+1));
			}
		}
		if(candidatePassengers.isEmpty()) return false;
		// 컬렉션sort해서 한번 더 검사 
		Collections.sort(candidatePassengers);
		
		taxi = candidatePassengers.get(0);
		return true;
	}

	static class Passesnger{
		int sr, sc, dr, dc, idx;

		public Passesnger(int sr, int sc, int dr, int dc, int idx) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.dr = dr;
			this.dc = dc;
			this.idx = idx;
		}
	}
	
	static class Taxi implements Comparable<Taxi>{
		int row, col, time;

		public Taxi(int row, int col, int time) {
			super();
			this.row = row;
			this.col = col;
			this.time = time;
		}
		
		public int compareTo(Taxi o) {
			if(this.time == o.time) {
				if(this.row == o.row) {
					return this.col - o.col;
				}
				return this.row - o.row;
			}	
			return this.time - o.time;
		}
	}
}
