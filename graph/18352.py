import heapq
import sys
input=sys.stdin.readline
INF=int(1e9)

n,m = map(int,input().split())
start=1

graph = [[] for i in range(n+1)]

distance =[INF]*(n+1)

for _ in range(m):
    a, b,c = map(int, input().split())
    
    graph[a].append((b,c))
    graph[b].append((a,c))

v1,v2=map(int,input().split())

def dijkstra(start):
    q=[]

    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dist, now= heapq.heappop(q)

        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost = dist+i[1]

            if cost < distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))
first=True
#1에서 v1까지
dijkstra(start)
v1_result=distance[v1]

#v1에서  v2까지
start=v1
dijkstra(start)
v2_result=distance[v2]

 #v2에서 n까지
start=v2
dijkstra(start)
result=distance[n]

if result==0:
    first=False
    

if first==False:
    print(-1)
else:
    print(v1_result+v2_result+result)