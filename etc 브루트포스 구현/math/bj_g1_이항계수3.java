package a0927;

import java.io.*;
import java.util.*;

public class bj_g1_이항계수3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int P=1000000007;
		long ans;
		ans=nCr(N,K,P);
		System.out.println(ans);
	}

	private static long nCr(int n, int r, int p) {
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
