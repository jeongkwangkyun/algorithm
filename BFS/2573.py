#빙산 BFS
# 빙산이 없을 경우를 count로 세주고 bfs를 먼저 돌린다음 
# 체크 값은 돌때마다 새로 선언해주어서 신경 쓸 필요없으며
#
from collections import deque
import sys
input=sys.stdin.readline

n,m = map(int,input().split())
graph=[]
dx=[1,-1,0,0]
dy=[0,0,1,-1]
year=0
stan=n*m

for _ in range(n):
    graph.append(list(map(int,input().split())))

def bfs(x,y):
    global graph
    queue=deque()
    queue.append([x,y])
    check[x][y]=1
    while queue:
        x,y=queue.popleft()
        minus[(x,y)]=0
        for i in range(4):
            nx = x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<m:
                if graph[nx][ny]==0: # 주위가 바다인 경우 갯수세기 +1
                    minus[(x,y)]+=1
                elif graph[nx][ny] != 0 and check[nx][ny]==0: #빙산인데 방문하지 않을경우 append
                    queue.append([nx,ny])
                    check[nx][ny]=1
    return minus

while True:
    # 1. 빙하가 없으면 바로종료
    res=0
    for row in graph:
        res += row.count(0) #count 함수
    if res == stan:
        print(0)
        sys.exit()
    # 2. 빙산조사시작
    island=0
    minus=dict()
    check=[[0]*m for _ in range(n)]

    for i in range(1,n-1):
        for j in range(1,m-1):
            if graph[i][j] != 0 and check[i][j]==0:
                bfs(i,j)
                island+=1
                # 두덩어리 되는 순간 출력
                if island==2:
                    print(year)
                    sys.exit()
    # 3 빙산 녹이기
    for key, value in minus.items():
        graph[key[0]][key[1]] -= value
        if graph[key[0]][key[1]]<0:
            graph[key[0]][key[1]]=0
    # 빙산 녹이고 1년 추가
    year+=1