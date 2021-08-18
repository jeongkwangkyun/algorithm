package a0818;
import java.io.*;
import java.util.*;

public class 요리사_4012_서울_12반_정광균 {
	static int n,tmp_a,tmp_b;
	static boolean[] food;
	static int[] team_a,team_b;
	static int[][] map;

	static int min_val;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=t;tc++) {
			//tc마다 max값으로 초기화
			min_val=Integer.MAX_VALUE;
			n=Integer.parseInt(br.readLine());
			//a,b에 해당하는 인덱스 값 넣어주기
			team_a=new int[n/2];
			team_b=new int[n/2];
			// 전체 맛 표
			map=new int[n][n];
			for(int i=0 ; i<n; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			combination(0,0);
			sb.append("#").append(tc).append(" ").append(min_val).append("\n");
		}

		System.out.println(sb);
	
	}

	private static void combination(int cnt,int start) {
		// TODO Auto-generated method stub
		
		if(cnt==n/2) {
			//team_b에 넣어주려고 food로 불린값 판별해주고 false인 값 b에 넣기
			food=new boolean[n];
			for(int i=0;i<n/2;i++) {
				food[team_a[i]]=true;
			}
			int idx=0;
			for(int i=0;i<n;i++) {
				if(food[i]==false) {
					team_b[idx++]=i;
				}
			}
			// tmp 값은 돌때마다 초기화
			tmp_a=0;
			tmp_b=0;
			//각 팀에 인덱스 값을 x,y값 바꿔서 넣어주기
			for(int i=0;i<n/2;i++) {
				for(int j=i+1;j<n/2;j++) {
					tmp_a+=map[team_a[i]][team_a[j]];
					tmp_a+=map[team_a[j]][team_a[i]];
		
					tmp_b += map[team_b[i]][team_b[j]];
					tmp_b += map[team_b[j]][team_b[i]];
				}
			}
			min_val=Math.min(Math.abs(tmp_a-tmp_b), min_val);
			return;
		}
		
		for(int i=start;i<n;i++) {
			team_a[cnt]=i;
			combination(cnt+1, i+1);
		}
	}
}
