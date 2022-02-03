package b0203;

import java.io.*;
import java.util.*;

public class Main_bj_g5_2174_로봇시물레이션 {
	static int A,B,N,M;
	static int[][] map;
	static int[][] robots;
	//북 동 남 서 
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<String> queue = new LinkedList<String>();
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[B][A];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		robots = new int[N][3];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = B-Integer.parseInt(st.nextToken());
			robots[i][0] = x;
			robots[i][1] = y;
			map[x][y] = i + 1;
			String dir = st.nextToken();
			// 북 
			if(dir.equals("N")) {
				robots[i][2] = 0;
			}
			// 동
			else if(dir.equals("E")) {
				robots[i][2] = 1;
			}
			// 남 
			else if(dir.equals("S")) {
				robots[i][2] = 2;
			}
			// 서 
			else if(dir.equals("W")) {
				robots[i][2] = 3;
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int robotIndex = Integer.parseInt(st.nextToken()) - 1;
			String command = st.nextToken();
			// 전진 
			int count = Integer.parseInt(st.nextToken());
			if(command.equals("F")) {
				commnadF(robotIndex, count);
			}
			// 방향전환 
			else {
				// 왼쪽 90 
				count %= 4;
				if(command.equals("L")) {
					robots[robotIndex][2] = (robots[robotIndex][2] + (4-count)) % 4; 
				}
				// 오른쪽 90 
				else if(command.equals("R")) {
					robots[robotIndex][2] = (robots[robotIndex][2] + count) % 4;
				}
				
			}
		}
		
		if(queue.isEmpty()) System.out.println("OK");
		else System.out.println(queue.poll());
	}

	private static void commnadF(int robotIndex, int count) {
		int curX = robots[robotIndex][0];
		int curY = robots[robotIndex][1];
		int dir = robots[robotIndex][2];
		
		for(int i = 0 ; i < count ; i++) {
			int nx = curX + dx[dir];
			int ny = curY + dy[dir];
			
			if(0 > nx || nx >= B || 0 > ny || ny >= A) {
				queue.offer("Robot "+ (robotIndex+1) + " crashes into the wall");
				break;
			}
			else if(map[nx][ny] != 0) {
				queue.offer("Robot "+ (robotIndex+1) +" crashes into robot " + map[nx][ny]);
				break;
			}
			map[curX][curY] = 0;
			map[nx][ny] = robotIndex + 1;
			
			curX = nx;
			curY = ny;
			robots[robotIndex][0] = nx;
			robots[robotIndex][1] = ny;
		}	
	}
}
