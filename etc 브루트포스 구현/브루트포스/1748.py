# 수 이어쓰기 
# 1~9 9개 10~99 90개 100~999 900개 등 규칙과 자릿수를 이용하여
# 브루트포스보단 수학문제같음

import sys
input=sys.stdin.readline

n=int(input())

ans=0
n=str(n)
n_len=len(n)

for i in range(n_len-1):
    ans+=9*(10**i)*(i+1)

ans+=(int(n)-(10**(n_len-1))+1)*(n_len)

print(ans)