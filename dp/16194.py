# min 값 구하기

import sys
input=sys.stdin.readline

n=int(input())
card=list(map(int,input().split()))

dp=[0]*(n+1)

dp[1]=card[0]
dp[2]=min(dp[1]*2,card[1])

for i in range(3,n+1):
    dp[i]=card[i-1]

    for j in range(1,i//2+1):
        dp[i]=min(dp[i], dp[i-j]+dp[j])

print(dp[n])