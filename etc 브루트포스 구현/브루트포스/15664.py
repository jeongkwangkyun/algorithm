import sys
from itertools import combinations

n,m= map(int,input().split())

lst=list(map(int,input().split()))
lst.sort()

lst=set(combinations(lst,m))
lst=sorted(list(set(lst)))
for i in lst:
    print(" ".join(map(str,i)))