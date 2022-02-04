package b0204;

import java.util.*;
public class PR_L2_방문길이 {
	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
	}
	public static int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        int[][] map = new int[11][11];
        // 위 아래 오른 왼 
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Map<String, String> hashMap = new HashMap<>();
        for(int i = 0 ; i < dirs.length(); i++){
            char tmp = dirs.charAt(i);
            int dir = -1;
            if(tmp == 'U'){
                dir = 0;
            }
            else if(tmp == 'D'){
                dir = 1;
            }
            else if(tmp == 'R'){
                dir = 2;
            }
            else if(tmp == 'L'){
                dir = 3;
            }
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(0 > nx || nx >= 11 || 0 > ny || ny >= 11) continue;
            System.out.println("x :"+x+"||y:"+y+"||nx:"+nx+"||ny:"+ny);
//            hashMap.put(new int[] {x,y}, new int[] {nx,ny});
            hashMap.put(Integer.toString(x)+Integer.toString(nx), Integer.toString(y)+Integer.toString(ny));
            hashMap.put(Integer.toString(y)+Integer.toString(ny), Integer.toString(x)+Integer.toString(nx));
//            hashMap.put(new int[]{nx,ny}, new int[]{x, y});
            
            System.out.println(hashMap.size()/2);
            x = nx;
            y = ny;
        }
        return hashMap.size()/2;
    }

}
