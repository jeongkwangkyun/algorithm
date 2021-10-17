import java.io.*;
import java.util.*;
public class Main_11723_집합 {
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		check = new boolean[21];
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<t ; i++) {
			String order = br.readLine();
			if(order.contains(" ")) {
				String[] tmp = order.split(" ");
				order=tmp[0];
				int x = Integer.parseInt(tmp[1]);
				if(order.equals("add")) {
					check[x]=true;
				}else if(order.equals("remove")) {
					check[x]=false;
				}else if(order.equals("check")) {
					if(check[x]==true) sb.append("1").append("\n");
					else sb.append("0").append("\n");
				}else if(order.equals("toggle")) {
					if(check[x]==true) check[x]=false;
					else check[x]=true;
				}
			}
			
			else {
				if(order.equals("all")) {
					Arrays.fill(check, true);
				}else check = new boolean[21];
			}
			
		}
		System.out.println(sb);
		br.close();
	}
}
