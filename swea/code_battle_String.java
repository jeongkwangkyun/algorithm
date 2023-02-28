package samsung_practice;

import java.io.*;
import java.util.*;

public class code_battle_String {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int ans = 0;
			T = Integer.parseInt(br.readLine());
			String buf = br.readLine();
			String original = br.readLine();
			
			while (true) {
				if (original.lastIndexOf(buf) == -1)
					break;
				int idx = original.lastIndexOf(buf);
				ans ++;
				original = original.substring(0, idx);
			}

				
			System.out.println("#" + test_case + " " + ans);
		}
		
	}
}
