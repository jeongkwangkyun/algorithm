# 일반적인 bfs 문제인데 나이트 갈 수 있는 방향을 고려해주고 graph 해당하는 값을 +1 씩 더해준다
from collections import deque
import sys
input=sys.stdin.readline
night=[[2,1],[2,-1],[-2,1],[-2,-1],[1,2],[1,-2],[-1,2],[-1,-2]]
TC=int(input())

for i in range(TC):
    n=int(input())
    graph=[[-1]*n for _ in range(n)]
    start_x,start_y=map(int,input().split())
    finish_x,finish_y=map(int,input().split())

    def bfs(x,y):
        queue=deque()
        queue.append((x,y))
        graph[x][y]=1
        
        while queue:
            x,y=queue.popleft()
            for i in range(len(night)):
                nx = x + night[i][0]
                ny = y + night[i][1]
                if x==finish_x and y==finish_y:
                    return graph[x][y]-1
                if 0<=nx<n and 0<=ny<n and graph[nx][ny]==-1:
                    queue.append((nx,ny))
                    graph[nx][ny]=graph[x][y]+1
                    
    total=bfs(start_x,start_y)
    print(total)