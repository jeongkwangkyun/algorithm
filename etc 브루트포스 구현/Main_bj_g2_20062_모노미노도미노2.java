package b0223;

import java.io.*;
import java.util.*;

public class Main_bj_g2_20062_모노미노도미노2 {
	static int N, point;
	static int[][] blue, green;
	
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		blue = new int[6][4];
		green = new int[6][4];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			drop(green, t, y);
			//  blue 가로세로 바꾸기
			if(t == 2) t = 3;
			else if(t == 3) t = 2; 
			drop(blue, t, x);
		}
		int remainBlock = 0;
		remainBlock += count(green);
		remainBlock += count(blue);
		System.out.println(point);
		System.out.println(remainBlock);
	}

	private static void drop(int[][] map, int t, int col) {
		// [0]의 값은 무조건 들어가므로 -2로 초기값 세팅하고, 
		// [1]값은 만약 -1이라면 ++ 되는 경우가 있으므로 -2 세팅 
		// 블록이 떨어지다가 걸린 row Index 
		int[] placeRow = {-2, -2};
		// type == 2
		if(t == 2) {
			for(int i = 0 ; i < 7 ; i++) {
				if(i == 6 || map[i][col] == 1 || map[i][col+1] == 1) {
					// 떨어뜨리는 중 벽돌과 충돌, type == 0 일때 placeRow[0] 에 값 대입 
					map[i-1][col] = 1;
					map[i-1][col+1] = 1;
					placeRow[0] = i-1;
					break;
				}
			}
		}
		// type == 1,3 세로기준이여서 col+1,+2 만 비교 
		else {
			for(int i = 0 ; i < 7 ; i++) {
				// 해당 row,col이 1이거나, 마지막 row일때 
				if(i == 6 || map[i][col] == 1) {
					map[i-1][col] = 1;
					placeRow[0] = i - 1;
					// 3이면 col으로 두칸이므로 
					if(t == 3) {
						// type == 3이면 1에 대입 
						map[i-2][col] = 1;
						placeRow[1] = i - 2;
					}
					break;
				}
			}
		}
		
		boom(map, placeRow);
	}

	private static void boom(int[][] map, int[] placeRow) {
		// 점수를 얻을 수 있는지 탐색, 0,1번째 row면 break하고
		// 아니면 위치한 row에 값이 모두 1인지 탐색 
		Loop: for(int i = 0 ; i < 2; i++) {
			// 새로 놓여진 자리 탐색 
			int row = placeRow[i];
			// 0 과 1 row는 break
			if(row < 2) {
				break;
			}
			// row가 모두 1일 때 
			for(int j = 0 ; j < 4 ; j++) {
				if(map[row][j] == 0) {
					continue Loop;
				}
			}
			point ++;
			// t == 3 일때 [1]값에 2칸중 위에 칸이 들어가므로 한칸 땡겨줌 
			placeRow[1] ++;
			for(int j = row ; j > 0 ; j--) {
				map[j] = map[j-1].clone();
			}
			Arrays.fill(map[0], 0);
		}
		
		int specialLine = 0;
		for(int i = 0 ; i < 2 ; i++) {
			if(placeRow[i] == 0 || placeRow[i] == 1) {
				specialLine ++;
			}
		}

		// 0과 1에 걸치면 밀기
		if(specialLine != 0) {
			for(int j = 5 ; j > 1 ; j--) {
				map[j] = map[j - specialLine].clone();
			}
			Arrays.fill(map[0], 0);
			Arrays.fill(map[1], 0);
		}
	}
	
	// 남은 타일 갯수 카운트 
	private static int count(int[][] map) {
		int num = 0;
		for (int i = 2; i < 6; i++)
			for (int j = 0; j < 4; j++)
				if (map[i][j] == 1)
					num++;
		return num;
	}
}
