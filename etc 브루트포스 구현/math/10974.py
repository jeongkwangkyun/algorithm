# 모든순열
from itertools import permutations
import sys
input=sys.stdin.readline

n=int(input())

lst=[x for x in range(1,n+1)]
lst_per=list(permutations(lst,n))
for i in range(len(lst_per)):
    for j in range(n):
        print(lst_per[i][j],end=' ')
    print()