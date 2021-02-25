#배추 벌레 문제 bfs 돌때마다 증가 시켜주면 되는데 x,y 신경잘써서
from collections import deque
import sys
input=sys.stdin.readline
T=int(input())
dx=[1,-1,0,0]
dy=[0,0,-1,1]



for i in range(T):
  m,n,k=map(int,input().split())
  graph=[[0]*m for _ in range(n)]
  check=[[False]*m for _ in range(n)]
  total=0
  for j in range(k):
    x,y = map(int,input().split())
    graph[y][x]=1
  
  def bfs(x,y):
    queue=deque()
    queue.append((x,y))
    check[x][y]=True
    while queue:
      x,y=queue.popleft()
      for z in range(4):
        nx=x+dx[z]
        ny=y+dy[z]
        if 0<=nx<n and 0<=ny<m and graph[nx][ny]==1 and not check[nx][ny]:
          queue.append((nx,ny))
          check[nx][ny]=True
          

  for row in range(n):
    for column in range(m):
      if graph[row][column]==1 and check[row][column]==False:
        total+=1
        bfs(row,column)
  print(total)