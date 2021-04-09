import sys
from collections import deque
input=sys.stdin.readline
queue=deque()

dx=[0,0,1,-1, 1,1,-1,-1]
dy=[1,-1,0,0, 1,-1,1,-1]

def bfs(x,y):
    check[x][y]=True
    queue.append((x,y))
    while queue:
        x,y=queue.popleft()
        for i in range(8):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<h and 0<=ny<w:
                if graph[nx][ny]==1 and not check[nx][ny]:
                    check[nx][ny]=True
                    queue.append((nx,ny))
    
    
while 1:
    w,h=map(int,input().split())
    if w==0 and h==0:
        sys.exit()
    graph=[list(map(int,input().split())) for _ in range(h)]
    check=[[False]*w for _ in range(h)]
    cnt=0

    for i in range(h):
        for j in range(w):
            if graph[i][j]==1 and check[i][j]==False:
                bfs(i,j)
                cnt+=1
            else:
                continue
    print(cnt)