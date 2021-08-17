package a0812;
import java.io.*;
import java.util.*;

public class Main_bj_b2_백설공주와일곱난쟁이_3040_서울_12반_정광균 {
	static int[] arr=new int[9];
	static int[] numbers=new int[7];
	static boolean[] check=new boolean[9];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_b2_3040.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=0; i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		combination(0,0,0);
		System.out.println(sb);
	}

	private static void combination(int cnt,int start,int sum) {
		if(cnt==7) {
			if(sum==100) {
				for(int i=0;i<7;i++) {
					sb.append(numbers[i]).append("\n");
				}
			}	
			return;
		}
		for(int i=start ;i<9 ;i++) {
			numbers[cnt]=arr[i];
			combination(cnt+1,i+1,sum+arr[i]);
		}

	}
}

