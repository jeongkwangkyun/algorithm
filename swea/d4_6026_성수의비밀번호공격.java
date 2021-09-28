package a0928;

import java.io.*;
import java.util.*;

public class Solution_d4_6026_성수의비밀번호공격_서울_12반_정광균2 {
	static int  N,M;
	static long P=1000000007;
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=t;tc++) {
			st= new StringTokenizer(br.readLine()," ");
			M=Integer.parseInt(st.nextToken()); //2
			N=Integer.parseInt(st.nextToken()); // 5
			long result=surjection(M,N,P);
			System.out.printf("#%d %d\n", tc,result>=0? result:(result+P));
		}
		br.close();
	}
	private static long surjection(int m, int n, long p) {
		// TODO Auto-generated method stub
		long tot=0L;
		for (int i = 0; i <m ; i++) {
			long t1 = (i%2==0)?1:-1;
			long t2= nCr(m,i,p)%p;
			long t3=power(m-i,n,p)%p;
			tot=(tot + (t1*t2*t3)%p)%p;
		}
		return tot%p;
	}
	//nCr
	private static long nCr(int n, int r, long p) {
		// TODO Auto-generated method stub
		if(r == 0) return 1L;

		long[] fac = new long[n+1];
		fac[0] =1 ;

		for(int i=1 ; i<= n ; i++) {
			fac[i] = fac[i-1] * i % p ;

		}
		return (fac[n] * power(fac[r], p-2, p) % p*power(fac[n-r], p-2, p) %p) %p;
	}

	private static long power(long x, long y, long p) {
		long res = 1L;
		x = x%p;

		while(y>0) {
			if(y%2 == 1) res =(res * x) %p;

			y = y>>1;
		x= (x*x) %p;
		}
		return res;

	}
}
