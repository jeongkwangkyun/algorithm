import sys
input=sys.stdin.readline

n,m = map(int,input().split())

lst=list(map(int,input().split()))
lst.sort()
tmp=[0 for i in range(m)]

def go(number,selected,n,m):
    if selected==m:
        print(" ".join(map(str,tmp)))
        return
    if number==n:
        return
    
    tmp[selected]=lst[number]
    go(number+1,selected+1,n,m)
    tmp[selected]=0
    go(number+1,selected,n,m)
go(0,0,n,m)