package a0805;
import java.util.*;

public class S1_SubSetTest {

	static int N, totalCnt;
	static int[] input;
	static boolean[] isSelected;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		totalCnt = 0 ;
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
			
		}
		generateSubSet(0);
		System.out.println("경우의 수"+totalCnt);
	}
	
	private static void generateSubSet(int cnt) {
		if(cnt ==N) {
			// 부분집합 완성
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i]?input[i]:"X")+" ");
			}
			System.out.println();
			return;
		}
		
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt]= false;
		generateSubSet(cnt+1);
	}
	
}
