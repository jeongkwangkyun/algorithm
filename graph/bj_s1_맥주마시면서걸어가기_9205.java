package a0916;

import java.io.*;
import java.util.*;

class Edge{
	int x;
	int y;
	public Edge(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Main_bj_s1_맥주마시면서걸어가기_9205_서울_12반_정광균 {
    
    static int N;
    static int D[][];
    static List<Edge> list;
    
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tc=0;tc<t;tc++) {
        	N=sc.nextInt();
        	//n개 편의점, 집, 공연장 총 n+2
        	D=new int[N+2][N+2];
        	// list에 모든장소 좌표 저장 
        	list=new ArrayList<Edge>();
        	for(int i=0; i<N+2; i++){
    			list.add(new Edge(sc.nextInt(),sc.nextInt()));
        	}
        	// i=j일때 따져줄필요 없
        	for(int i=0;i<N+2;i++) {
        		for(int j=i+1;j<N+2;j++) {
        			//p1 p2 거리 절댓값으로 계산 
        			Edge p1=list.get(i) , p2=list.get(j);
        			D[i][j]=Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);		
        			// 1000초과 한다면 거리에 도달할 수 없으므로 -1
        			if(D[i][j]>1000) {
        				D[i][j]=-1;
        				D[j][i]=-1;
        			}
        		}
        	}
        	
        	for(int k=0; k<N+2; k++){
        		for(int i=0; i<N+2; i++){
        			if(i==k) continue;
        			for(int j=0; j<N+2; j++){
        				if(j==k || i==j) continue;
        				//1000보다 큰 곳은 continue
        				if(D[i][k]==-1 || D[k][j]==-1) continue;
        				// 1000보다 작다면 연결 
        				D[i][j]=1;
        			}
        		}
        	}
        	// 집 위치 , 0,N+1 고
        	if(D[0][N+1]!=-1) {
        		System.out.println("happy");
        	}else {
        		System.out.println("sad");
        	}	
        }
        sc.close();
    }
}
