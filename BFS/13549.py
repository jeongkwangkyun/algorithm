# 숨바꼭질 3
# bfs인데 2*x appendleft
import sys
from collections import deque
input=sys.stdin.readline
start,end=map(int,input().split())
graph=[-1]*100001

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
                    # 순간이동 하는 경우를 우선으로 해서 시간을 최대한 줄임
                    if nx==2*x:
                        graph[nx]=graph[x]
                        queue.appendleft(nx)
                    else:
                        graph[nx]=graph[x]+1
                        queue.append(nx)
            
            
bfs(start,end)
print(graph[end])