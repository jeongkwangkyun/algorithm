package a0819;

import java.io.*;
import java.util.*;

class customer{
	int x;
	int y;
	public customer(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
public class d5_최적경로_1247 {
	static int home_x,home_y,current_x,current_y,company_x,company_y, n;
	static boolean[] isSelected;
	static ArrayList<customer> customer_arr; 
	static int[] numbers;
	static int min_val;
	public static void main(String[] args) throws Exception{
		
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_d5_1247.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=tc;t++) {
			min_val=Integer.MAX_VALUE;
			n=Integer.parseInt(br.readLine());
			numbers=new int[n];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			isSelected=new boolean[n];
			customer_arr=new ArrayList<customer>();
			company_x=current_x=Integer.parseInt(st.nextToken());
			company_y=current_y=Integer.parseInt(st.nextToken());
			
			home_x=Integer.parseInt(st.nextToken());
			home_y=Integer.parseInt(st.nextToken());
 			for(int i=0;i<n;i++) {
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				customer_arr.add(new customer(x,y));
			}
			permutation(0);
			sb.append("#").append(t).append(" ").append(min_val).append("\n");
		}
		System.out.println(sb);
	}
	private static void permutation(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==n) {
			sum();
			current_x=company_x;
			current_y=company_y;
			return;
		}
		for(int i=0;i<n;i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i]=true;

			permutation(cnt+1);
			isSelected[i] =false;
		}
	}
	private static void sum() {
		// TODO Auto-generated method stub
		int cnt=0;
		
		for(int i=0;i<n;i++) {
			if(cnt>min_val) return;
			cnt+=Math.abs(current_x-customer_arr.get(numbers[i]).x) +Math.abs(current_y-customer_arr.get(numbers[i]).y);
			current_x=customer_arr.get(numbers[i]).x;
			current_y=customer_arr.get(numbers[i]).y;
		}
		cnt+=Math.abs(current_x-home_x)+Math.abs(current_y-home_y);
		min_val=Math.min(cnt, min_val);
	}

}
