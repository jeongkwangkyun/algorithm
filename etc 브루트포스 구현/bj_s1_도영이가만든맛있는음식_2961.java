package a0812;
import java.io.*;
import java.util.*;

public class Main_bj_s1_도영이가만든맛있는음식_2961_서울_12반_정광균 {
	static int[][] input;
	static int[] numbers;
	static boolean[] check;
	static int min_val, n;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_s1_2961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n=Integer.parseInt(br.readLine());
		input=new int[2][n]; 
		check=new boolean[n]; //사용 용도
		for(int i=0; i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			//2차원배열로도 가능!
			input[0][i]=Integer.parseInt(st.nextToken());
			input[1][i]=Integer.parseInt(st.nextToken());
		}
		
		//부분집합
		min_val=1000000001;
		powerset(0);
		sb.append(min_val);
		System.out.println(sb);
	}
	//taste_a랑 tasted_b를 파라미터로 넘겨도 된다.
	private static void powerset(int cnt) {
		if(cnt==n) {
			int taste_a=1;
			int taste_b=0;
			for(int i=0;i<n;i++) {
				if(check[i]==true) {
					taste_a*=input[0][i];
					taste_b+=input[1][i];	
				}
			}
			// false,false,false,false 여서 1로 뜨니까 조건
			if(taste_b!=0) min_val=Math.min(Math.abs(taste_a-taste_b), min_val);
			return;
		}
		check[cnt]=false;
		powerset(cnt+1);
		
		check[cnt]=true;
		powerset(cnt+1);
	}
}
