package a0820;

import java.io.*;
import java.util.*;

public class d4_계산기2_1223 {
	static Queue<Character> postfix;
	static Stack<Character> stack;
	static Stack<Integer> calculrator;
	public static void main(String[] args) throws Exception{

		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_d4_1223.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb=new StringBuilder();

		for(int t=1;t<=10;t++) {
			int n=Integer.parseInt(br.readLine());
			String tmp=br.readLine();
			postfix=new LinkedList<Character>();
			stack=new Stack<Character>();
			calculrator=new Stack<Integer>();
			char ch;
			//후외로 바꾸기
			for(int i=0;i<n;i++) {
				// 피연산자 값 그냥 넣기
				if(i%2==0) {
					postfix.add(tmp.charAt(i));
					
				// 연산자는 값 따져주기
				}else {
					ch=tmp.charAt(i);
					//+ 일때 
					if(ch=='+') {
						// 비어있으면 넣어주기
						if(stack.isEmpty()) {
							stack.add(ch);
						}
						//비어있지 않다면
						else {
							// stack 비어버리는 상황을 대비해서 조건 주기
							while(!stack.isEmpty()) {
								//stack안에 연산순서가 *가 더 먼저이므로 곱하기를 빼주고
								if(stack.peek()=='*') {
									postfix.add(stack.pop());
								}
								else break;
							}
							
							stack.add(ch);
						}
					}
					else if(ch=='*') {
						stack.add(ch);
					}
				}
			}
			if(stack.isEmpty()==false) {
				while(!stack.isEmpty()) {
					postfix.add(stack.pop());
				}
			}
			//후위 계산하기
			for(int i=0;i<n;i++) {
				ch=postfix.poll();
				if(ch=='*' || ch=='+') {
					int temp=calculrator.pop();
					int temp2=calculrator.pop();
					
					if(ch=='*') {
						int cnt=(temp*temp2);
						calculrator.add(cnt);
					}
					else {
						int cnt=(temp+temp2);
						calculrator.add(cnt);
					}
				}
				else {
					calculrator.add((int)ch-'0');
				}
			}
			System.out.println("#"+t+" "+calculrator.pop());
		}
	}
}