# 1,0 과 0,1 에서 결과를 나누고 뭐가 더 가격 덜 드는지
# 방향을 정해주고 방향이 달라질때 +500
# dp 문제란다.......

import sys
from collections import deque
board=[[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]	

direction=[]
# 동 서 북 남
dx=[0,0,1,-1]
dy=[1,-1,0,0]

def bfs(start):
    check=[[sys.maxsize]*len(board) for _ in range(len(board))]
    check[0][0]=0
    queue=deque()
    queue.append(start)

    while queue:
        x,y,cost,dic=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<len(board) and 0<=ny<len(board) and board[nx][ny]==0:
                nc=cost+100 if i==dic else cost+600
                if nc<check[nx][ny]:
                    check[nx][ny]=nc
                    queue.append((nx,ny,nc,i))

    return check[-1][-1]

mins=min(bfs([0,0,0,0]),bfs([0,0,0,2]))
print(mins)