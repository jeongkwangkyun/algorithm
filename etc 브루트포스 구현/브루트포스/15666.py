#n과 m

import sys
# 중복조합 -> 이미 썼던 숫자 또 써도 됨
from itertools import combinations_with_replacement
input=sys.stdin.readline

n,m= map(int,input().split())
lst=list(map(int,input().split()))
lst.sort()
# 표현 외워두면 쓸때 많을듯
lst=list(combinations_with_replacement(lst,m))

# sorted는 원래 배열이 바뀌지 않음 sort는 원래 배열이 바뀜
lst=sorted(list(set(lst)))

for i in lst:
    a=list(i)
    for j in a:
        print(j,end=" ")
    print()