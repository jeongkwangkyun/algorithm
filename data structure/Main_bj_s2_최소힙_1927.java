package b0310;

import java.io.*;
import java.util.*;

public class Main_bj_s2_최소힙_1927 {
	static int N;
	static PriorityQueue<Integer> queue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		queue = new PriorityQueue<Integer>((o1 , o2) -> o1 - o2);
		
		for(int i = 0 ; i < N ; i ++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input > 0) queue.add(input);
			else {
				if(queue.isEmpty()) sb.append(0).append("\n");
				else sb.append(queue.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}

}
