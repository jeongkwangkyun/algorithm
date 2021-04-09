# 연결 요소의 개수

import sys
from collections import deque
input=sys.stdin.readline

n,m=map(int,input().split())

lst=[[] for _ in range(n)]
check=[False for _ in range(n)]
total=0
queue=deque()

for i in range(m):
    x,y=map(int,input().split())
    lst[x-1].append(y-1)
    lst[y-1].append(x-1) 

def bfs(x):
    global total
    check[x]=True
    
    for nx in lst[x]:
        if check[nx]==False:
            queue.append(nx)
    # 덱 사용해서 False일 시, 삽입
    while queue:
        x=queue.popleft()
        for nx in lst[nx]:
            if check[nx]==False:
                queue.append(nx)
                check[nx]=True
    # 이어진곳 전부 다 순환하면 +1           
    total+=1

# 0~n까지 전부 다 체크
for i in range(n):
    if not check[i]:
        bfs(i)
    
print(total)