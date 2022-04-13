package b0412;

import java.util.*;
import java.io.*;

public class Main_bj_s1_2092_겹치는건싫어 {
	static int N, K;
	static int[] list;
	static HashMap<Integer, Integer> hashMap = new HashMap<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int len = 1;
		
		
		while(start <= end) {
			int num = list[end];
			
			// 가지고 있는 경우 비교 
			if(hashMap.containsKey(num)) {
				// 커지는 경우 포함 x
				if(hashMap.get(num) + 1 > K) {
					while(true) {
						int tmp = list[start];
						
						hashMap.put(tmp, hashMap.get(tmp) - 1);
						
						start ++;
						if(tmp == num) {
							break;
						}		
					}
				}
				//
				else {
					hashMap.put(num, hashMap.get(num) + 1);
					len = Math.max(len, end - start + 1);
					end ++;
				}
			}
			
			//없는 경우
			else{
				hashMap.put(list[end], 1);
				len = Math.max(len, end - start + 1);
				end ++;
			}
			
			if(end == N) {
				break;
			}
		}
		
		System.out.println(len);
	}

}
