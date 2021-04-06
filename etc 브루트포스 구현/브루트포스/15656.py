# 중복해서 써도 된다
# 사전으로 커지는 순
# 15651과 같은데 sort만 시켜줌
import sys
input=sys.stdin.readline

n,m = map(int,input().split())

lst=list(map(int,input().split()))
lst.sort()
tmp=[0 for i in range(m)]

def go(selected,n,m):
    if selected==m:
        print(" ".join(map(str,tmp)))
        return
    
    
    for i in range(n):
        tmp[selected]=lst[i]
        go(selected+1,n,m)
        

go(0,n,m)