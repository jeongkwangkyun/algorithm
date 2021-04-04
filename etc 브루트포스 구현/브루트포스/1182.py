import sys
from itertools import combinations

input=sys.stdin.readline

n,s=map(int,input().split())
num=list(map(int,input().split()))
total=0

for i in num:
    if i==s:
        total+=1

for i in range(2,n+1):
    
    lst=list(combinations(num,i))
    for j in lst:
        cnt=0
        a=list(j)
        while len(a)!=0:
            cnt+=a.pop()
        if cnt==s:
            total+=1

print(total)