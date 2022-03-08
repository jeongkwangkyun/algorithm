package b0308;

import java.io.*;
import java.util.*;

public class Main_bj_s1_18428_감시피하기 {
	static int N;
	static String[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static int[][] number = new int[3][2];
	static ArrayList<Node> students = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		visited = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = st.nextToken();
				if(map[i][j].equals("S")) {
					students.add(new Node(i, j));
				}
				if(!map[i][j].equals("X")) {
					visited[i][j] = true;
				}
			}
		}
		
		combination(0, 0);
		System.out.println("NO");
	}
	
	
	
	private static void combination(int cnt, int index) {
		// 학생 위치 기반으로 체크하기 
		if(index == N*N) {
			return;
		}
		
		if(cnt == 3) {
			checkStudent();
			return;
		}
		
		int row = index / N;
		int col = index % N;
		
		if(map[row][col].equals("X")) {
			visited[row][col] = true;
			combination(cnt + 1, index + 1);
			visited[row][col] = false;
		}
		combination(cnt, index + 1);
	}



	private static void checkStudent() {
		boolean flag = true;
		for(int i = 0 ; i < students.size() ; i++) {
			Node student = students.get(i);
			
			for(int dir = 0 ; dir < 4 ; dir++) {
				if(!hasTeacher(student.x, student.y, dir)) flag = false;
			}
		}
		
		if(flag == true) {
			System.out.println("YES");
			System.exit(0);
		}
	}



	private static boolean hasTeacher(int x, int y, int dir) {
		while(true) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(0 > nx || nx >= N || 0 > ny || ny >= N) break;
			 
			if(map[nx][ny].equals("X") && visited[nx][ny]) break;
			// 선생님 
			if(map[nx][ny].equals("T")) return false;
			
			x = nx;
			y = ny;
		}
		
		return true;
	}



	private static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
