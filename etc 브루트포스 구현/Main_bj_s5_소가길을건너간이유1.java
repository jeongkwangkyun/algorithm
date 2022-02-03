package b0203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_bj_s5_소가길을건너간이유1 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int answer = 0;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int index = Integer.parseInt(st.nextToken());
			int road = Integer.parseInt(st.nextToken());
			
			// 소 처음 발견 
			if(!hashMap.containsKey(index)) {
				hashMap.put(index, road);
			}
			// 
			else {
				if(hashMap.get(index) != road) {
					answer += 1;
					hashMap.put(index, road);
				}
			}
		}
		System.out.println(answer);
	}
}
