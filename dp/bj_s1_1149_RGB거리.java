package a0914;
import java.io.*;
import java.util.*;

// dp
// weights에 2차원배열 값을 입력받고 
// weights에 red,blue,green 3가지 경우로 나눠서 원래 값에서
// red 일 경우 weights[i-1]에 blue와 green 중 min 값을 더하
public class Main_bj_s1_1149_RGB거리_서울_12반_정광균 {
	//paint 값 배열 
	static int[][] weights;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		
		weights= new int[N][3];
		
		for(int i=0 ; i<N; i++) {
			for(int j=0 ; j<3; j++) {
				weights[i][j] = sc.nextInt();
			}
		}
		// 기존 값에서 다른 컬러의 최솟값 더해주기 
		for(int i=1 ; i<N ; i++) {
			weights[i][0] += Math.min(weights[i-1][1],weights[i-1][2]);
			weights[i][1] += Math.min(weights[i-1][0],weights[i-1][2]);
			weights[i][2] += Math.min(weights[i-1][0],weights[i-1][1]);
		}
		Arrays.sort(weights[N-1]);
		System.out.println(weights[N-1][0]);

	}
	
}