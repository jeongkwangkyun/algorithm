package a1020;

import java.io.*;
import java.util.*;
//순서대로 받으면서
// ex 4 번은 일단 true , 2 5 1 7 찾고
// 2 5 1 7 visited 인지 아니라면 가장 작은 행 열
// 있다면 어느 자리가 가장 좋은지 
// 만족도 테스트도 효과적으로 ..!!

public class Main_21608_상어초등학교 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int N, students, student, totalCnt;
	static int[][] map;
	static int[][] satisfied,tmp;
	static int[]  total;
	static int[][] idx_list; //픽된 학생의 x,y 좌표값 
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());
		students = N*N;
		map = new int[N][N];
		idx_list = new int[students][2];
		total = new int[students];
		totalCnt = 0;
		// idx_list -1로 초기화
		for(int i=0 ; i<students ; i++) {
			for(int j=0 ; j<2 ; j++) {
				idx_list[i][j]=-1;
			}
		}
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				map[i][j]=-1;
			}
		}
		
		tmp = new int[students][4];
		for(int i=0 ; i<students ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			student = Integer.parseInt(st.nextToken())-1;
			// 선호하는 학생들 담기 
			for(int j=0 ; j<4 ; j++) {
				tmp[student][j] = Integer.parseInt(st.nextToken())-1;
			}
			//좋아하는 학생 옆 자리가 있나?
			isAvailable(); 
			// 1. 좋아하는 학생 인접한 칸이 많은 곳 가기 
			find();
		}
		// 만족도찾기 total에 넣기
		
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				int cnt = 0;
				for(int k=0 ; k<4 ; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(0>nx || nx>= N || 0>ny || ny>= N) continue;
					for(int d=0 ; d<4 ; d++) {
						if(tmp[map[i][j]][d]==map[nx][ny]) cnt++;
					}
				}
				total[map[i][j]]=cnt;
			}
		}
		for(int i=0 ; i<students ; i++) {
			if(total[i]==1) totalCnt += 1;
			else if(total[i]==2) totalCnt += 10;
			else if(total[i]==3) totalCnt += 100;
			else if(total[i]==4) totalCnt += 1000;
		}
		System.out.println(totalCnt);
	}
	private static void find() {
		// TODO Auto-generated method stub
		int max=-1;
		int x=-1;
		int y=-1;
		// 3번 오름차순 순서로 탐색하기 때문에 
		for(int i=0 ; i<N ;i++) {
			for(int j=0 ; j<N ; j++) {
				// 2번 비어 있는 칸 세기
				if(map[i][j]!=-1) continue;
				if(max==satisfied[i][j]) {
					int res1 =0;
					int res2 =0;
					for(int k=0 ; k<4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if(0>nx || nx>= N || 0>ny || ny>= N) continue;
						if(map[nx][ny]==-1) res1++;
					}
					
					for(int k=0 ; k<4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(0>nx || nx>= N || 0>ny || ny>= N) continue;
						
						if(map[nx][ny]==-1) res2++;
					}
					if(res2==res1) {
						continue;
					}
					if(res2>res1) {
						x=i;
						y=j;
					}
				}
				else if(max<satisfied[i][j]) {
					max = satisfied[i][j];
					x = i;
					y = j;
				}
			}
		}
		
		map[x][y]=student;
		idx_list[student][0]=x;
		idx_list[student][1]=y;
		
	}
	private static void isAvailable() {
		// TODO Auto-generated method stub
		
		satisfied = new int[N][N];
		
		for(int i=0 ; i<4 ; i++) {
			// 픽이 된지 안된지 
			if(idx_list[tmp[student][i]][0] != -1) {
				
				int x = idx_list[tmp[student][i]][0];
				int y = idx_list[tmp[student][i]][1];
				for(int j=0 ; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(0>nx || nx>= N || 0>ny || ny>= N) continue;
					satisfied[nx][ny] += 1;
				}
			}
		}
		
				
	}

}
