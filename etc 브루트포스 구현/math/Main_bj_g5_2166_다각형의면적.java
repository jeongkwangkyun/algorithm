package b0220;

import java.io.*;
import java.util.*;

public class Main_bj_g5_2166_다각형의면적 {
	static int N;
	static Point[] points;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());
		points = new Point[N+1];
		for(int i = 1 ; i <= N ;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y);
		}
		
		long answer = 0;
		
		for(int i = 2 ; i < N ; i++) {
			answer += ccw(points[1], points[i], points[i+1]);
		}
		answer = Math.abs(answer);
		if(answer % 2 == 0) {
			System.out.println(answer/2 + ".0");
		}else {
			System.out.println(answer/2 + ".5");
		}
	}
	public static long ccw(Point p1, Point p2, Point p3) {
        //CCW 공식 (x1y2+x2y3+x3y1)−(y1x2+y2x3+y3x1)
        return ((p1.x*p2.y) + (p2.x*p3.y) + (p3.x * p1.y)) - ((p1.y*p2.x) + (p2.y*p3.x) + (p3.y*p1.x));
        
    }
	private static class Point{
		long x,y;
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
