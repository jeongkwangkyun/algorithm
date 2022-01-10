package b0110;
import java.util.*;


public class PR_L2_카카오프렌즈컬러링북 {
	static boolean[][] visited;
    static int numberOfArea, maxSizeOfOneArea;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        
        visited = new boolean[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j <n ; j++){
                if(visited[i][j] == false){
                    bfs(i, j, picture, m, n);
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    private void bfs(int x, int y, int[][] map,int m, int n){
        Queue<int[]> queue = new LinkedList<>();
        
        numberOfArea += 1;
        visited[x][y] = true;
        queue.offer(new int[]{x ,y});
        int maxValue = 1 ;
        while(! queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(0> nx || nx >= m || 0 > ny || ny >= n || visited[nx][ny] == true) continue;
                if(map[x][y] != map[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                maxValue += 1;
            }
        }
        if(map[x][y] == 0) {
            numberOfArea -= 1;
            return;
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, maxValue);
    }
}