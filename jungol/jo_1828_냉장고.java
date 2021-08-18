package a0817;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_jo_1828_냉장고_서울_12반_정광균 {
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
            int value= Integer.compare(this.end, o.end);
            if(value != 0) return value; //종료시간이 다르면
             
            //종료시간이 같다면 시작시간이 빠른 순서로.
            return Integer.compare(this.start, o.start);
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
         
        Arrays.sort(meetings);
        Meeting list=meetings[0];
        int i=1;
        int cnt=1;
        while(i<n) {
            if(list.end<meetings[i].start) {
                list=meetings[i];
                cnt++;
            }
            i++;
        }
        System.out.println(cnt);
         
    }
}