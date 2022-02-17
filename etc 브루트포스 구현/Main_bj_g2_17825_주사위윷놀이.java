package b0217;

import java.io.*;
import java.util.*;

public class Main_bj_g2_17825_주사위윷놀이 {
	static int[] dice = new int[10];
	static int[] order = new int[10];
	static Node[] horse = new Node[4];
	static Node start;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < 10 ; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		init(); //윷놀이 설정 
		permutation(0);
		System.out.println(answer);
	}
	
	private static void permutation(int cnt) {
		if(cnt == 10) {
			answer = Math.max(answer, gameStart());
			return;
		}
		
		for(int i = 0 ; i < 4; i++) {
			order[cnt] = i;
			permutation(cnt+1);
		}
	}

	private static int gameStart() {
		Arrays.fill(horse, start); // 말을 시작점
		
		int score = 0;
		for(int i = 0 ; i < 10 ; i++) {
			Node cur = horse[order[i]]; // 순열 순으로 말들 이동
			cur.isEmpty = true; // 이동하기 때문에 현재 칸 비워주기 
			
			for(int j = 1 ; j <= dice[i] ; j++) { // 주사위에 나온 수치만큼 이동
				if(j == 1 && cur.fastPath != null) {// 시작 위치가 파란색 칸이라면 
					cur = cur.fastPath; // 지름 길 이동 
				}else {
					cur = cur.next; // 빨간색 이동 
				}
			}
			
			horse[order[i]] = cur; // 이동 후, 말 위치 설정
			// 이동을 마친칸에 다른 말이 있다면, 취소 
			if(!cur.isEmpty && !cur.isFinish) { 
				score = 0; // 무효처리 
				break;
			}else {
				cur.isEmpty = false; // 말이 존재 표시
				score += cur.score;
			}
			
 		}
		
		for(int i = 0 ; i < 4 ; i++) {
			horse[i].isEmpty = true;
		}
		
		return score;
	}

	private static void init() {
		start = new Node(0); // 시작지점 
		
		Node temp = start;
		for(int i = 2 ; i <= 40 ; i += 2) {
			temp = temp.addNext(i); // 윷놀이 바깥쪽 경로 
		}
		
		Node end = temp.addNext(0); // 도착 지점. (도착 지점의 스코어는 0)
		end.isFinish = true;
		end.next = end;
		
		Node crossroads = new Node(25); // 가운데 교차점 
		
		// 교차점 25, 30, 35, 40
		temp = crossroads.addNext(30);
		temp = temp.addNext(35);
		temp.next = Node.getNode(start, 40);
		
		// 10, 13, 16, 19, 25
		temp = Node.getNode(start, 10);
		temp = temp.fastPath = new Node(13);
		temp = temp.addNext(16);
		temp = temp.addNext(19);
		temp.next = crossroads;
		
		// 20,22, 24, 25
		temp = Node.getNode(start, 20);
		temp = temp.fastPath = new Node(22);
		temp = temp.addNext(24);
		temp.next = crossroads;
		
		// 30, 28, 27, 26, 25
		temp = Node.getNode(start, 30);
		temp = temp.fastPath = new Node(28);
		temp = temp.addNext(27);
		temp = temp.addNext(26);
		temp.next = crossroads;
	}

	private static class Node{
		int score;
		boolean isEmpty;
		boolean isFinish;
		Node next;
		Node fastPath;
		
		public Node(int score) {
			this.score = score;
			this.isEmpty = true;
		}
		// 노드 연결, 연결 리스트 구조로 
		public Node addNext(int score) {
			Node nextNode = new Node(score);
			this.next = nextNode;
			return nextNode;
		}
		//노드 찾기(지름길 놓는 지점을 찾기 위한 함수 )
		public static Node getNode(Node start, int target) {
			Node temp = start;
			while(true) {
				if(temp == null) return null;
				if(temp.score == target) return temp;
				temp = temp.next;
			}
		}
	}
}
