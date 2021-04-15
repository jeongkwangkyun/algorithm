import sys
from collections import deque
input=sys.stdin.readline

start,end=map(int,input().split())

graph=[-1]*100001
# nx에 x(그 전에 방문했던 값) 넣어주기
path=[0]*100001
def bfs(start,end):
    graph[start]=0
    queue=deque()
    queue.append(start)
    while queue:
        x=queue.popleft()
        # 순간이동을 먼저 고려하게돼서 x가 나오면 그만 돌게함
        if x==end:
            return
        for nx in (2*x,x-1,x+1):     
            if 0<=nx<100001:
                if graph[nx]==-1:
                    graph[nx]=graph[x]+1
                    queue.append(nx)
                    path[nx]=x
            
bfs(start,end)
# 몇번 횟수 
print(graph[end])
# 
next=end
lst=[]
while 1:
    if next==start:
        break
    lst.append(path[next])
    next=path[next]
lst.reverse()
for j in lst:
    print(j,end=' ')
print(end)