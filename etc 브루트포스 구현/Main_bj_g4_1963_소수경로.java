package b0413;

import java.util.*;
import java.io.*;

public class Main_bj_g4_1963_소수경로 {	
	static int T;
	static char[] input;
	static int output;
	static boolean[] primeList;
	static boolean[] visited;
	static Queue<char []> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		makeList();
		
		
		for(int i = 0 ; i < T ; i++) {
			st = new StringTokenizer(br.readLine());
			input = st.nextToken().toCharArray();
			output = Integer.parseInt(st.nextToken());
			visited = new boolean[10000];
			
			bfs();
		}
		
	}
	
	private static void bfs() {
		int in = Integer.parseInt(new String(input));
		if(in == output) {
			System.out.println(0);
			return;
		}
		visited[in] = true;
		queue.offer(input);
		int time = 0;
		while(!queue.isEmpty()) {
			time ++;
			int size = queue.size();
			for(int k = 0 ; k < size ; k++) {				
				char[] cur = queue.poll();
				//자릿수 
				for(int i = 0 ; i < 4 ; i ++) {
					for(int j = 0 ; j < 10 ; j++) {
						char[] tmp = Arrays.copyOf(cur, cur.length);
						if((i == 0 && j == 0)) continue;
						
						tmp[i] = (char) ((char) j + '0');
						
						int num = Integer.parseInt(new String(tmp));
						
						if(num == output) {
							System.out.println(time);
							queue.clear();
							return;
						}
						
						if(!visited[num] && primeList[num]) {
							visited[num] = true;
							queue.offer(tmp);
						}
					}
				}
			}
		}
		System.out.println("Impossible");
		return;
	}

	private static void makeList() {
		primeList = new boolean[10000];		
		Arrays.fill(primeList, true);
		primeList[0] = primeList[1] = false;
		
		for(int i = 2; i*i < 10000; i++){
        	// prime[j] 소수가 아닌 표시
			if(primeList[i]) {				
				for(int j = i*i ; j < 10000; j += i) {
					primeList[j] = false;                
				}
			}
                    
        }    
		
	}

}