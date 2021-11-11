package a1018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순조부_정리 {
	static int n,m;
	static int[] number;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		number = new int[m];
		isSelected = new boolean[n];
//		permutation(0);
//		combination(0,0);
//		Dpermutaion(0);
//		Dcombination(0,0);
		generateSubSet(0);
	}	
	private static void generateSubSet(int cnt) {
		// TODO Auto-generated method stub
		if(cnt == m) {
			for (int i = 0; i < n; i++) {
				System.out.print((isSelected[i]?number[i]:"X")+" ");
			}
			System.out.println();
			return;
		}

		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt]= false;
		generateSubSet(cnt+1);
	}
	// 중복 조합 
	private static void Dcombination(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt == m) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for(int i=start ; i<n ; i++) {
			number[cnt] = i+1;
			Dcombination(cnt+1, i);
		}
	}
	// 중복 순열 
	private static void Dpermutaion(int cnt) {
		// TODO Auto-generated method stub
		if(cnt == m) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for(int i=0 ; i<n; i++) {
			number[cnt] = i+1;
			Dpermutaion(cnt+1);
		}
	}
	//조합 
	private static void combination(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt == m) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for(int i=start; i<n ; i++) {
			number[cnt]=i+1;
			combination(cnt+1, i+1);
		}
	}
	// 순열 
	private static void permutation(int cnt) {
		// TODO Auto-generated method stub
		if(cnt ==m ) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for(int i=0 ; i<n ; i++) {
			if(isSelected[i]) continue;
			
			number[cnt]=i+1;
			isSelected[i]=true;
			
			permutation(cnt+1);
			isSelected[i]=false;
		}
	}
}
