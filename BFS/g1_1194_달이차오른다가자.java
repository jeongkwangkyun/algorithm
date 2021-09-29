package a0929;

import java.io.*;
import java.util.*;
class Node{
	int x,y,key;

	public Node(int x, int y, int key) {
		super();
		this.x = x;
		this.y = y;
		this.key = key;
	}
}
public class Main_bj_g1_1194_달이차오른다가자_서울_12반_정광균 {
	static char[][] board;
	static boolean[][][] visited;
	static Queue<Node> queue = new LinkedList<>();
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	 
	static int N,M, answer=-1;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		board = new char[N][M];
		visited=new boolean[N][M][1 << 6];
		
		for(int i=0 ; i<N ; i++) {
			String temp=br.readLine();
			for(int j=0 ; j<M ; j++) {
				board[i][j]=temp.charAt(j);
				if(board[i][j] == '0') {
					queue.offer(new Node(i,j,0));
					visited[i][j][0]=true;
				}
			}
		}
		
		int time=0;
		label:while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i =0 ; i<size ; i++) {
				Node node = queue.poll();
				for(int j=0 ; j<4 ; j++) {
					int nx=node.x + dx[j];
					int ny=node.y + dy[j];
					// 범위 핸들링, 해당 키를 보유한 상태에서 이미 방문한 곳 continue
					if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny][node.key] || board[nx][ny]=='#')
					{
						continue;						
					}
					// 출구
					if(board[nx][ny]=='1') {
						answer=time+1;
						break label;
					}
					
					//대문을 만났을때. 해당 키를 보유한 상태만 지나간다.
					if('A' <= board[nx][ny] && board[nx][ny]<='F') {
						//해당 키를 보유하고 있는 상황
						if((node.key & (1<< (board[nx][ny]- 'A' ))) > 0) {
							visited[nx][ny][node.key]=true;
							queue.offer(new Node(nx, ny, node.key));
						}
						continue;
					}
					// 키를 만났을 때. 현재 가지고 있는 키에 or 연산
					if('a'<= board[nx][ny] && board[nx][ny] <='f') {
						int key=node.key;
						key = key | (1 << (board[nx][ny] - 'a'));
						visited[nx][ny][key]=true;
						queue.offer(new Node(nx , ny, key));
						continue;
					}
					// 빈곳
					visited[nx][ny][node.key]=true;
					queue.offer(new Node(nx, ny, node.key));
				}
			}
			time++;
		}
		System.out.println(answer);
	}
}
