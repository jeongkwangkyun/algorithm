package a0817;
import java.io.*;
import java.util.*;

public class Main_bj_b1_설탕배달_2839_서울_12반_정광균 {
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("res/input_b1_17135.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total=0;
		
		int bag=Integer.parseInt(br.readLine());
		int tmp=bag/5;
		
		int a=bag<5?bag:bag%5;
		while(true) {
			if(a%3==0) {
				total+=(tmp+a/3);
				break;
			}
			else if(tmp==0) {
				total=-1;
				break;
			}
			else {
				tmp-=1;
				a+=5;
			}
		}
		System.out.println(total);
	}
}
