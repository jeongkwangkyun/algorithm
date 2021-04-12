# dp....
# 전에 썼던걸 써야하는걸 명심하자

# dp 1, dp 2 손으로 구하고
# 3부터 규칙, 3개짜리 or dp[2] +card[0] 2개
# ... n개짜리 or dp[1]+dp[i-1], dp[2]+dp[i-2]... 쭉 비교

import sys
input=sys.stdin.readline

n=int(input())

card=list(map(int,input().split()))

dp=[0]*(n+1)

dp[1]=card[0]
dp[2]=max(card[0]*2,card[1])

for i in range(3,n+1):
    # i개 카드를 우선 넣어둠
    dp[i]=card[i-1]
    for j in range(1,i//2+1):
        # 1 i-1 이게 dp i * n개 , 2 i-2, 3 i-3, .....
        dp[i]=max(dp[i],dp[j]+dp[i-j])

print(dp[n])