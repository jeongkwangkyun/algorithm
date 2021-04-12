# 처음 접근을 맞게했지만
# 출력과정에서 append할때도 dp 10000009 를 나머지 해줄진 몰랐따 지금도 왜 해야하는거지

import sys
input=sys.stdin.readline

tc=int(input())
dp=[0,1,2,4]

for i in range(4,1000001):
    dp.append(dp[i-3]%1000000009+dp[i-2]%1000000009+dp[i-1]%1000000009)


for i in range(tc):
    n=int(input())
    print(dp[n]%1000000009)