from collections import deque
import sys
input=sys.stdin.readline

m,n,h = map(int,input().split())
dx=[1,-1,0,0,0,0]
dy=[0,0,1,-1,0,0]
dz=[0,0,0,0,1,-1]
graph=[[list(map(int,input().split())) for i in range(n)] for depth in range(h)]
check=[[[0]*m for _ in range(n)] for _ in range(h)]
q=deque()

def bfs():
    while q:
        for _ in range(len(q)):
            x,y,z=q.popleft()
            for i in range(6):
                nx = x+dx[i]
                ny = y+dy[i]
                nz = z+dz[i]
                if 0<=nx<h and 0<=ny<n and 0<=nz<m and graph[nx][ny][nz]==0 and check[nx][ny][nz]==0:
                    graph[nx][ny][nz]=1
                    q.append([nx,ny,nz])
                    check[nx][ny][nz]=check[x][y][z]+1
for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[i][j][k]==1 and check[i][j][k]==0:
                q.append([i,j,k])
                check[i][j][k]=1
bfs()
for i in graph:
    for j in i:
        if 0 in j:
            print(-1)
            sys.exit()
ans = 0
for i in check:
    for j in i:
        list_max = max(j)
        ans = max(ans, list_max)
print(ans-1)