# 케이스를 2가지 밖에 생각 못함 ,이번꺼 안먹은 경우// 이번꺼 먹고 + dp[i-2]
# + 추가로 이번꺼 저번꺼 먹은 경우도 생각 해줬어야함 lst[i-2],lst[i-1],dp[i-3]

# lst랑 dp랑 인덱스 안맞기때문에 헷갈리는거 조심, 가짓수를 더 생각해보자!!!
import sys
input=sys.stdin.readline

n=int(input())
lst=[]
dp=[0]*(n+1)

for _ in range(n):
    lst.append(int(input()))

dp[1]=lst[0]
if n>1:
    dp[2]=lst[0]+lst[1]

for i in range(3,n+1):
    # case 1 이번 포도주 먹고 전꺼 안 먹은경우
    case1=dp[i-2]+lst[i-1]
    # case 2 이번 포도주 먹고 전꺼 먹은경우
    case2=lst[i-2]+lst[i-1]+dp[i-3]
    # case 이번 포도주 안 먹은 경우
    case3=dp[i-1]
    dp[i]=max(case1,case2,case3)

print(dp[n])