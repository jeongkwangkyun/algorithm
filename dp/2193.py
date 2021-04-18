# 2차원 dp 비슷한류
# 0 일땐 0과 1 둘다 가능
# 1 일땐 0 만 올 수 있다
import sys
input=sys.stdin.readline

n=int(input())

dp=[[0]*2 for i in range(n+1)]
dp[1][0]=0
dp[1][1]=1

for i in range(2,n+1):
    for j in range(2):
        if j==0:
            dp[i][j]=dp[i-1][0]+dp[i-1][1]
        elif j==1:
            dp[i][j]=dp[i-1][0]

print(sum(dp[n]))