# 스타트링크

# 일차원 BFS 문제이며, U,D 을 nx 값에 넣어줘서
# check 해당 값 출력
from collections import deque
import sys
input=sys.stdin.readline

F,S,G,U,D = map(int,input().split())
dx =[U,-D]
graph=[[] for _ in range(F)]
check=[-1 for _ in range(F)]


def bfs(start,end):
    queue=deque()
    queue.append(start)
    check[start]=0
    while queue:
        x=queue.popleft()
        for i in range(2):
            nx= x +dx[i]
            if 0<=nx<len(graph) and check[nx]==-1:
                queue.append(nx)
                check[nx]=check[x]+1
    return check[end]
cnt=bfs(S-1,G-1)

if cnt==-1:
    print("use the stairs")
else:
    print(cnt)