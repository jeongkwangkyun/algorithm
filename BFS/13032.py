import sys
input=sys.stdin.readline
n,m=map(int,input().split())

graph=[[] for _ in range(n)]
check=[False for _ in range(n)]
# 1차원 배열 양쪽에 친구인 값 넣어주기 
for i in range(m):
    x,y=map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)

ans=False

def dfs(v,depth):
    global ans
    check[v]=True
    #depth 가 4번 이상이면 -> 코드가 4번 돌면 return
    if depth>=4:
        ans=True
        return

    for nxt in graph[v]:
        # check False면 돌고 True면 안돈다 재귀식으로 돌아서 아니면 다시 False
        if not check[nxt]:
            dfs(nxt, depth+1)
            check[nxt]=False

for i in range(n):
    dfs(i,0)
    check[i]=False
    if ans:
        break    
    
print(1 if ans else 0)