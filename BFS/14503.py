# 로봇청소기 문제 뒤로 한보 가는게 헷갈려서 답지 보고 다시품
# 벽은 1 안간건 0 간건 2로 표현
from collections import deque
import sys
input=sys.stdin.readline

n,m= map(int,input().split())
r,c,d=map(int,input().split())
dy=[0,1,0,-1]
dx=[-1,0,1,0]
graph=[]

for _ in range(n):
    graph.append(list(map(int,input().split())))

def bfs(x,y,d):
    global ans
    if graph[x][y]==0:
        graph[x][y]=2
        ans+=1
    for _ in range(4): 
        nd=(d+3)%4 #왼쪽방향 테스트 범위를 4로 뒀는데 왼쪽방향이 있는걸 먼저 비교해주고 리턴시키고 아니면 4방향 검사하기때문에 조건 충족함
        nx=x+dx[nd]
        ny=y+dy[nd]
        if graph[nx][ny]==0:
            bfs(nx,ny,nd)
            return 
        d=nd
    nd=(d+2)%4  #뒤로 이동 가능한지
    nx=x+dx[nd]
    ny=y+dy[nd]
    if graph[nx][ny]==1: #벽이면 바로 리턴해서 종료
        return
    bfs(nx,ny,d) #뒤로 한보 간거는 방향 바뀜 x 

ans=0
bfs(r,c,d)
print(ans)