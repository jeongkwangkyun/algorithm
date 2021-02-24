import sys
INF=int(1e9)
input=sys.stdin.readline

n = int(input())
m = int(input())

graph=[[INF]* (n) for _ in range(n)]

for a in range(n):
    for b in range(n):
        if a==b:
            graph[a][b]=0

for i in range(m):
    x,y,z = map(int,input().split())
    
    graph[x-1][y-1]=min(graph[x-1][y-1],z)

for k in range(n):
    for a in range(n):
        for b in range(n):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])
            
for a in range(n):
    for b in range(n):
        if graph[a][b] == INF:
            print("0", end=' ')
        else:
            print(graph[a][b], end=" ")
    print()