# 구슬탈출 2
from collections import deque
from sys import stdin
input=stdin.readline

n,m=map(int,input().split())
graph=[list(input().rstrip()) for _ in range(n)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]
queue=deque()
check=[[[[False]*m for _ in range(n)] for _ in range(m)] for _ in range(n)]

def init(): # R 구슬 위치와 B 구슬 위치를 넣어 queue에 두개 들어감
    rx,ry, bx, by=0,0,0,0
    for i in range(n):
        for j in range(m):
            if graph[i][j]=='R':
                rx,ry=i,j
            elif graph[i][j]=='B':
                bx,by=i,j
    queue.append((rx,ry,bx,by,1))
    check[rx][ry][bx][by]=True

def move(x,y,dx,dy):
    cnt=0  #벽을 만나거낙 0을 만나기 전까지 계속 직진
    while graph[x+dx][y+dy] !="#" and graph[x][y]!='O':
        x+=dx
        y+=dy
        cnt+=1
    return x,y,cnt

def bfs():
    init()
    while queue:
        rx,ry,bx,by,depth=queue.popleft()
        if depth>10:
            break
        for i in range(4):
            nrx,nry,rcnt=move(rx,ry,dx[i],dy[i])
            nbx,nby,bcnt=move(bx,by,dx[i],dy[i])
            if graph[nbx][nby] !='O':
                if graph[nrx][nry]=='O':
                    print(depth)
                    return
                if nrx==nbx and nry==nby:
                    if rcnt>bcnt:
                        nrx-=dx[i]
                        nry-=dy[i]
                    else:
                        nbx-=dx[i]
                        nby-=dy[i]

                if not check[nrx][nry][nbx][nby]:
                    check[nrx][nry][nbx][nby]=True
                    queue.append((nrx,nry,nbx,nby,depth+1)) 
    print(-1)
bfs()