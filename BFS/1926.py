from collections import deque
import sys

input=sys.stdin.readline

n,m = map(int,input().split())
graph=[]

dx=[-1,1,0,0]
dy=[0,0,-1,1]
check =[[False]*m for _ in range(n)]
total=0
size_max=0

for i in range(n):
    graph.append(list(map(int,input().split())))

def bfs(x,y):
    queue=deque()
    queue.append((x,y))
    ret=1
    check[x][y]=True

    while queue:
        x,y =queue.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if nx<0 or nx>=n or ny<0 or ny>=m: 
                continue
            
            if graph[nx][ny] and not check[nx][ny]:
                queue.append((nx,ny))
                check[nx][ny]=True
                ret+=1
    return ret

for x in range(n):
    for y in range(m):
        if not check[x][y] and graph[x][y]:
            size_max=max(size_max,bfs(x,y))
            total+=1

print(total)
print(size_max)