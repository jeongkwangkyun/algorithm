# dp
# 1로 만들기 
# -1 ,  //2 , //3 세개중 가장 작은값 비교

import sys
input=sys.stdin.readline

n=int(input())
# 0,1,2,3
dp=[0,0,1,1]

for i in range(4,n+1):
    # 처음 -1 한거 넣어주고 비교식으로 가기
    dp.append(dp[i-1]+1)

    # dp 값이 -1과 //2 +1 중 min 값
    if i%2==0:
        dp[i]=min(dp[i//2]+1,dp[i])
    # dp 값이 -1과 //3 +1 중 min 값 /////// if문 쓴거 주의 !!! 3도 비교해줘야하므로
    if i%3==0:
        dp[i]=min(dp[i//3]+1,dp[i])

print(dp[n])``