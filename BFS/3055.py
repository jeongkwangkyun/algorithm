from collections import deque
import sys
input=sys.stdin.readline

r,c=map(int,input().split())
graph=[list(input().rstrip()) for _ in range(r)]
check_water=[[-1]*c for _ in range(r)]
check=[[-1]*c for _ in range(r)]
dx=[0,0,1,-1]
dy=[1,-1,0,0]
queue=deque()
# 고슴도치 bfs
def bfs(x,y):
    queue.append((x,y))
    check[x][y]=0
    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<r and 0<=ny<c:
                if graph[nx][ny]=='.':
                    # 물이 없는경우
                    if check[nx][ny]==-1 and check_water[nx][ny]==-1:
                        check[nx][ny]=check[x][y]+1
                        queue.append((nx,ny))
                    # 물이 먼저 흐른경우 물의 경로보다 더 작은경우만 +1
                    elif check[nx][ny]==-1 and check_water[nx][ny]>check[x][y]+1:
                        check[nx][ny]=check[x][y]+1
                        queue.append((nx,ny))
                # 최종 목적지
                elif graph[nx][ny]=='D' and check[nx][ny]==-1:
                    check[nx][ny]=check[x][y]+1
                
    print(check[final_x][final_y] if check[final_x][final_y]!=-1 else 'KAKTUS')
                    
# 물의 bfs
def bfs_water(x,y):
    queue.append((x,y))
    check_water[x][y]=0
    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<r and 0<=ny<c:
                if graph[nx][ny]=='.' or graph[nx][ny]=='S':
                # 물이 여러개인경우 고려
                    # 처음 물의 경로를 구할 때
                    if check_water[nx][ny]==-1:
                        check_water[nx][ny]=check_water[x][y]+1
                        queue.append((nx,ny))
                    # 물이 두개 이상일 때 
                    else:
                        if check_water[nx][ny]>check_water[x][y]+1:
                            check_water[nx][ny]=check_water[x][y]+1
                            queue.append((nx,ny))
    
for i in range(r):
    for j in range(c):
        if graph[i][j]=='S':
            start_x,start_y=i,j
        elif graph[i][j]=='*':
            bfs_water(i,j)
        elif graph[i][j]=='D':
            final_x,final_y=i,j

bfs(start_x,start_y)