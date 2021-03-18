# 벽을 만들어주는걸 재귀함수로 return 시켜서
# bfs문은 기본 bfs인데 케이스마다 2 갯수 세야하므로 deepcopy 이용

from collections import deque
import sys
import copy
input=sys.stdin.readline

n,m=map(int,input().split())

graph=[list(map(int,input().split())) for _ in range(n)]
dx=[0,0,1,-1]
dy=[1,-1,0,0]

queue=deque()
total=0

def bfs():
    global total
    tmp=0
    w= copy.deepcopy(graph) # x,y 값 변하는대로 테스트해야하므로 graph 임시 값

    for x in range(n):
        for y in range(m):
            if w[x][y]==2:
                queue.append((x,y))

    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx= x+dx[i]
            ny= y+dy[i]
            if 0<=nx<n and 0<=ny<m and w[nx][ny]==0:
                queue.append((nx,ny))
                w[nx][ny]=2

    for x in range(n):
            for y in range(m):
                if w[x][y]==0:
                    tmp+=1
    total=max(total,tmp)

def wall(x):
    if x==3:
        bfs()
        return

    for i in range(n):
        for j in range(m):
            if graph[i][j]==0:
                graph[i][j]=1
                wall(x+1)
                graph[i][j]=0

wall(0)
print(total)