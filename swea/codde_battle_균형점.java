package samsung_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codde_battle_균형점 {
	static double ans;
	static Double[] xArr;
	static int[] weightArr;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			xArr = new Double[N];
			weightArr = new int[N];
			
			for(int i = 0 ; i < N ; i++) {
				xArr[i] = Double.parseDouble(st.nextToken());
			}
			
			for(int i = 0 ; i < N ; i++) {
				weightArr[i] = Integer.parseInt(st.nextToken());
			}
			sb.append("#").append(test_case).append(" ");
			for (int i = 0 ; i < N - 1 ; i++) {				
				searchPoint(i, xArr[i], xArr[i + 1]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

	private static void searchPoint(int mid, Double left, Double right) {
		double xLoc = 0;
		double sum;
		int cnt = 0;
		while(cnt <= 100) {
			xLoc = (left + right) / 2.0;
			
			sum = 0;
			
			for (int i = 0 ; i <= mid ; i++) {
				sum += weightArr[i]/((xArr[i] - xLoc) * (xArr[i] - xLoc));
			}
			
			for (int i = N - 1 ; i > mid ; i--) {
				sum -= weightArr[i]/((xArr[i] - xLoc) * (xArr[i] - xLoc));
			}
			
			if (sum > 0)
				left = xLoc;
			else if (sum < 0)
				right = xLoc;
			
			cnt ++;
		}
		sb.append(String.format("%.10f", xLoc)).append(" ");
	}

}
