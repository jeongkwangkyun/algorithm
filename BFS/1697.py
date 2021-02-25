# 숨바꼭질 1차원 bfs로 next x 값을 x-1,x+1,x*2 비교해주면서 다음값에 +1씩
from collections import deque
import sys
input=sys.stdin.readline

n,k=map(int,input().split())
graph=[0]*100001


def bfs(n):
  queue=deque()
  queue.append(n)
  while queue:
    x=queue.popleft()
    if x==k:
      return graph[x]
    for nx in (x-1,x+1,x*2):
      if 0<=nx<100001 and not graph[nx]:
        graph[nx]=graph[x]+1
        queue.append(nx)

print(bfs(n))