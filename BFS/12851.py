# 숨바꼭질 2 문제 갯수 세주는게 까다로웠는데 bfs 끝까지 돌리고 해당 숫자일때만 카운트
# 조건에서 -1(방문 x) 이거나 방문한거중에 +1 이였을때도 계속 돌아가게끔 
# 전부다 돌리면 시간 초과할 줄 알았는데 갠찮았음
from collections import deque
import sys
input=sys.stdin.readline

n,k=map(int,input().split())
graph=[-1]*100001

def bfs(n):
  queue=deque()
  queue.append(n)
  graph[n]=0
  cnt=0
  while queue:
    x=queue.popleft()
    if x==k:
      cnt+=1
    for nx in (x-1,x+1,x*2):
      if 0<=nx<100001 :
          if graph[nx]==-1 or graph[nx]==graph[x]+1:
            graph[nx]=graph[x]+1
            queue.append(nx)
  return cnt

a=bfs(n)
print(graph[k])
print(a)
