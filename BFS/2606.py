from collections import deque
import sys
input=sys.stdin.readline
n = int(input()) 
graph=[[] for _ in range(n+1)]
check=[False for _ in range(n+1)]
m = int(input())

for _ in range(m):
  x,y=map(int, input().split())
  graph[x].append(y)
  graph[y].append(x)

def bfs(num):
  queue=deque()
  queue.append(num)
  check[num]=True
  cnt=0

  while queue:
    x=queue.popleft()
    for i in graph[x]:
      if not check[i]:
        check[i] = True
        queue.append(i)
        cnt+=1
        
  return cnt

print(bfs(1))