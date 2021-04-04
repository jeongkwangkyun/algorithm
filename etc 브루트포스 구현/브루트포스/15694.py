import sys
from itertools import permutations
input=sys.stdin.readline

n,m = map(int,input().split())

lst=list(permutations([x for x in range(1,n+1)],m))
for i in lst:
    a=list(i)
    for j in range(len(a)):
        print(a[j], end=' ')
    print()