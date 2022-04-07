package b0407;

import java.io.*;
import java.util.*;

public class Main_bj_g5_5430_AC {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Loop : for(int t = 0 ; t < TC ; t++) {
			String cmds = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			input = input.substring(1, input.length()-1);
			String[] temp = input.split(",");
			//true 면 앞에서 false면 뒤에서 
			boolean flag = true;
			ArrayDeque<String> deque = new ArrayDeque<>();
			for(int i = 0 ; i < temp.length ; i++) {
				if(!temp[i].equals("")) deque.add(temp[i]);
			}
			
			for(int i = 0 ; i < cmds.length() ; i++) {
				char cmd = cmds.charAt(i);
				
				if(cmd == 'R') {
					flag = !flag;
				}
				else if(cmd == 'D') {
					if(deque.size() == 0) {
						sb.append("error").append("\n");
						continue Loop;
					}
					else {
						if(flag) deque.pollFirst();
						else deque.pollLast();
					}
				}
			}
			sb.append("[");
			while(!deque.isEmpty()){
				if(flag) {					
					sb.append(deque.pop());
				}
				else {
					sb.append(deque.pollLast());
				}
				
				if(deque.isEmpty()) continue;
				sb.append(",");
			}
			sb.append("]").append("\n");
		}
		System.out.println(sb);		
	}
}