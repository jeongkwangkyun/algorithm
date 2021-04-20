# 가장 긴 증가하는 부분 수열
# 이중 포문을 써서 i 기준 i 보다 작을 때마다  max 값 따져주기
# 출력은 dp 중 가장 큰거
import sys
input = sys.stdin.readline

n=int(input())
lst=list(map(int,input().split()))

dp=[1]*(n)

for i in range(1,n):
    for j in range(i):
        if lst[i]>lst[j]:
            dp[i]=max(dp[i],dp[j]+1)

print(max(dp))