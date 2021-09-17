package a0916;

import java.io.*;
import java.util.*;

public class 사람네트워크2_1263 {
    static final int INF=987654321;//Integer.MAX_VALUE/2;
    static int N,D[][];
    
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int tc=1;tc<=t;tc++) {
        	N=sc.nextInt();
        	//graph는 아니고 dp배열
        	D=new int[N][N];
        	int min=Integer.MAX_VALUE;
        	for(int i=0; i<N; i++){
        		for(int j=0; j<N; j++){
        			D[i][j]=sc.nextInt();
        			if(i!=j && D[i][j]==0) D[i][j]=INF;
        		}
        	}
        	
        	for(int k=0; k<N; k++){
        		for(int i=0; i<N; i++){
        			for(int j=0; j<N; j++){
        				//if(D[i][j]>D[i][k]+D[k][j]){
        				//   D[i][j]=D[i][k]+D[k][j];
        				//}
        				D[i][j]=Math.min(D[i][j],D[i][k]+D[k][j]);
        			}
        		}
        	}
        	for(int i=0;i<N;i++) {
        		int tmp=0;
        		for(int j=0;j<N;j++) {
        			if(D[i][j]!=INF) {
        				tmp+=D[i][j];
        			}
        		}
        		min=Math.min(min, tmp);
        	}
        	sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        
        System.out.println(sb);
        sc.close();
    }
}
