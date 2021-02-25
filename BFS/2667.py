# bfs아파트 단지 구하기 문제 ret은 단지 넓이 구해주고 bfs 할때마다 갯수 올리기
# cnt 오름차순 안해줘서 틀림
from collections import deque
import sys
n=int(input())
graph=[]
check=[]
dx=[1,-1,0,0]
dy=[0,0,1,-1]
total=0 #단지 갯수
cnt=[] #단지마다 갯수
for i in range(n):
  graph.append(list(map(int,input())))
  check.append([False]*n)

def bfs(x,y):
  queue=deque()
  queue.append((x,y))
  check[x][y]=True
  ret=1
  while queue:
    x,y=queue.popleft()
    for i in range(4):
      nx = x+dx[i]
      ny = y+dy[i]
      if 0<=nx<n and 0<=ny<n and graph[nx][ny]==1 and not check[nx][ny]:
        check[nx][ny]=True
        queue.append((nx,ny))
        ret+=1
  return ret

for i in range(n):
  for j in range(n):
    if check[i][j]==False and graph[i][j]==True:
      cnt.append(bfs(i,j))
      total+=1

print(total)
cnt.sort()
for i in range(total):
  print(cnt[i])