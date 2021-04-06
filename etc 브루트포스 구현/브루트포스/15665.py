# 같은수 여러번
# 수열 사전순
# 77 이런것도 가능
import sys
n,m= map(int,input().split())

lst=set(map(int,input().split()))
lst=sorted(list(set(lst)))
lst.sort()
tmp=[0 for i in range(m)]

def go(cnt,n,m):
    if cnt==m:
        print(" ".join(map(str,tmp)))
        return
    
    for i in range(len(lst)):
        tmp[cnt]=lst[i]
        go(cnt+1,n,m)

go(0,n,m)