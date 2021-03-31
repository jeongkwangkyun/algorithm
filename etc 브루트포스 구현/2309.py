#브루트포스
# 일곱난쟁이
import sys
from itertools import combinations

input=sys.stdin.readline

lst=[]
for i in range(9):
    n=int(input())
    lst.append(n)
lst.sort()
lst_combi=list(combinations(lst,7))

total=0
for i in range(len(lst_combi)):
    for j in range(7):
       total+=lst_combi[i][j]
    if total==100:
        for k in range(7):
            print(lst_combi[i][k])
        sys.exit()
    else:
        total=0
#7 8 10 13 19 20 23