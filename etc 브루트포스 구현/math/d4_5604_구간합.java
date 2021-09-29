package a0928;

import java.io.*;
import java.util.*;

public class d4_5604_구간합 {
	static long ans;
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		StringBuilder sb= new StringBuilder();

		for(int tc=1; tc<=t; tc++){
			long A=sc.nextLong();//8
			long B=sc.nextLong();//21
			ans=0;
			long mul=1;
			while(A<=B){
				while(B%10!=9 && A<=B){
					calc(B,mul);//(21,1)=3 (20,1)=5 //(1,10)=77
					B--;
				}//19 0
				if(A>B) break;//8>19 1>0        
				while(A%10!=0 && A<=B){
					calc(A,mul);//(8,1)=13 (9,1)=22
					A++;
				}//10
				A/=10; //A=10->1
				B/=10; //B=19->1
				long m=(B-A+1)*mul; //1=(1-1+1)*1
				for(int i=0; i<10; i++) ans+=m*i; //45=67
				mul*=10; //10
			}
			System.out.println("#"+tc+" "+ans);
		}

	}
	private static void calc(long n, long t) {
		// TODO Auto-generated method stub
		while(n>0) {
			ans+=(n%10)*t;
			n /=10;
		}
	}
}
