package practice_0315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4040_문자열의거듭제곱 {
	static int[] table;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int ans = 0;
			String pattern = br.readLine();
			
			makeTable(pattern);
		
			System.out.print("#" + test_case + " ");
			//System.out.println(table[pattern.length() - 1]);
			if (pattern.length() % (pattern.length() - table[pattern.length() - 1]) != 0)
				System.out.println(1);
			else
				System.out.println(pattern.length() / (pattern.length() - table[pattern.length() - 1]));
		}
	}

	private static void makeTable(String pattern) {
		int pLen = pattern.length();
		table = new int[pLen];
		
		int index = 0;
		for (int i = 1 ; i < pLen ; i++) {
			while (index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
				index = table[index - 1];
			}
			
			if (pattern.charAt(i) == pattern.charAt(index)) {
				index += 1;
				table[i] = index;
			}
		}
	}

}
