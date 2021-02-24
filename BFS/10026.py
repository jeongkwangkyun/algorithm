from collections import deque
import sys
input=sys.stdin.readline

n = int(input())
graph=[]

dx=[-1,1,0,0]
dy=[0,0,1,-1]
check=[[False]*n for _ in range(n)]

total=0 # r g b

for i in range(n):
    graph.append(list(input()))

def bfs(x,y):
    queue=deque()
    queue.append((x,y))
    check[x][y]=True

    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and graph[nx][ny]==graph[x][y] and not check[nx][ny]:
                queue.append((nx,ny))
                check[nx][ny]=True
   

for x in range(n):
    for y in range(n):
        if not check[x][y] and graph[x][y]:
            bfs(x,y)
            total+=1
# bfs 함수상에서 큐를 두개씩 만들어서 구현하려했는데 복잡. 그냥 그래프 새로 정의
print(total,end=' ')
total=0
check=[[False]*n for _ in range(n)]

for x in range(n):
    for y in range(n):
        if graph[x][y]=='G':
            graph[x][y]='R'

for x in range(n):
    for y in range(n):
        if not check[x][y] and graph[x][y]:
            bfs(x,y)
            total+=1
print(total)