package samsung_practice;

import java.io.*;
import java.util.*;

public class code_battle_달란트2 {
	static int[] number;
	static int candy, mod;
	static long ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			ans = 1;
			st = new StringTokenizer(br.readLine());
			candy = Integer.parseInt(st.nextToken());
			mod = Integer.parseInt(st.nextToken());
			number = new int[mod];
			
			Arrays.fill(number, candy / mod);
			
			for (int i = 0 ; i < mod ; i++) {
				if (i < candy % mod)
					number[i] += 1;
				
				ans *= number[i];
			}
			
			System.out.println("#" + test_case + " "+ ans);
		}
	}

}
