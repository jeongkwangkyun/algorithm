import java.io.*;
import java.util.*;

public class Main_14999_주사위굴리기 {
	static int N,M,cur_x,cur_y, cmd;
	// 바닥 우 좌 하 상 위 
	static int[] dice;
	static int[][] map;
	// 동서 북 남 
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cur_x = Integer.parseInt(st.nextToken());
		cur_y = Integer.parseInt(st.nextToken());
		dice = new int[6];		
		Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j<M ; j++) {
				map[i][j] =Integer.parseInt(st.nextToken()); 
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		while(st.countTokens()!=0) {
			// 1 동 2 서 3 남 4 북 
			cmd = Integer.parseInt(st.nextToken());
			if(can_roll(cmd)) {
				roll(cmd);
				if(map[cur_x][cur_y]!=0) {
					dice[0] =map[cur_x][cur_y];
					map[cur_x][cur_y] = 0;
				}
				// 이동한 칸에 수가0일
				else {
					map[cur_x][cur_y]=dice[0];
				}
				sb.append(dice[5]).append("\n");
				
			}
		}
		
		
	}
	private static boolean can_roll(int cmd) {
		// TODO Auto-generated method stub
		
		int nx = cur_x + dx[cmd-1];
		int ny = cur_y + dy[cmd-1];
		if (0>nx || nx>= N || 0>ny || ny>= M) return false;
		cur_x = nx;
		cur_y = ny;
		return true; 
	}
	private static void roll(int cmd) {
		// TODO Auto-generated method stub
		// 1 동 2 서 3 남 4 북 
		int[] tmp = new int[6];
		for(int i=0; i<6; i++) {
			tmp[i] = dice[i];
		}
		if(cmd == 1) {
			dice[0]=tmp[1];
			dice[1]=tmp[5];
			dice[2]=tmp[0];
			dice[3]=tmp[3];
			dice[4]=tmp[4];
			dice[5]=tmp[2];
					
		}else if(cmd ==2) {
			dice[0]=tmp[2];
			dice[1]=tmp[0];
			dice[2]=tmp[5];
			dice[3]=tmp[3];
			dice[4]=tmp[4];
			dice[5]=tmp[1];
		}else if(cmd ==3) {
			dice[0]=tmp[4];
			dice[1]=tmp[1];
			dice[2]=tmp[2];
			dice[3]=tmp[0];
			dice[4]=tmp[5];
			dice[5]=tmp[3];
		}else if(cmd ==4) {
			dice[0]=tmp[3];
			dice[1]=tmp[1];
			dice[2]=tmp[2];
			dice[3]=tmp[5];
			dice[4]=tmp[0];
			dice[5]=tmp[4];
		}
	}
}
