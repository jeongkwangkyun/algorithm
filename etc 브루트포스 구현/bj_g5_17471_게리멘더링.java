package a1006;

import java.io.*;
import java.util.*;

// 도시번호와 도시 인구수
class Position{
	int x;
	int pepleNum;
	public Position(int x, int pepleNum) {
		super();
		this.x = x;
		this.pepleNum = pepleNum;
	}
}

// 조합과 bfs 문제
public class Main {
	static int N;
	static Position[] positions;
	static ArrayList<ArrayList<Integer>> list;
	static int ans=Integer.MAX_VALUE;
	
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		positions = new Position[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// position에 도시 번호와 인구수 넣기
		for(int i=1 ; i <= N; i ++) {
			int num=Integer.parseInt(st.nextToken());
			positions[i] = new Position(i, num);
		}
		// 연결리스트 안에 정수를 담는 연결리스트 넣기
		list = new ArrayList<>();
		//0은 무시하고 인덱스 1부터 시작
		for(int i=0 ; i<=N ;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int temp = Integer.parseInt(st.nextToken());
			for(int j=0 ; j<temp ; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		ArrayList<Integer> A = new ArrayList<>();
		// 조합,, A에서 선택되지 않은 것이 B 집합이기때문에 , 6C2 와 6C4가 같다..
		for(int i=1 ; i <= N/2 ; i++) {
			//1 개부터 ~ N/2까진데,,,,, A가 1개면 나머지가 N-1개 
			comb(1,N,i,A);
		}
			
		if(ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
	}

	private static void comb(int start, int n, int cnt, ArrayList<Integer> A) {
		if(cnt==0) {
			gerrymandering(A);
			return;
		}
		
		for(int i=start ; i<=n ; i++) {
			A.add(i);
			comb(i+1,n,cnt-1,A);
			A.remove(A.size()-1);
		}
	}

	private static void gerrymandering(ArrayList<Integer> A) {
		// A에 해당하는 집합 연결성 확인, 하나만 넣어줘서 나머지 확인
		if(!isConnect(positions[A.get(0)].x, A, A.size())) {
			return;
		}
		// B집합
		ArrayList<Integer> B = new ArrayList<>();
		// A가 가지고 있지 않다면 B에 삽입
		for(int i=1; i<= N ;i++) {
			if(A.contains(i)) {
				continue;
			}
			B.add(i);
		}
		// B의 연결성 확인
		if(!isConnect(positions[B.get(0)].x, B, B.size())) {
			return;
		}
		// A와 B의 도시 인구수 차이 계산
		int resultA=0;
		
		for(int i=0 ; i<A.size() ; i++) {
			resultA += positions[A.get(i)].pepleNum;
		}
		
		int resultB = 0;

		for(int i=0 ; i < B.size() ; i++) {
			resultB += positions[B.get(i)].pepleNum;
		}
		
		int result = Math.abs(resultA-resultB);
		ans=Math.min(ans, result);
	}

	private static boolean isConnect(int num, ArrayList<Integer> arr, int size) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[N+1];
		// 받아온 한가지 방문처리하고 큐에 삽입
		visited[num] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(num);
		
		int count =1;
		while(!q.isEmpty()) {	
			int start= q.poll();
			// idx에 해당하는거 A or B가 가지고 있는지 판단
			for(int i : list.get(start)) {
				if(!visited[i] && arr.contains(i)) {
					visited[i] = true;
					count++;
					q.offer(i);
				}
			}
		}
		if(count == size) {
			return true;
		}
		return false;
		
	}

}
