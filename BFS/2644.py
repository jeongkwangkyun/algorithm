from collections import deque
import sys
input=sys.stdin.readline

people=int(input())
graph=[[] for _ in range(people)]
check=[-1 for _ in range(people)]
start,end=map(int,input().split())

n=int(input())

for _ in range(n):
    x,y=map(int,input().split())
    graph[x-1].append(y-1)
    graph[y-1].append(x-1)

def bfs(start,end):
    queue=deque()
    queue.append(start)
    check[start]=0
    while queue:
        x=queue.popleft()
        for nx in graph[x]:
            if check[nx]==-1 :
                queue.append(nx)
                check[nx]=check[x]+1
    return check[end]
    
cnt=bfs(start-1,end-1)

if cnt==0:
    print(-1)
else:    
    print(cnt)