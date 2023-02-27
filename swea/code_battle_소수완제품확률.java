package samsung_practice;

import java.util.Scanner;

public class code_battle_소수완제품확률 {
	static int[] prime = {2, 3, 5, 7, 11, 13, 17};
	static int NUM_OF_RUN = 18;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			double Pa, Pb;
			
			Pa = sc.nextDouble();
			Pb = sc.nextDouble();
			
			Pa = Pa / 100;
			Pb = Pb / 100;
			
			double mPa = 0.0;
			double mPb = 0.0;
			
			for (int i = 0 ; i < 7 ; ++i) {
				mPa += Master(Pa, prime[i]);
				mPb += Master(Pb, prime[i]);
			}
			// 1 - (1 - mPa) * (1 -mPb)
			double result = mPa + mPb - (mPa * mPb);
			
			if (result <= 0.0)
				System.out.println("#"+ test_case +" 0.000000");
			else 
				System.out.printf("#%d %.6f\n",test_case, result);
		}
	}

	private static double Master(double pa, int r) {
		// TODO Auto-generated method stub
		return Combination(NUM_OF_RUN, r) * Math.pow(pa, r) * Math.pow(1 - pa, NUM_OF_RUN -r);
		//return nCr(NUM_OF_RUN, r) * Power(pa, r) * Power(1 - pa, NUM_OF_RUN -r);
	}


	public static int Combination(int n, int r) {
		if(n == r || r == 0) 
			return 1; 
		else 
			return Combination(n - 1, r - 1) + Combination(n - 1, r); 
	}
}
