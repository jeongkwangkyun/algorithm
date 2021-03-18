# 브루트 포스 알고리즘

import sys
input=sys.stdin.readline

n=int(input())

graph=[list(map(int,input().split())) for _ in range(n)]
total=sys.maxsize
select=[0 for _ in range(n)]


def dfs(idx,cnt):
    global total
    if cnt == n//2:
        start, link =0 ,0
        for i in range(n):
            for j in range(n):
                #선택된거
                if select[i] and select[j]:
                    start += graph[i][j]
                #선택 안된거
                elif not select[i] and not select[j]:
                    link += graph[i][j]
        total= min(total,abs(start-link))
        
    # n개 중 n//2를 걸러주기 위해서 재귀함수 -> 이해하기 어렵지만 유용한거같다
    for i in range(idx,n):
        if select[i]:
            continue
        select[i]=1
        dfs(i+1,cnt+1)
        select[i]=0
dfs(0,0)
print(total)