package a0819;

import java.util.Scanner;

// 같은 행에 두지 않는 방식
// n개의 퀸을 위협적이지 않게 놓는 모든 경우의 수

public class NQueenTest2 {
	
	static int N,cnt;
	static int col[];
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			N=sc.nextInt();
			
			col = new int[N+1];
			cnt=0;
			setQueens(1);
			System.out.println(cnt);
		}
		
	}
	private static void setQueens(int rowNo) {
		// 유망여부 체크: rowNo-1행까지 유망한지 체크
		if(! isAvailable(rowNo-1)) return;
		//기저조건
		if(rowNo>N) { //마지막행까지 다 둔 경우
			cnt++;
			return;
		}
		
		//1열부터 n열까지 놓아보기
		//놓았으면 다음 퀸 놓으러가기
		for (int i = 1; i <= N; i++) {
			col[rowNo]=i; //i열에 놓아보기
			setQueens(rowNo+1);
			
		}
	}
	
	//유망성 체크
	private static boolean isAvailable(int rowNo) {//rowNo : 현재검사하려는 퀸
		// TODO Auto-generated method stub
	 for (int i = 1; i < rowNo; i++) {//k: 이전퀸
		if(col[rowNo]==col[i] || Math.abs(col[rowNo]-col[i])==rowNo-i) return false;
	}
	 return true;
	}
}
