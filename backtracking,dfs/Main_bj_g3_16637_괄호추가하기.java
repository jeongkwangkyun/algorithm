package b0307;

import java.io.*;
import java.util.*;

public class Main_bj_g3_16637_괄호추가하기 {
	static int N, max=Integer.MIN_VALUE;
	static ArrayList<Integer> number = new ArrayList<>();
	static ArrayList<Character> operation = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		for(int i = 0 ; i < N ; i++) {
			if(i % 2  == 0) number.add(input.charAt(i) -'0');
			else operation.add(input.charAt(i));
		}
		
		dfs(0, number.get(0));
		System.out.println(max);
	}
	
	private static void dfs(int index, int sum) {
		if(index >= N/2) {
			max = Math.max(sum, max);
			return;
		}
		// 그냥 진행 
		dfs(index + 1, calculate(index, sum, number.get(index+1)));
		
		// 괄호 치고 진행 
		if(index + 1 < N/2) {
			// 뒤에 괄호쳤다고 생각하고 계산 
			int num = calculate(index + 1, number.get(index + 1), number.get(index + 2));
			// 현재 연산자와 다음 괄호를 쳐서 우선 연산 한것을 계산 
			dfs(index + 2, calculate(index, sum, num));
		}
	}
	
	private static int calculate(int index, int a, int b) {
		char op = operation.get(index);
		int result = 0;
		if(op == '+') {
			result = a+b;
		}
		else if(op == '*') {
			result = a * b;
		}
		else if(op == '-') {
			result = a - b;
		}
		return result;
	}
	
}
