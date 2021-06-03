# 맞춰봐
# 재귀가 너무 어려워 ㅜㅜ
# s에 -,0,+를 구분해두고 -는 -10~-1 +는 1~10 해서 경우의 수를 줄이고
# result idx별로 둬서 solve에서 인덱스 값 check에서 더한 값 비교

import sys
input=sys.stdin.readline

n=int(input())

digit=list(input())

s=[[0]*n for _ in range(n)]

# result 인덱스까지 합을 구하고 s에 표시된 값과 비교
def check(idx):
    hap=0
    for i in range(idx,-1,-1):
        hap+=result[i]
        if hap == 0 and s[i][idx]!=0:
            return False
        elif hap<0 and s[i][idx]>=0:
            return False
        elif hap>0 and s[i][idx]<=0:
            return False
    return True
# idx값을 비교해주는 함수 
def solve(idx):
    if idx==n:
        return True

    if s[idx][idx]==0:
        result[idx]=0
        return solve(idx+1)

    for i in range(1,11):
        result[idx]=s[idx][idx]*i
        if check(idx) and solve(idx+1):
            return True
    return False

for i in range(n):
    for j in range(i,n):
        temp=digit.pop(0)
        if temp=='+':
            s[i][j]=1
        elif temp=='-':
            s[i][j]=-1

result=[0]*n
solve(0)
print(' '.join(map(str, result)))