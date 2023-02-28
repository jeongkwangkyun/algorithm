package samsung_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class code_battle_Magnetic {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextShort();
		StringBuilder sb = new StringBuilder();
		short map[][];
		for(int test_case = 1; test_case <= T; test_case++)
		{
			short map_size = sc.nextShort();
			
			map = new short[map_size][map_size];
			
			for (int i = 0 ; i < map_size ; i++) {
				for (int j = 0 ; j < map_size ; j++) {
					map[i][j] = sc.nextShort();
				}
			}
			
			short deadlock = 0;
			for (int j = 0 ; j < map_size ; j++) {
				short curMagnetic = 0;
				for(int i = 0 ; i < map_size ; i++) {
					short magnetic = map[i][j];
					if(magnetic == 1) curMagnetic = 1;
					else if (magnetic == 2 && curMagnetic == 1) {
						curMagnetic = 0;
						deadlock ++;
					}
				}
			}
			System.out.println("#"+test_case+" "+deadlock);	
		}
	}

}
