from collections import deque
import sys

input=sys.stdin.readline
INF=int(1e9)

def SPFA(start):
    d= [INF for _ in range(n)]
    on = [False for _ in range(n)]
    cycle = [0 for _ in range(n)]
    d[start]=0
    on[start]=True
    q = deque([start])
    while q:
        now = q.popleft()
        on[now] = False
        for next, val in edge[now]:
            if d[next]>d[now]+val:
                d[next]= d[now]+val
                if not on [next]:
                    cycle[next]+=1
                    if cycle[next] >=n:
                        print(-1)
                        return
                    on[next]=True
                    q.append(next)
    for val in d[1:]:
        print(-1) if val == INF else print(val)

n,m = map(int,input().split())
edge=[[] for _ in range(n)]
for _ in range(m):
    u,v,w=map(int,input().split())
    edge[u-1].append((v-1,w))

SPFA(0)