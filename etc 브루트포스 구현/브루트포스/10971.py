#외판원 순회2
import sys
from itertools import permutations
input=sys.stdin.readline

n= int(input())
graph=[list(map(int,input().split())) for i in range(n)]
cnt_per=list(permutations([x for x in range(n)],n))
min_size=sys.maxsize

for i in cnt_per:
    cnt=0
    a=list(i)
    for j in range(1,n+1):
        if j==n:
            tmp=graph[a[n-1]][a[0]]
        else:
            tmp=graph[a[j-1]][a[j]]

        if tmp==0:
            cnt+=sys.maxsize
        else:
            cnt+=tmp
        
    min_size=min(min_size,cnt)
print(min_size)