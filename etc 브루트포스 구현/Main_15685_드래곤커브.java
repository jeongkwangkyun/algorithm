import java.io.*;
import java.util.*;

public class Main_15685_드래곤커브 {
	static int N,cur_x,cur_y,d,g, ans;
	// >  ^   <  V
	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	static boolean[][] map = new boolean[100][100]; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N= Integer.parseInt(br.readLine());
		ans = 0;
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			cur_x = Integer.parseInt(st.nextToken());
			cur_y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			curve();
			
		}
		
		find_curv();
		System.out.println(ans);
	}
	
	private static void find_curv() {
		for(int i=0 ; i<100 ; i++) {
			for(int j=0 ; j<100 ; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					ans++;
				}
			}
		}
	}

	private static void curve() {
		// 구현을 어떻게 해줘야하지
		List<Integer> list = new ArrayList<Integer>();
		list.add(d);
		
		for(int i = 1 ; i<=g ; i++) {
			int size = list.size()-1;
			for(int j=size ; j>=0 ; j--) {
				list.add((list.get(j)+1)%4);
			}
		}
		
		map[cur_y][cur_x]=true;
		
		for(Integer dir : list) {
			cur_x += dx[dir];
			cur_y += dy[dir];
			map[cur_y][cur_x] = true;
		}
	}
}
