
import java.io.*;
import java.util.*;

public class Main_bj_g5_14503_로봇청소기 {

	static int N, M, curX, curY, curDir, totalClean, dirCheck;
	static int[][] map;
	static boolean[][] visited;
	// 북 동 남 서 
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		curX = Integer.parseInt(st.nextToken());
		curY = Integer.parseInt(st.nextToken());
		curDir = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(dirCheck != 4) {
			curClean();
			
			dirCheck = 0;
			for(int i = 0 ; i < 4 ; i++) {
				if(cleanAvailiable()) break;
				
				if(i == 3) {
					backAvailiabe();
				}
				dirCheck += 1;
			}
		}
		System.out.println(totalClean);
	}

	private static void backAvailiabe() {
		int nx = curX + dx[(curDir+2) % 4];
		int ny = curY + dy[(curDir+2) % 4];
		
		if(map[nx][ny] == 0) {
			curX = nx;
			curY = ny;
			dirCheck = 0;
		}
	}

	private static boolean cleanAvailiable() {
		curDir = (curDir + 3) % 4;
		int nx = curX + dx[curDir];
		int ny = curY + dy[curDir];
		
		if(map[nx][ny] == 0 && visited[nx][ny] == false) {
			curX = nx;
			curY = ny;
			return true;
		}
		
		return false;
	}

	private static void curClean() {
		// TODO Auto-generated method stub
		if(visited[curX][curY] == true) return;
		
		totalClean += 1;
		visited[curX][curY] = true;
		dirCheck = 0;
		return;
	}

	
}
