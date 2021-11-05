package a1010;

import java.io.*;
import java.util.*;

//0.5 초씩 만나는거를 해결못해줬다. 4000으로 늘려볼까하다가 안했는데 뭐든지 시도는 해봐야겠다.
// 0.5초씩 전진해서 만나는 경우 -> 4000으로 늘려서 해결 
// map을 두배로 늘려줌으로써 0.5,1초 나눌 필요없이 한번에 해결 가능 
public class Solution_5648_원자소멸시물레이션 {

    static int N, ans;
	static int[][] map=new int[4001][4001];
	
	//상 하 좌 우 반대로 따져줘야 반대로 따져줘야한다. 30분 잡아먹음.. 
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static Queue<Pos> queue;
	
	static class Pos{
		int y,x,dir,energy;
		public Pos(int y, int x, int dir, int energy) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.energy = energy;
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t= Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=t ; tc++) {
			N = Integer.parseInt(br.readLine());
			queue= new LinkedList<Pos>();
			ans=0;
			for(int i=0 ; i<N ; i++) {
				st= new StringTokenizer(br.readLine()," ");
				
				int x= Integer.parseInt(st.nextToken());
				int y= Integer.parseInt(st.nextToken());
				int dir=Integer.parseInt(st.nextToken());
				int energy=Integer.parseInt(st.nextToken());
				
				//  테케중에 energy0 일 경우 없는거랑 비교를 못해주므로 
//				energy 최대값보다 +1 해준다음 출력하기 전에 빼준다. 
				if(energy == 0) energy = 101;
				//0.5 -> 1초 해줘야하니까 2배로 늘려주고 전체 4000기준이므로 +2000씩 해주기 
				queue.add(new Pos(2*y+2000,2*x+2000,dir,energy));	
			}
			bfs();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		int cntzero = 0;
		// map을 테케마다 선언 안해줘도 되는게 범위를 벗어나게되면 map현재값이 0으로 바뀐다. 
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			// 현재 위치에서 값이 내 에너지보다 크면 값 더해주기
			// 기준이 현재 위치로 잡아서 비교해주니까 생각하기 더 쉬운편. 
			if(map[cur.y][cur.x]>cur.energy) {
				if(cur.energy==101) {
					cntzero++;
				}
				ans += map[cur.y][cur.x];
				map[cur.y][cur.x]=0;
				continue;
			}
			
			// 현재위치를 0으로 만들기 
			map[cur.y][cur.x]=0;
			int ny = cur.y + dy[cur.dir];
			int nx = cur.x + dx[cur.dir];
			if(0>nx || nx>4000 || 0>ny|| ny>4000) continue;
			// map[ny][nx]가 0일 경우 
			if(map[ny][nx]==0) {
				queue.offer(new Pos(ny,nx,cur.dir,cur.energy));
			}
			// 아닐 경우 queue에 넣어줄 필요 없고 energy가 0인지 확
			else {
				if(cur.energy==101) {
					cntzero++;
				}
			}
			// 다음위치 += 해준다 여러개가 모이는상황 고려 
			map[ny][nx] += cur.energy;
		}
		ans -= cntzero*101;
		
	}

}
