#테트로미노
# 노가다 구현문제
import sys
input=sys.stdin.readline

n,m=map(int,input().split())
graph=[list(map(int,input().split())) for _ in range(n)]

dx=[[0,0,0],[1,2,3] # ----
,[0,1,1] # ㅁ
,[1,2,2],[1,1,1],[0,1,2],[1,0,0],[0,1,2],[1,1,1],[1,2,2],[0,0,1] #L
,[0,1,0],[1,1,2],[1,1,2],[1,1,1] # ㅗ
,[1,1,2],[0,-1,-1],[0,1,1],[1,1,2] # Z
]
dy=[[1,2,3],[0,0,0]
,[1,0,1]
,[0,0,1],[0,-1,-2],[1,1,1],[0,1,2],[1,0,0],[0,1,2],[0,0,-1],[1,2,2]
,[1,1,2],[0,-1,0],[0,1,0],[0,-1,1]
,[0,1,1],[1,1,2],[1,1,2],[0,-1,-1]
]
max_size=0

def search(x,y):
    tmp_size=0
    for i in range(19):
        total=0
        total+=graph[x][y]
        for j in range(3):
            nx = x + dx[i][j]
            ny = y + dy[i][j]
            if 0<=nx<n and 0<=ny<m:
                total+=graph[nx][ny]
                if j==2:
                    tmp_size=max(tmp_size,total) 
            else:
                continue   

    return tmp_size


for i in range(n):
    for j in range(m):
        max_size=max(search(i,j),max_size)
print(max_size)