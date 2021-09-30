package a0929;

import java.io.*;
import java.util.*;

class Edge{
	int height;

	public Edge(int height) {
		super();
		this.height = height;
	}
	
}
public class Solution{
	
	static Queue<Integer> q_small=new LinkedList<Integer>();
	static Queue<Integer> q_big=new LinkedList<Integer>();
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t=Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=t ; tc++) {
			int cnt=0;
			int N=Integer.parseInt(br.readLine());
			int M=Integer.parseInt(br.readLine());
			
			List<Edge>[] small = new ArrayList[N];
			List<Edge>[] big = new ArrayList[N];
			
			for(int i=0;i<N;i++) {
				small[i] = new ArrayList<Edge>();
				big[i] = new ArrayList<Edge>();
			}
			for(int i=0; i<M; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int a=Integer.parseInt(st.nextToken())-1;
				int b=Integer.parseInt(st.nextToken())-1;
				small[b].add(new Edge(a));
				big[a].add(new Edge(b));
			}
			
			label : for(int i=0; i<N; i++) {
				boolean[] check=new boolean[N];
				
				check[i]=true;
				for(int j=0 ; j<small[i].size();j++) {
					q_small.offer(small[i].get(j).height);
					check[small[i].get(j).height]=true;
					
				}
				for(int j=0 ; j<big[i].size();j++) {
					q_big.offer(big[i].get(j).height);
					check[big[i].get(j).height]=true;
					
				}
				while(!q_small.isEmpty()) {
					int cur=q_small.poll();
					for(int k=0; k<small[cur].size() ; k++) {
						int next=small[cur].get(k).height;
						if(check[next] == false) {
							check[next]=true;
							q_small.offer(next);
							
							
						}
					}
				}
				while(!q_big.isEmpty()) {
					int cur=q_big.poll();
					for(int k=0; k<big[cur].size() ; k++) {
						int next=big[cur].get(k).height;
						if(check[next] == false) {
							check[next]=true;
							q_big.offer(next);
							
						}
					}
				}
				
				for(int j=0;j<N ; j++) {
					if(check[j]==false) continue label;
				}
				cnt+=1;
				
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
		
		
	}

}
