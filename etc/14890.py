#경사로
# 구현문제
# 조건을 넣을 때 신경써야한다
from collections import deque
import sys
input=sys.stdin.readline

n,l=map(int,input().split())
graph=[list(map(int,input().split())) for _ in range(n)]
cnt=0

# 세로 방향
def x_change(y):
    global l,cnt
    q=deque()
    x=0
    q.append(x)
    check=[False for _ in range(n)]
    while q:
        x=q.popleft()
        nx=x+1

        if x==n-1:
            continue
        
        elif graph[x][y]-graph[nx][y]==0:
            q.append(nx)
            continue
        #내리막
        elif graph[x][y]-graph[nx][y]==1 and check[nx]==False:
            # 같은 높이인지 체크
            for i in range(l):
                # 같으면 다리 놨다고 체크표시
                if not 0<=nx+i<n:
                    return
                elif graph[nx][y]==graph[nx+i][y]:
                    if i==l-1:
                        for j in range(l):
                            if check[nx+j]==False:
                                check[nx+j]=True
                            else:
                                return
                #높이 다르면 탈락
                else:
                    return
            q.append(nx)
        #오르막
        elif graph[x][y]-graph[nx][y]==-1 and check[x]==False:
            
            for i in range(l):
                if not 0<=x-i<n:
                    return
                elif graph[x][y]==graph[x-i][y]:
                    if i==l-1:
                        for j in range(l):
                            if check[x-j]==False:
                                check[x-j]=True
                            else:
                                return
                else:
                    return
            q.append(nx)
        #탈락 높이차 1보다 클 시
        else:
            return
    cnt+=1
# 가로
def y_change(x):
    global l,cnt
    q=deque()
    y=0
    q.append(y)
    check=[False for _ in range(n)]
    while q:
        y=q.popleft()
        ny=y+1

        if y==n-1:
            continue
        
        elif graph[x][y]-graph[x][ny]==0:
            q.append(ny)
            continue
        
        #내리막
        elif graph[x][y]-graph[x][ny]==1 and check[ny]==False:
            
            # 같은 높이인지 체크
            for i in range(l):
                # 같으면 다리 놨다고 체크표시
                if not 0<=ny+i<n:
                    return
                elif graph[x][ny]==graph[x][ny+i]:
                    if i==l-1:
                        for j in range(l):
                            if check[ny+j]==False:
                                check[ny+j]=True
                            else:
                                return
                #높이 다르면 탈락
                else:
                    return
            q.append(ny)
        #오르막
        elif graph[x][y]-graph[x][ny]==-1 and check[y]==False:
            
            for i in range(l):
                if not 0<=y-i<n:
                    return
                elif graph[x][y]==graph[x][y-i]:
                    if i==l-1:
                        for j in range(l):
                            if check[y-j]==False:
                                check[y-j]=True
                            else:
                                return
                else:
                    return
            q.append(ny)
        #탈락 높이차 1보다 클 시
        else:
            return
    cnt+=1

for i in range(n):
    x_change(i)
    y_change(i)
print(cnt)