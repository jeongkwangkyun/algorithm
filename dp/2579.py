import sys

input=sys.stdin.readline

n=int(input())

dp=[0]*n
stairs=[int(input()) for _ in range(n)]
three_cnt=0

for i in range(n):

    # 첫번째 계단까지의 dp
    if i==0:
        dp[0]=stairs[i]
    # 두번째 계단까지의 dp
    elif i==1:
        dp[i]=max(dp[i-1]+stairs[i],stairs[i])
    # 세번째 dp 비교
    elif i==2:
        dp[i]=max(dp[i-2]+stairs[i],stairs[i-1]+stairs[i])
    # 마지막 + 직전(n-1) + 두칸전         ,     마지막 + 두칸전(n-2)  이렇게 비교하면 3번째 연속인게 없다
    else:
        dp[i]=max(stairs[i]+stairs[i-1]+dp[i-3],stairs[i]+dp[i-2])
    
print(dp[n-1])