package b0329;

import java.io.*;
import java.util.*;

public class Main_bj_s5_1459_걷기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long X, Y, W, S;
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());
		W = Long.parseLong(st.nextToken());
		S = Long.parseLong(st.nextToken());
		
		long min = Long.MAX_VALUE;
		// 가로질러서 X 
		min = Math.min(min, W * (X + Y));
		// 가로 지를만큼 지르고 따라서 걷기 
		min = Math.min(min, S * Math.min(X, Y) + W * (Math.abs(X - Y)));
		long tmp;
		
		if((X - Y) % 2 == 0) {
			// 가로지르고 / \ 대각으로 가기 
			tmp = S * Math.min(X, Y) + S * Math.abs(X - Y);
		}
		
		else {
			//대각으로 가다가 마지막만 일자로 가기  
			tmp = S * Math.min(X, Y) + S * (Math.abs(X - Y) - 1) + W;
		}
		min = Math.min(min, tmp);
		System.out.println(min);
	
		
	}

}
