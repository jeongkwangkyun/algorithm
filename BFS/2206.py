# 이중포문 돌려서 각각 0으로 바꿔서 min값 비교
# 해봤다가 시간초과 돼서 보니까 3차원 쓰라고한당
from collections import deque
import sys
graph=[]
dx=[1,-1,0,0]
dy=[0,0,-1,1]

minsize=sys.maxsize

n,m =map(int,input().split())

for i in range(n):
  graph.append(list(map(int,input())))


def bfs(x,y):
  queue=deque()
  queue.append((x,y))
  check=[[0]*m for _ in range(n)]
  ret=0
  while queue:
    x,y = queue.popleft()
    for i in range(4):
      nx= x + dx[i]
      ny= y + dy[i]
      if 0<=nx<n and 0<=ny<m and graph[nx][ny]==0 and check[nx][ny]==0:
        queue.append((nx,ny))
        check[nx][ny]=check[x][y]+1
  if check[n-1][m-1]==0:
    ret=sys.maxsize
    return ret
  else:
    return check[n-1][m-1]


minsize=bfs(0,0)

for i in range(n):
  for j in range(m):
    if graph[i][j]==1:
      graph[i][j]=0
      minsize=min(minsize,bfs(0,0))
      graph[i][j]=1
if minsize==sys.maxsize:
  print(-1)
else:
  print(minsize+1)