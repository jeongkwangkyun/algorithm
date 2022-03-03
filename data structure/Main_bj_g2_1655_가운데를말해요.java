package b0303;

import java.io.*;
import java.util.*;

public class Main_bj_g2_1655_가운데를말해요 {
	static int N;
	static int num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
		for(int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(br.readLine());
			if(minHeap.size() != maxHeap.size()) {
				minHeap.add(num);
			}
			else {
				maxHeap.add(num);
			}
			
			if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
				if(maxHeap.peek() > minHeap.peek()) {
					int tmp = minHeap.poll();
					minHeap.add(maxHeap.poll());
					maxHeap.add(tmp);
				}
			}
			sb.append(maxHeap.peek()+"\n");
		}
		System.out.println(sb);
	}
}
