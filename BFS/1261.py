from collections import deque
import sys
input=sys.stdin.readline

n,m=map(int,input().split())
graph=[list(map(int,input().rstrip())) for _ in range(m)]
check=[[-1]*n for _ in range(m)]
check[0][0]=0
dx=[0,0,-1,1]
dy=[1,-1,0,0]

def bfs(x,y):
    queue=deque()
    queue.append((x,y))
    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<m and 0<=ny<n:
                # check -1 -> 한번도 방문안한거만 통과
                if check[nx][ny]==-1:
                    # 0이면 빈 방이므로 check 값 변화 X, 
                    # appendleft로 0으로 이어진거 먼저 방문해서 check 표시하면 다시 안돌기때문에
                    if graph[nx][ny]==0:
                        check[nx][ny]=check[x][y]
                        queue.appendleft((nx,ny))
                    # 1이면 뿌수고 check +1
                    else: 
                        check[nx][ny]=check[x][y]+1
                        queue.append((nx,ny))

bfs(0,0)
print(check[m-1][n-1])
