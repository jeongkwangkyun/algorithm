import java.io.*;
import java.util.*;

public class Main_bj_g5_20056_마법사상어와파이어볼 {
	static int[] dx = {-1,-1,0,1,1,1,0};
	static int[] dy = {0,1,1,1,0,-1,-1};
	static int[][][] map ;
	static int N,M,K;
	
	static int x,y,m,d,s;
	static Queue<int[]> queue = new LinkedList<int[]>();
	// 위치 기억하기 
	static Queue<int[]> pos = new LinkedList<int[]>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			int m=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			queue.add(new int[] {x,y,m,d,s});
		}
		
		for(int i = 0 ; i<K ; i++) {
			int size = queue.size();
			//갯수 , 질량,속도, 방향 판별, 최종 방향, 1개일때 dir 값 따져주기 
			map = new int[N][M][6];
			for(int j = 0 ; j<size;  j++) {
				int cur[] = queue.poll();
				// x,y, 질량 ,방향, 속도 
				x = cur[0];
				y = cur[1];
				m = cur[2];
				d = cur[3];
				s = cur[4];
				
				// nx, ny 를 x,y에 넣어주기  
				move();
				// x,y값 저장하기 
				if(map[x][y][0] ==1) pos.add(new int[] {x,y});
				
				// 갯수 
				map[x][y][0]+=1;
				// 질량은 다 더하기 
				map[x][y][1]+=m;
				// 속력 
				map[x][y][2]+=s;
				map[x][y][5] =d;
				// 최종 방향이 홀수나 짝수가 아니면 1로 설정 
				if(map[x][y][4] == 0) {					
					// 아무것도 없을땐 0 이니까 방향 
					// 이때 홀수면 1로하고 짝수면 2로 하자 
					if(map[x][y][3]==0) {
						if(d % 2 ==1) {
							map[x][y][3] =1;
						}
						else {
							map[x][y][3] =2 ;
						}
					}
					else {
						if(d % 2 ==1 && map[x][y][3] ==1) continue;
						else if(d % 2 ==0 && map[x][y][3] ==2) continue;
						else {
							map[x][y][4] =1;
						}
					}
				}
			}
			for(int j=0 ; i<N ; i++) {
				for(int k = 0 ; j<N ; j++) {
					if(map[j][k][0]==1) {
						queue.add(new int[] {j,k,map[j][k][1],map[i][j][5]});
					}
				}
			}
			
			//갈라지기 
			divide();
			
			// 1인애들 따로 넣어줘야하나 어차피 그럼 완탐인데 .. 
		}
		
	}

	private static void divide() {
		// TODO Auto-generated method stub
		while(!pos.isEmpty()) {
			int[] tmp = pos.poll();
			int cur_x = tmp[0];
			int cur_y = tmp[1];
			
			int start = 0 ;
			// 모두 홀 짝 인경
			if(map[cur_x][cur_y][4] != 0) {
				start = 1;
			}
			
			// 나뉘는 질량 
			int div_m = map[cur_x][cur_y][1] /5;
			if(div_m == 0) {
				continue;
			}
			// 나뉘는 속력 
			int div_s = map[cur_x][cur_y][2] / map[cur_x][cur_y][0];
			
			for(int i = start; i<8 ; i+=2) {
				int nx = cur_x+dx[i];
				int ny = cur_y+dy[i];
				
				if(0>nx) nx=N-1;
				else if(nx>=N) nx=1;
				else if(0>ny) ny=N-1;
				else if(0>nx) nx=N-1;
				queue.add(new int[] {nx,ny,div_m,i,div_s});
			}
		}
	}

	private static void move() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<s; s++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(0>nx) nx=N-1;
			else if(nx>=N) nx=1;
			else if(0>ny) ny=N-1;
			else if(0>nx) nx=N-1;
			nx=x;
			ny=y;
		}
		
		
	}

}
