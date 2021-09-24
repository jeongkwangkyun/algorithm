
import java.io.*;
import java.util.*;

public class Main{
	static int  r , c,t, dust, up_x,up_y,down_x,down_y, total=2;
	static int[][] map, check;
	static Queue<int[]> queue= new LinkedList<int[]>();
	// 공기 청정기 위치 저장
	static List<int[]> list= new ArrayList<int[]>();
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	
	// 반시계
	static int[] re_dx= {-1,0,1,0};
	static int[] re_dy= {0,1,0,-1};
	
	//시계
	static int[] fo_dx= {1,0,-1,0};
	static int[] fo_dy= {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		t=Integer.parseInt(st.nextToken());
		
		map=new int[r][c];

		for(int i=0; i<r; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0 ; j<c ; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		up_x=list.get(0)[0];
		up_y=list.get(0)[1];
		
		down_x=list.get(1)[0];
		down_y=list.get(1)[1];
		
		for(int k=0 ; k<t ; k++) {
			dist_do();
			
			purifier_do();
			map=check;
		}
		
		for(int i=0;i<r; i++) {
			for(int j=0; j<c; j++) {
				total+=map[i][j];
			}
		}
		System.out.println(total);
	}

	private static void purifier_do() {
		// TODO Auto-generated method stub
		int x=up_x;
		int y=up_y;
		int dir=0;
		while(true) {
			if(dir==4) break;
			int nx=x+re_dx[dir];
			int ny=y+re_dy[dir];
			if(0<=nx && nx<=up_x && 0<=ny && ny<c) {
				check[x][y]=check[nx][ny];
				x+=re_dx[dir];
				y+=re_dy[dir];
			}
			else {
				dir+=1;
			}
		}

		check[up_x][up_y+1]=0;
		x=down_x;
		y=down_y;
		dir=0;
		while(true) {
			if(dir==4) break;
			int nx=x+fo_dx[dir];
			int ny=y+fo_dy[dir];
			if(down_x<=nx && nx<r && 0<=ny && ny<c) {
				check[x][y]=check[nx][ny];
				x+=fo_dx[dir];
				y+=fo_dy[dir];
			}
			else {
				
				dir+=1;
			}
		}
		
		check[down_x][down_y+1]=0;
		
		check[up_x][up_y]=-1;
		check[down_x][down_y]=-1;
		
		
	}

	private static void dist_do() {
		// TODO Auto-generated method stub
		check=new int[r][c];
		
		for(int i=0; i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]!=-1 && map[i][j]>4) {
					
					int dir_possible=0;
					for(int k=0 ; k<4; k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(0<=nx && nx<r && 0<=ny && ny<c) {
							if(map[nx][ny]==-1) continue;
							
							
							check[nx][ny]+= map[i][j]/5;
							dir_possible+=1;
						}
					}
					check[i][j]+=map[i][j]-(map[i][j]/5)*dir_possible;
				}
				if(map[i][j]!=-1 && map[i][j]<=4) check[i][j]+=map[i][j];
			}
		}
	}
}

