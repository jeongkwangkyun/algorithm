# graph 정점에 위치에 서로 연결된 간선 넣어주고, 
# check 값을 0으로 초기화한 다음 bfs를 돌리면 -1 값을 곱해주어서
# 그 전 값과 지금의 값이 같게되면(=서로 연결된 값이 같은 색이므로  이분 그래프 X
from collections import deque
import sys
input=sys.stdin.readline

k=int(input())

for _ in range(k):
    v,e = map(int,input().split())
    graph=[[]*v for _ in range(v)]
    check=[0 for _ in range(v)]

    for _ in range(e):
        i,j = map(int,input().split())
        graph[i-1].append(j-1)
        graph[j-1].append(i-1)
    ret=0

    def bfs(x):
        queue=deque()
        queue.append(x)
        check[x]=1
        while queue:
            x= queue.popleft()
            for nx in graph[x]:
                if check[nx]==0:
                    check[nx]=-1*check[x]
                    queue.append(nx)
                elif check[nx]==check[x]:
                    return 1
        return 0

    for i in range(v):
        if check[i]==0:
            ret=bfs(i)
            if ret == 1:
                break
            
    if ret==0:
        print("YES")
    else:
        print("NO")
            
