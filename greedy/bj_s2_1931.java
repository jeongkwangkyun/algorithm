package a0817;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bj_s2_1931 {
	static int cnt;
	
	static class Meeting implements Comparable<Meeting>{
		int start,end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
//			int value= this.end-o.end;
//			if(value != 0) return value;
//			
//			return this.start-o.start;
			int value= Integer.compare(this.end, o.end);
			if(value != 0) return value; //종료시간이 다르면
			
			//종료시간이 같다면 시작시간이 빠른 순서로.
			return Integer.compare(this.start, o.start);
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Meeting[] meetings=new Meeting[n];
		for(int i=0;i<n;i++) {
			meetings[i]=new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		for (Meeting meeting : getSchedule(meetings)) {
			cnt+=1;
		}
		System.out.println(cnt);
	}
	
	static ArrayList<Meeting> getSchedule(Meeting[] meetings){
		ArrayList<Meeting> list= new ArrayList<Meeting>();
		Arrays.sort(meetings);
		list.add(meetings[0]);
		
		for(int i=1,size=meetings.length;i<size;i++) {
			if(list.get(list.size()-1).end<=meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		return list;
	}
}
