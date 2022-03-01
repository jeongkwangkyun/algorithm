package b0301;

import java.io.*;
import java.util.*;

public class Main_bj_s5_2993_세부분 {
	static String word;
	static TreeSet<String> treeSet = new TreeSet<String>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine();
		
		for(int i = 0 ; i < word.length() ; i++) {
			for(int j = i+1 ; j < word.length() ; j++) {
				for(int k = j+1 ; k < word.length() ; k++) {
					String temp = "";
					temp += copy(0,j);
					temp += copy(j,k);
					temp += copy(k,word.length());
					treeSet.add(temp);
				}
			}
		}
		System.out.println(treeSet.first());

	}
	private static String copy(int start, int last) {
		if(last - start == 1) return word.substring(start, start+1);
		char[] arr = new char[last-start];
		// 2~9
		// start~last
		// 0~7
		// 
		int size = arr.length;
		for(int i = 0 ; i < last - start ; i++) {
			int front = i+start;
			int rear = last-i-1;
			// 홀수 
			if(size % 2 == 1&& i == size/2) {
				arr[i] = word.charAt(front);
				break;
			}
			else if(size % 2 == 0 && i == size/2) {
				arr[i] = word.charAt(rear);
				arr[size - i - 1] = word.charAt(front);


				break;
			}
			arr[i] = word.charAt(rear);
			arr[size - i - 1] = word.charAt(front);
		}


		return new String(arr);
	}
}
