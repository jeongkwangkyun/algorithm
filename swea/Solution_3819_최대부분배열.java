package samsung_practice;

import java.io.*;
import java.util.*;

public class Solution_3819_최대부분배열 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] list;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			list = new int[N + 1];
			list[0] = sc.nextInt();
			int max = list[0];
			for (int i = 1 ; i < N ; i++) {
				list[i] = Math.max(list[i - 1], 0) + sc.nextInt();
				max = Math.max(max, list[i]);
			}
			System.out.println("#" + test_case + " " + max);
		}
	}

}
