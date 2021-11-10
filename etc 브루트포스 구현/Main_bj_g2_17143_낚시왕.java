import java.io.*;
import java.util.*;

public class Main_bj_g2_17143_낚시왕 {
	static int R,C,m,cur_y, total;
	static int[][] map;
	// 위 아래 오른 왼 
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] shark;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		//상어 갯
		m= Integer.parseInt(st.nextToken());
		map = new int[R][C];
		total = 0;
		// r,c, 속력 , 방향,크기 
		shark = new int[m+1][5];
		for(int i=1; i<=m ; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			shark[i][0] = r;
			shark[i][1] = c;
			shark[i][2] = s;
			shark[i][3] = d;
			shark[i][4] = z;
			map[r][c] = i;
		}
		
		//낚시 시작
		cur_y=-1;
		while(true) {
			// 오른쪽으로 이동 
			if(cur_y == C-1) break;
			cur_y ++;
			// 가까운 상어 잡기 
			find();
			// 상어 이동
			move();
		}
		System.out.println(total);
		
	}
	private static void move() {
		// TODO Auto-generated method stub
		map = new int[R][C];
		for(int i = 1 ; i<=m ; i++) {
			// 상어가 존재 한다
			if(shark[i][0] != -1) {
				int x = shark[i][0];
				int y = shark[i][1];
				int s = shark[i][2];
				int d = shark[i][3];
				int z = shark[i][4];
				for(int j = 0 ; j < s ; j++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if(0>nx) {
						nx = 1 ;
						d=1;
					}
					else if(0>ny) {
						ny = 1;
						d=2;
					}
					else if(nx>R-1) {
						nx = R-2;
						d=0;
					}
					else if(ny>C-1) {
						ny = C-2;
						d=3;
					}
					x = nx;
					y = ny;
				}
				shark[i][0]=x;
				shark[i][1]=y;
				shark[i][2]=s;
				shark[i][3]=d;
				shark[i][4]=z;
				
				// 해당 맵에 상어가 있다
				if(map[x][y] != 0) {
					// 누가 더 큰지 따져준다
					if(shark[map[x][y]][4] > z) {
						shark[i][0] = -1;
					}
					else {
						shark[map[x][y]][0] = -1;
						map[x][y] = i;
					}
				}
				//없다
				else {
					map[x][y] = i;
				}
					
				
			}
		}
	}
	
	private static void find() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<R ; i++) {
			if(map[i][cur_y] != 0) {
				int shark_idx = map[i][cur_y];
				map[i][cur_y] = 0;
				total += shark[shark_idx][4];
				shark[shark_idx][0] = -1;
				
				
				break;
			}
		}
	}

}
