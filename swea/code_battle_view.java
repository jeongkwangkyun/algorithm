package practice_0224;

import java.io.*;
import java.util.*;

public class code_battle_view {
	static int[] building;
	static int n;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int answer = 0;			

			n = sc.nextInt();
			building = new int[n];
			
			for (int i = 0 ; i < n ; i++) {
				building[i] = sc.nextInt();
			}
			
			for (int i = 2 ; i < n - 2 ; i++) {
				int now = building[i];
				int max = 0;

				max = Math.max(max, building[i - 1]);
				max = Math.max(max, building[i - 2]);
				max = Math.max(max, building[i + 1]);
				max = Math.max(max, building[i + 2]);
				
				if (now - max > 0)
					answer += (now - max);
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}

}
