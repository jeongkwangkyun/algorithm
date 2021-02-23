from collections import deque
import sys
input=sys.stdin.readline

dx=[1,-1,0,0]
dy=[0,0,-1,1]

graph=[]
n = int(input())
size_min=sys.maxsize
check=[[0]* n for i in range(n)]
cnt =1
for i in range(n):
    graph.append(list(map(int,input().split())))

def bfs(x,y,cnt):
    queue=deque()
    queue.append((x,y))
    check[x][y]=cnt
    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<n and graph[nx][ny]==1 and check[nx][ny]==0 :
                check[nx][ny]=cnt
                queue.append((nx,ny))
    
def bfs2(num):
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<n:
                if graph[nx][ny] == 1 and check[nx][ny]!=num:
                    return check2[x][y]-1
                if graph[nx][ny] == 0 and check2[nx][ny] == 0:
                    check2[nx][ny] = check2[x][y]+1
                    q.append((nx,ny))


for x in range(n):
    for y in range(n):
        if check[x][y]==False and graph[x][y]==1:
            bfs(x,y,cnt)
            cnt+=1

for k in range(1,cnt):
    q = deque()
    check2=[[0]* n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if graph[i][j]==1 and check[i][j]==k:
                q.append((i,j))
                check2[i][j]=1
    size_min=min(size_min,bfs2(k))

print(size_min)