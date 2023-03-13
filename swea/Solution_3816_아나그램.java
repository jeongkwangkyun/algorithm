package samsung_practice;

import java.io.*;
import java.util.*;

public class Solution_3816_아나그램 {
	static char[] str1, str2;
	static int[] num1, num2;
	static int ans;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			ans = 0;
			str1 = sc.next().toCharArray();
			str2 = sc.next().toCharArray();
			
			num1 = new int[26];
			num2 = new int[26];
			
			for (int i = 0 ; i < str1.length ; i++) {
				int cur = str1[i] - 'a';
				num1[cur] ++;
			}
			
			comparison();
			
			for (int i = 0 ; i < str2.length - str1.length + 1; i++) {
				num2 = new int[26];
				for (int j = i ; j < str1.length + i ; j++) {
					num2[str2[j] - 'a']++;
				}
				
				comparison();
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}

	private static void comparison() {
		for (int i = 0 ; i < 26 ; i++) {
			if (num1[i] != num2[i]) return;
		}
		
		ans++;
		return;
	}

}
