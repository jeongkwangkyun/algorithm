package b0210;

import java.io.*;
import java.util.*;

public class Main_bj_s5_2751_수정렬하기2 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>(N);
		
		for(int i = 0 ; i < N ; i++) {
			int temp = Integer.parseInt(br.readLine());
			arr.add(temp);
		}
		Collections.sort(arr);
		for(int i = 0 ; i < N ; i++) {
			sb.append(arr.get(i)).append("\n");
		}
		System.out.println(sb);
	}

}
