#로또
import sys
input=sys.stdin.readline
from itertools import combinations

while 1:
    lst = list(map(int,input().split()))
    n=lst.pop(0)
    if n==0:
        sys.exit()
    lst_com=list(combinations(lst,6))

    for i in lst_com:
        a=list(i)
        for j in range(6):
            print(a[j],end=' ')
        print()
    print()