package b0103;

import java.io.*;
import java.util.*;

public class Main_bj_g2_12100_2048 {
	static int N;
	static int answer = 0 ;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recursion(0, map);
		System.out.println(answer);
	}

	private static void recursion(int cnt, int[][] map) {
		if(cnt == 5) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					answer = Math.max(answer, map[i][j]);
				}
			}
			return;
		}

		recursion(cnt + 1, moveBlock(deepCopy(map),1));
		recursion(cnt + 1, moveBlock(deepCopy(map),2));
		recursion(cnt + 1, moveBlock(deepCopy(map),3));
		recursion(cnt + 1, moveBlock(deepCopy(map),4));
	}

	// 옮긴것들을 같은 것이 있어주면 더해주는 함수 
	private static int[][] moveBlock(int[][] map, int dir) { 
		map = fillBlank(map, dir);
		switch(dir) {

		// 위쪽을 기준으로 밑에 거랑 같으면 합쳐주기 
		case 1:
			for(int i = 0 ; i < N-1 ; i++) {
				for(int j = 0 ; j < N ; j++) {
					int move = i+1;
					if(map[i][j] == map[move][j]) {
						map[i][j] += map[move][j];
						map[move][j] = 0;
					}
				}
			}
			break;
			// 아래를 기준으로 위랑 같으면 합쳐주기 
		case 2:
			for(int i = N-1 ; i>=1 ; i--) {
				for(int j = 0 ; j< N ; j++) {
					int move = i-1;
					if(map[i][j] == map[move][j]) {
						map[i][j] += map[move][j];
						map[move][j] = 0;
					}
				}
			}
			break;
			
		// 왼쪽을 기준으로 오른쪽이랑 같으면 합쳐주기 
		case 3:
			for(int i=0 ; i < N ; i++) {
				for(int j = 0 ; j < N -1 ; j++) {
					int move = j+1;
					if(map[i][move] == map[i][j]) {
						map[i][j] += map[i][move];
						map[i][move] = 0;
					}
				}
			}
			break;
			
		// 오른쪽을 기준으로 왼쪽이랑 같으면 합쳐주기 
		case 4:
			for(int i = 0 ; i < N ; i++) {
				for(int j = N -1 ; j > 0 ; j--) {
					int move = j-1;
					if(map[i][move] == map[i][j]) {
						map[i][j] += map[i][move];
						map[i][move] = 0;

					}
				}
			}
			break;
		}
		
		// 중간에 0이 된거를 다시 땡겨주고 return 
		return fillBlank(map, dir);
	}

	// 위아래왼오 방향으로 옮기는 작업, 위로 옮기면 모두다 위쪽으로 쏠려야함 
	private static int[][] fillBlank(int[][] map, int dir) {
		switch(dir) {
		// 아래 - > 위로 땡겨주
		case 1:
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(map[i][j] == 0) {
						int move = i+1;
						while(move < N) {
							if(map[move][j] != 0){									
								map[i][j] = map[move][j];
								map[move][j] = 0;
								break;
							}
							move ++;
						}
					}
				}
			}
			break;
			// 위 - > 아래로 이
		case 2:
			for (int i = N-1 ; i>= 0 ; i--) {
				for(int j = 0 ; j < N ; j++) {
					if (map[i][j] == 0) {
						int move = i-1;
						while(move >= 0) {
							if (map[move][j] != 0) {
								map[i][j] = map[move][j];
								map[move][j] = 0;
								break;
							}
							move --;
						}
					}
				}
			}
			break;

			// 오른 -> 왼쪽으로 이동 
		case 3:
			for(int i=0 ; i < N ; i++) {
				for(int j=0 ; j < N ; j++) {
					if(map[i][j] == 0) {
						int move = j+1;
						while (move < N) {
							if(map[i][move] != 0) {
								map[i][j] = map[i][move];
								map[i][move] = 0;
								break;
							}
							move++;
						}
					}
				}
			}
			break;

			// 왼 -> 오른쪽을 이동 
		case 4:
			for(int i = 0 ; i < N ; i++) {
				for(int j = N -1 ; j > 0 ; j--) {
					if(map[i][j] == 0) {
						int move = j - 1;
						while (move >= 0 ) {
							if(map[i][move] != 0) {
								map[i][j] = map[i][move];
								map[i][move] = 0;
								break;
							}
							move --;
						}
					}
				}
			}
			break;	
		}

		return map;
	}

	// 깊은복사 
	private static int[][] deepCopy(int[][] ary) {
		int[][] ret = new int[N][N];

		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				ret[i][j] = ary[i][j];
			}
		}

		return ret;
	}
}
