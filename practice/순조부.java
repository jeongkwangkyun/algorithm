package practice_0306;

import java.util.Arrays;

public class 순조부 {
	static int[] number;
	static boolean[] isSelected;
	static int N = 5;
	static int M = 3;
	
	public static void main(String[] args) {
		number = new int[M];
		isSelected = new boolean[N];
		
//		permutation(0);
//		combination(0, 0);
//		Dpermutation(0);
//		Dcombination(0, 0);
		powerset(0);
	}
	
	
	private static void powerset(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i]?number[i]:"X")+" ");
			}
			System.out.println();
			return;
		}
		
		isSelected[cnt] = false;
		powerset(cnt + 1);
		
		isSelected[cnt] = true;
		powerset(cnt + 1);
	}


	private static void Dcombination(int cnt, int start) {
		if (cnt == M) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = start ; i < N ; i++) {
			number[cnt] = i;
			Dcombination(cnt + 1, i);
		}
	}


	private static void Dpermutation(int cnt) {
		if (cnt == M) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			number[cnt] = i;
			Dpermutation(cnt + 1);
		}
	}
	private static void combination(int cnt, int start) {
		if (cnt == M) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = start; i < N ; i++) {
			number[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	private static void permutation(int cnt) {
		if (cnt == M) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			number[cnt] = i;
			permutation(cnt + 1);
			
			isSelected[i] = false;
		}
	}

}
