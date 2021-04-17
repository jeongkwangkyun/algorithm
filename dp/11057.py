# 오르막수 오름차순인 수를 구하는 문제
# 주의 첫번째 수가 0도 들어갈 수 있음
# 10844 쉬운 계단수랑 유사한 문제
# 이 문제는 0일때 1~9 ,1일때 2~9, 2일때 3~9 ....... 9는 그냥 전에꺼랑 같도록

import sys
input=sys.stdin.readline

n= int(input())
dp=[[0]*10 for i in range(n+1)]

for i in range(10):
    dp[1][i]=1
    
for i in range(2,n+1):
    for j in range(10):
        if j==9:
            dp[i][j]=dp[i-1][j]
        else:
            for k in range(10):
                if k<j:
                    continue
                dp[i][j]+=dp[i-1][k] 

print(sum(dp[n])%10007)