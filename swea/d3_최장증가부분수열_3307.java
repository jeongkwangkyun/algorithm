package a0916;

import java.util.Scanner;

public class Solution_d3_최장증가부분수열_3307_서울_12반_정광균 {
	public static void main(String[] args) {
		StringBuilder sb= new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			int N=sc.nextInt();
			int[] arr = new int[N];
			int[] LIS = new int[N]; // 각 원소를 끝으로 하는 최장 길이
			
			for(int i=0; i<N ; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max=0; //전체 중의 최대 길이
			for(int i=0 ; i<N ; i++) {
				LIS[i]=1;
				
				for (int j = 0; j < i; j++) { //j : i의 앞쪽 원소
					if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j]+1;
					}
				} // i를 끝으로 하는 최장길이 값 계산 완료
				if (max< LIS[i]) max=LIS[i];
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
