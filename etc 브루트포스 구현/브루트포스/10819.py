# 차이를 최대로

import sys
from itertools import permutations
input=sys.stdin.readline

n=int(input())

a=list(map(int,input().split()))

a_lst=list(permutations(a,n))

max_size=-sys.maxsize

for i in a_lst:
    cnt=0
    tmp=list(i)
    for j in range(1,n):
        cnt+=abs(tmp[j]-tmp[j-1])
    max_size=max(cnt,max_size)

print(max_size)