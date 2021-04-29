import sys
input=sys.stdin.readline

n=int(input())
lst=list(map(int,input().split()))
dp=[[1,1] for i in range(n)]

for i in range(1,n):
   
    for j in range(i):
        if lst[i]>lst[j]:
            dp[i][0]=max(dp[i][0],dp[j][0]+1)
            

max_size=max(dp)[0]      
print(max_size)

for i in range(n):
    if max_size==dp[i][0]:
        x=i

from collections import deque

deque=deque()    
for i in range(max_size):
    deque.appendleft(lst[x])
    x=dp[x][1]
    
for k in range(max_size):
    print(deque[k], end=' ')