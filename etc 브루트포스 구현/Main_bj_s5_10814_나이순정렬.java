package b0424;

import java.io.*;
import java.util.*;

public class Main_bj_s5_10814_나이순정렬 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Node> people = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people.add(new Node(i, age, name));
		}
		Collections.sort(people);
		
		for(int i = 0 ; i < N ; i++) {
			System.out.println(people.get(i).age + " " + people.get(i).name);
		}
	}
	
	private static class Node implements Comparable<Node>{
		int idx, age;
		String name;
		public Node (int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
		
		public int compareTo(Node o) {
			if(o.age == this.age) {
				return this.idx - o.idx;
			}
			
			return this.age - o.age;
		}
	}

}
