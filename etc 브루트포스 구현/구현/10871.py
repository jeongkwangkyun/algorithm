# X보다 작은 수
import sys
input=sys.stdin.readline

n,m=map(int,input().split())

lst=list(map(int,input().split()))

for i in lst:
    if i<m:
        print(i, end=" ")