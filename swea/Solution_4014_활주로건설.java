package a1006;
import java.io.*;
import java.util.*;

public class Solution_4014_활주로건설 {
	static int N, X,total;
	static boolean[][] check;
	static int[][] map,map2;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1 ; t<=tc ; t++) {
			total=0;

			st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int[][] map2 = new int[N][N];

			for(int i=0 ; i<N ; i++) {
				st= new StringTokenizer(br.readLine()," ");
				for(int j=0 ; j<N ; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N ; j++) {
					map2[i][j]=map[j][i];
				}
			}

			// 가로
			check=new boolean[N][N];
			find(map);
			// 세로
			check=new boolean[N][N];
			find(map2);
		
			System.out.println("#"+t+" "+total);
		}
	}
	private static void find(int[][] map) {
		// TODO Auto-generated method stub
		int idx=0;
		for(int i=0 ; i<N; i++) {
			idx=0;
			label : while(true) {
				if(idx==N-1) {
					total++;
					break;
				}
				if(map[i][idx]== map[i][idx+1]) {
					idx++;
				}
				//오르막
				else if(map[i][idx]-1 == map[i][idx+1]) {
					for(int s=1 ; s<=X ; s++) {
						if((idx+s)<N && map[i][idx]-1 == map[i][idx+s] && check[i][idx+s]==false) {
							check[i][idx+s]=true;
						}
						else {
							break label;
						}
					}

					idx = idx+X;
				}
				//내리막
				else if(map[i][idx]+1 == map[i][idx+1]) {
					for(int s=0 ; s<X ; s++) {
						if((idx-s)>= 0 && map[i][idx+1]-1 == map[i][idx-s] && check[i][idx-s]==false) {
							check[i][idx-s]=true;
						}
						else {
							break label;
						}
					}
					idx++;
				}
				else {
					break;
				}
			}
		}
	}


}
