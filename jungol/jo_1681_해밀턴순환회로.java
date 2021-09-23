package a0923;

import java.io.*;
import java.util.*;


public class jo_1681_해밀턴순환회로 {
	
	static int[][] map;
	
	static int n , min_val=100000;
	//순열 이
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		//n이 1이 아닐때
		
		if(n!=1) {
			StringTokenizer st;
			map=new int[n][n];
			// 출발지와 목적지가 회사니까 numbers에 다음 목적지를 저장 
			numbers=new int[n-1];
			isSelected = new boolean[n-1];

			for(int i=0 ; i <n ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0 ; j<n; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			
			permutation(0, 0);
			//
			if(min_val==Integer.MAX_VALUE) System.out.println(0);
			else {			
				System.out.println(min_val);
			}			
		}
		// n=1일때 
		else {
			System.out.println(2*Integer.parseInt(br.readLine()));
		}

	}
	// val 백트래킹에 이
	// min_val를 기준으로 순열이 돌때마다 val에 이동하기 위한 비용을 더해주며,
	// 최소값보다 커지면 return
	
	// 출발지와 도착지가 회사므로 0->배달 장소의 순열 -> 0 으로 돌아온다고 로직 구
	private static void permutation(int cnt, int val) {
		// TODO Auto-generated method stub
		if(val>=min_val) return;

		if(cnt==n-1) {
			int tmp;
			//
			tmp=val+map[numbers[n-2]][0];
            if(tmp==0) return;
            min_val=Math.min(val+tmp, min_val);
			
			return;
		}

		for(int i=0; i<n-1; i++) {
			if(isSelected[i]) continue;
            int plus;
            numbers[cnt]=i+1;
            isSelected[i]=true;
 
            // cnt==0일때 0-> 첫번째 배달장소 
            if(cnt==0) plus=map[0][numbers[0]];
            // cnt!=0일 cnt-1 번째 배달장소 -> cnt번째 배달장소
            else plus=map[numbers[cnt-1]][numbers[cnt]];
            // 배달하지 못하는 상황일땐 백트래킹 
            if(plus==0) plus=100001;
            permutation(cnt+1, val+plus);
            isSelected[i]=false;
		}

	}

}
