# 1,2,3 더하기
# 다이나믹프로그래밍
# dp 생각했는데 1,2,3 을 생각 안해줬음 ㅜㅜ
import sys
input=sys.stdin.readline

t= int(input())

dp=[1,2,4]

for i in range(3,11):
  dp.append(dp[i-3]+dp[i-2]+dp[i-1])



for j in range(t):
    n=int(input())
    print(dp[n-1])