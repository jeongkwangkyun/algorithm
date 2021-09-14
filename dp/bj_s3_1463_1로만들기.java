package a0914;
import java.io.*;
import java.util.*;

public class Main_bj_1463_1로만들기_서울_12반_정광균 {
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		if(n<=3) {
			if(n==1) {
				System.out.println(0);
			}else
			{
				System.out.println(1);
				
			}
			
		}
		
		else {
			int[] dp= new int[n+1];
			
			dp[0]=0;
			dp[1]=0;
			dp[2]=1;
			dp[3]=1;
			for(int i=4;i<=n;i++) {
				dp[i]=dp[i-1]+1;
				if(i%3==0) {
					dp[i]=Math.min(dp[i/3]+1, dp[i]);
				}
				if(i%2==0) {
					dp[i]=Math.min(dp[i],dp[i/2]+1);
					
				}
			}
			System.out.println(dp[n]);			
		}

	}
}