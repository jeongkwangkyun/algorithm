#2*n 타일링 2
# dp 정말 규칙 찾으려고 노력해야한다...!!

import sys
input=sys.stdin.readline

dp=[0,1]
n=int(input())

# n 값은 2^n - dp[n-1]
for i in range(2,n+1):
    dp.append(2**i-dp[i-1])

print(dp[n]%10007)