package a0817;
import java.io.*;
import java.util.*;
// 처음 map을 그려주고 값을 넣어주면서 하려했으나, 구현을 못함.
public class bj_s1_Z_1074 {
	static int count=0;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("res/input_b1_17135.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		// 행,열의 길이
		int size=(int)Math.pow(2, n);
		
		find(size,r,c);
		System.out.println(count);
	}
	// size를 줄여가면서 어디에 위치해있는지 판별해가면서 조건 넣어주기.
	static void find(int size,int r,int c) {
		//기저조건.
		if(size==1) return;
		
		//1사분면 r,c 그대로
		if(r<size/2 && c<size/2) {
			find(size/2,r,c);
		}
		//2사분면 r은 그대로 c는 절반값보다 큰 값, count 값은 1사분면 전체 값 더해주기.
		else if(r<size/2 &&c>=size/2) {
			count+= size*size/4;
			find(size/2,r,c-size/2);
		}
		//3사분면
		else if(r>=size/2 && c<size/2) {
			count += (size*size/4) *2;
			find(size/2,r-size/2,c);
		}
		else {
			count += (size*size/4)*3;
			find(size/2,r-size/2, c-size/2);
		}
	}
}
