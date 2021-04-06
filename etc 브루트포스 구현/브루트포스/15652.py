import sys
from itertools import combinations_with_replacement
input=sys.stdin.readline

n,m=map(int,input().split())
lst=[0 for i in range(m)]

def go(number,selected,n,m):
    if selected==m:
        print(" ".join(map(str,lst)))
        return
    if number>n:
        return
    
    lst[selected]=number
    go(number,selected+1,n,m)
    lst[selected]=0
    go(number+1,selected,n,m)
go(1,0,n,m)



import sys
from itertools import combinations_with_replacement

input=sys.stdin.readline

n,m=map(int,input().split())
lst=[i for i in range(1,n+1)]
lst=list(combinations_with_replacement(lst,m))

for i in lst:
    print(" ".join(map(str,i)))
