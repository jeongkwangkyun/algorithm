package b0401;

import java.io.*;
import java.util.*;

public class Main_bj_g3_8980_택배 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		ArrayList<Town> towns = new ArrayList<>();
		int num = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < num ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int box = Integer.parseInt(st.nextToken());
			towns.add(new Town(start, end, box));
		}
		Collections.sort(towns);
		
		int[] list = new int[N];
		Arrays.fill(list, C);
		int ans = 0;
		for(int now = 0 ; now < num ; now ++) {
			Town town = towns.get(now);
			
			int maxBoxNum =  Integer.MAX_VALUE;
			for(int i = town.start ; i < town.end ; i++) {
				maxBoxNum = Math.min(maxBoxNum, list[i]);
			}
			
			if(maxBoxNum >= town.box) {
				ans += town.box;
				for(int i = town.start ; i < town.end ; i++) {
					list[i] -= town.box;
				}
				
			}
			
			else if(maxBoxNum < town.box) {
				ans += maxBoxNum;
				for(int i = town.start ; i < town.end ; i++) {
					list[i] -= maxBoxNum;
				}
				
			}
		}
		
		System.out.println(ans);
		
	}
	private static class Town implements Comparable<Town>{
		int start, end, box;
		
		public Town(int start, int end, int box) {
			this.start = start;
			this.end = end;
			this.box = box;
		}
		
		public int compareTo(Town o) {
			
			if(this.end == o.end) {
				if(this.start == o.start) {
					return o.box - this.box;
				}
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}
}
