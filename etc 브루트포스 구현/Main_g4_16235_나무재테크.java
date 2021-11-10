import java.io.*;
import java.util.*;

class Tree implements Comparable<Tree>{
	int x,y,age,live;

	public Tree(int x, int y, int age) {
		super();
		this.x = x;
		this.y = y;
		this.age = age;
		this.live = live;
	}

	@Override
	public int compareTo(Tree o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.age, o.age);
	}
	
}

public class Main_g4_16235_나무재테크 {
	static int N,M,K;
	static int[][] map;
	static int[] dx = {0,-1,-1,-1,0,1,1,1};
	static int[] dy = {-1,-1,0, 1,1,1,0,-1};
	static PriorityQueue<Tree> tree = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0 ; i<N ; i ++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j<N ; j++ ) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i =  0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			tree.add(new Tree( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken(),1)));
		}
		
		for(int i = 0 ; i<K ; i ++) {
			// 봄 나이만큼 양분을 먹고 나이 +1 나이 어린애부터 양분 먹기
			spring();
			// 여름 죽은 나무들이 양분으로 바꾸기 /2
			
			// 가을 
			
		}
	}

}
