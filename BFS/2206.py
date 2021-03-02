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

check=[[[-1]*2 for _ in range(m)] for _ in range(n)]

def bfs():
  queue=deque()
  queue.append((0,0,0))
  check[0][0][0]=1
  
  while queue:
    x,y,z = queue.popleft()
    for i in range(4):
      nx= x + dx[i]
      ny= y + dy[i]
      if 0<=nx<n and 0<=ny<m :
        #벽을 부술경우와 안부술경우 두가지로 나눈다
        # check 3차원 리스트로 z가 부순경우 안부수경우 판단
        
        # 안부술경우, 한번 부수고 나선 z=1에다가 담는다
        if graph[nx][ny]==0 and check[nx][ny][z]==-1:
          check[nx][ny][z]=check[x][y][z]+1
          queue.append((nx,ny,z))
        # 벽을 만나서 처음으로 부수는 경우 
        elif z==0 and graph[nx][ny]==1 and check[nx][ny][z+1]==-1:
          check[nx][ny][z+1]=check[x][y][z]+1
          queue.append((nx,ny,z+1))

bfs()

ret1,ret2 =check[n-1][m-1][0],check[n-1][m-1][1]

if ret1==-1 and ret2!=-1:
  print(ret2)
elif ret1!=-1 and ret2==-1:
  print(ret1)
else:
  print(min(ret1,ret2))

