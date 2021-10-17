import java.io.*;
import java.util.*;

class hash implements Comparable<hash>{
	int num,count;

	public hash(int key, int value) {
		super();
		this.num = key;
		this.count = value;
	}

	@Override
	public int compareTo(hash o) {
		// TODO Auto-generated method stub
		// 갯수가 같으면 숫자가 낮은 num이 먼저 정렬되도록 
		if(this.count==o.count) {
			return Integer.compare(this.num, o.num);
		}
		// count가 오름차순 
		return Integer.compare(this.count, o.count);
	}
	
}
public class Main_bj_g4_17140_이차원배열과연산 {
	static int r,c,k, x_idx, y_idx;
	static int[][] map;
	static List<hash> arr;
	// hash에 num값이 있는지 탐색하기 위해서 
	static List<Integer> check;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		map = new int[100][100];
		x_idx =2;
		y_idx =2;
		
		for(int i=0; i<=2 ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0 ; j<=2 ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(map[r][c]==k) {
			System.out.println(0);
		}
		else {
			
			for(int time=1 ; time<=100 ; time++) {
				if(x_idx>= y_idx) {
					sorting_r();
				}else {
					sorting_c();
				}
				
				
				if(map[r][c]==k) {
					System.out.println(time);
					break;
				}
				if(time==100) {
					System.out.println(-1);
					break;
				}
			}
			
		}
	}
	// C 연산 과정 
	private static void sorting_c() {
		// TODO Auto-generated method stub
		int max_x = 0;
		for(int i=0 ; i<=y_idx ; i++) {
			arr = new ArrayList<>();
			check = new ArrayList<>();
			for(int j=0 ; j<=x_idx ; j++) {
				if(map[j][i]==0) continue;
				// 있는경우
				if(check.contains(map[j][i])) {
					if(map[j][i]==0) continue;
					for(int k=0 ; k<= x_idx ; k++) {
						if(arr.get(k).num == map[j][i]) {
							arr.get(k).count += 1;
							break;
						}
					}
				}
				// 없는경우
				
				else {
					check.add(map[j][i]);
					arr.add(new hash(map[j][i], 1));
				}
				
			}
			Collections.sort(arr);
			for(int k=0 ; k<arr.size() ; k++) {
				map[k*2][i] = arr.get(k).num;
				map[k*2+1][i] = arr.get(k).count;
			}
			max_x = Math.max(arr.size()*2, max_x);
			max_x = Math.max(max_x, x_idx);
			if(max_x>=100) max_x=100;
			for(int k=arr.size()*2 ; k<=max_x ; k++) {
				map[k][i]=0;
			}
		}
		x_idx = max_x;
	}
	// R연산 과정 
	private static void sorting_r() {
		// TODO Auto-generated method stub
		int max_y = 0;
		for(int i=0 ; i<=x_idx ; i++) {
			arr = new ArrayList<>();
			check = new ArrayList<>();
			for(int j=0 ; j<=y_idx ; j++) {
				if(map[i][j]==0) continue;
				// 있는경우 count +1 
				if(check.contains(map[i][j])) {
					for(int k = 0 ; k<=y_idx ; k++) {
						if(arr.get(k).num == map[i][j]) {
							arr.get(k).count+=1; 
							break;
						}
					}
				}
				//없는 경우 arr에 새로 값 할당 
				else {
					check.add(map[i][j]);
					arr.add(new hash(map[i][j],1));
				}
			}
			Collections.sort(arr);
			//map 에 정렬된 값 넣어주기 
			for(int k=0 ; k<arr.size() ; k++) {
				
				map[i][k*2] = arr.get(k).num;
				map[i][2*k+1] = arr.get(k).count;
			}
			
			max_y = Math.max(arr.size()*2, max_y);
			max_y = Math.max(max_y, y_idx);
			if(max_y>=100) max_y=100;
			for(int k=arr.size()*2 ; k<=max_y ; k++) {
				map[i][k]=0;
			}
		}
		y_idx = max_y;
		
	}
}
