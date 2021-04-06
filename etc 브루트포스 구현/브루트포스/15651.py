import sys
from itertools import combinations
input=sys.stdin.readline

n,m = map(int,input().split())
lst=[0 for i in range(m)]

def go(cnt,n,m):
    #cnt m일 때 print 하구 다시 리턴
    if cnt == m:
        print(' '.join(map(str,lst)))
        return
    #1 부터 ~ n 까지 출력
    for i in range(1,n+1):
        lst[cnt]=i
        go(cnt+1,n,m)

go(0,n,m)