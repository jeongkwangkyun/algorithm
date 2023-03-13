package samsung_practice;

import java.io.*;
import java.util.*;

public class Solution_3814_평등주의 {
	static int[] arr;
	static int answer, N, K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1 ; i <= N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			parametricSearch();
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
	private static void parametricSearch() {
		int left = 0 ;
		int right = 1000000000;
		
		while (left < right) {
			int mid = (left + right) / 2;
			
			if (!isPossible(mid)) {
				left = mid + 1;
				answer = left;
			}
			else {
				right = mid;
			}
		}
	}
	private static boolean isPossible(int mid) {
		int[] copyArr = arr.clone();
		int cnt = 0;
		
		for (int i = 1 ; i < N; i++) {
			int gap = copyArr[i + 1] - copyArr[i];
			
			if (gap >= mid) {
				cnt += (gap - mid);
				copyArr[i + 1] -= (gap - mid);
				if (cnt > K) return false;
			}			
		}
		
		for (int i = N ; i > 1 ; i--) {
			int gap = copyArr[i - 1] - copyArr[i];
			
			if (gap >= mid) {
				cnt += (gap - mid);
				copyArr[i - 1] -= (gap - mid);
				
				if(cnt > K) return false;
			}
		}
		
		return true;
	}
}
