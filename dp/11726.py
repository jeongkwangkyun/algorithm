import sys
input=sys.stdin.readline

n=int(input())

dp=[0,1,2]

# 2*n 크기의 타일 dp[n-1]개 + dp[n-2]
# 0 1 2 3 5 8 13 ~~~
for i in range(3,n+1):
    dp.append(dp[i-1]+dp[i-2])

print(dp[n]%10007)