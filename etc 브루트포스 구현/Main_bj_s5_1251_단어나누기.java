package b0301;

import java.io.*;
import java.util.*;


public class Main_bj_s5_1251_단어나누기 {
	static String word;
	static TreeSet<String> treeSet = new TreeSet<String>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine();
		
		for(int i = 0 ; i < word.length() ; i++) {
			for(int j = i+1 ; j < word.length() ; j++) {
				for(int k = j+1 ; k< word.length(); k++) {
					String temp = "";
					
					//뒤집기
					temp += copy(0, j);
					
					temp += copy(j,k);
					
					temp += copy(k, word.length());
					
					//합치기 
					treeSet.add(temp);
				}
			}
		}
		
		System.out.println(treeSet.first());
	}
	private static String copy(int i, int j) {
		StringBuffer temp = new StringBuffer();
		
		for(int start = i ; start < j ; start++) {
			temp.append(word.charAt(start));
		}
		
		String copy = temp.reverse().toString();
		return copy;
		
	}

}
