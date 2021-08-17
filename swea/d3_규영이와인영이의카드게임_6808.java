package a0812;
import java.io.*;
import java.util.*;

public class Solution_d3_규영이와인영이의카드게임_6808_서울_12반_정광균 {
	static int[] my_card, your_card,current_card;
	static boolean[] isSelected;
	static int temp_win,temp_lose;
	static int win,lose;

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_d3_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=t;tc++) {
			my_card=new int[9];
			your_card=new int[9];
			isSelected=new boolean[9];
			current_card=new int[9];
			st=new StringTokenizer(br.readLine());
			boolean[] check=new boolean[18];
			for(int i=0;i<9;i++) {
				my_card[i]=Integer.parseInt(st.nextToken());
				check[my_card[i]-1]=true;
			}
			int idx=0;
			for(int i=0;i<18;i++) {
				if(check[i]==false) {
					your_card[idx]=i+1;
					idx++;
				}
			}
			permutation(0,0,0);
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
			win=0;
			lose=0;
		}

		System.out.println(sb);
	}

//	private static void permutation(int cnt) {
//		if(cnt==9) {
//			for(int i=0;i<9;i++) {
//				if(my_card[i]<current_card[i]) {
//					temp_lose+=current_card[i]+my_card[i];				}
//				else if(my_card[i]>current_card[i]) {
//					temp_win+=current_card[i]+my_card[i];
//				}
//			}
//			if(temp_win>temp_lose) {
//				win+=1;
//			}
//			else if(temp_win<temp_lose) {
//				lose+=1;
//			}
//			temp_win=0;
//			temp_lose=0;
//			return;
//		}
//
//		for (int i = 0; i < 9; i++) {
//			if(isSelected[i]) continue; 
//			current_card[cnt] =your_card[i];
//			isSelected[i]=true;
//			permutation(cnt+1);
//			isSelected[i]=false;
//
//		}
//	}
	// 파라미터를 이기는 경우 지는경우를 따져서 넘기기
	private static void permutation(int cnt,int gyusum, int yinsum) {
		if(cnt==9) {
			if(gyusum>yinsum) win++;
			else if(gyusum<yinsum) lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if(isSelected[i]) continue; 
			
			isSelected[i]=true;
			if(my_card[cnt]>your_card[i]) {
				permutation(cnt+1,gyusum+my_card[cnt]+your_card[i],yinsum);
			}
			else if(my_card[cnt]<your_card[i]) {
				permutation(cnt+1, gyusum, yinsum+my_card[cnt]+your_card[i]);
			}
			
			isSelected[i]=false;

		}
	}
}
