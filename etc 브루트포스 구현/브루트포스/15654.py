import sys

input=sys.stdin.readline

n,m=map(int,input().split())
lst=list(map(int,input().split()))
lst.sort()
tmp=[0 for _ in range(m)]
check=[False for _ in range(n)]

def go(cnt,n,m):
    if cnt==m:
        print(" ".join(map(str,tmp)))
        return
    for i in range(n):
        if check[i]==False:
            check[i]=True
            tmp[cnt]=lst[i]
            go(cnt+1,n,m)
            check[i]=False

go(0,n,m)
