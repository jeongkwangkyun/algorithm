#일반적인 bfs 문제인데 미로 시작점 0,0에서 n,m까지의 거리 구하기 문제
#check를 -1로 계산하여 bfs 돌릴때마다 check[nx][ny]값을 check x y +1로 해결
# 평소처럼 input=sys.stdin.readline 이거 해서 리스트로 바꾸었는데 맵할때 인트형변환이 안돼서 좀뺑이침
from collections import deque
import sys

n,m = map(int,input().split())
dx=[1,-1,0,0]
dy=[0,0,1,-1]
check=[[-1]*m for _ in range(n)]

graph=[]
for i in range(n):
    graph.append(list(map(int,input())))

def bfs(x,y):
  queue=deque()
  queue.append((x,y))
  check[x][y]=0
  while queue:
    x,y=queue.popleft()
    for i in range(4):
      nx = x+dx[i]
      ny = y+dy[i]
      if 0<=nx<n and 0<=ny<m :
        if graph[nx][ny]==1 :
          if check[nx][ny]==-1 :
              check[nx][ny]=check[x][y]+1
              queue.append((nx,ny))
              
  return check[n-1][m-1]

print(bfs(0,0)+1)