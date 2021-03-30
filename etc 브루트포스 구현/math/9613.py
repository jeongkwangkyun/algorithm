from itertools import combinations
import math
tc=int(input())


for i in range(tc):
    lst=list(map(int,input().split()))
    lst.pop(0)
    result=list(combinations(lst,2))
    total=0
    for j in range(len(result)):
        a=int(result[j][0])
        b=int(result[j][1])
        total+=math.gcd(a,b)

    print(total)