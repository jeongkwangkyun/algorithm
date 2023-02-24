package practice_0224;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class code_battle_단순2진암호코드 {
	static String[] num = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
	static int[] list;
	static int n, m;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int ans = 0;
			int odd;
			int even;
			list = new int[8];
			n = sc.nextInt();
			m = sc.nextInt();
			Loop : for(int i = 0 ; i < n ; i++) {
				String input = sc.next();
				
				if(ans != 0) continue;
				if (!input.contains("1")) continue;
				odd = 0;
				even = 0;
				int idx = input.lastIndexOf("1");
				String tmp = input.substring(idx - 55, idx + 1);
				
				for(int j = 0 ; j < 8 ; j++) {
					String code = tmp.substring(j * 7, j * 7 + 7);
					boolean check = false;
					for (int k = 0 ; k < 10 ; k++) {
						if (code.equals(num[k])) {
							list[j] = k;
							check = true;
							break;
						}
					}
					if (!check) continue Loop;
				}
				
				for(int k=0; k<8; k=k+2) {
					odd += list[k];
				}
				
				for(int k=1; k<8; k=k+2) {
					even += list[k];
				}
				
				if (((odd * 3 + even) % 10) == 0) {
					ans = (odd + even);
				}
			}
			
			
			System.out.println("#"+test_case + " " + ans);
			ans = 0;
		}
	}

}
