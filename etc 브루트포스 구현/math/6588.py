# 골드바흐의 추측
# 에라토스테네스의 체 
# 조건문 줄이기

import sys
import math
input=sys.stdin.readline

# 1000000까지 소수 판별
lst=[False,False]+[True]*1000000

for x in range(1000000+1):
    for i in range(2,int(math.sqrt(x))+1):
        if x%i==0:
            lst[x]=False
            break

while 1:
    n=int(input())
    if n==0:
        sys.exit()
    
    for i in range(3,(n//2)+1):
        if lst[i]==True:
            if lst[n-i]==True:
                # 6이 3+3 출력해서 넣어줬습니다.
                if i==n:
                    print("Goldbach's conjecture is wrong.")    
                    break
                else :
                    print("{0} = {1} + {2}".format(n,i,n-i))
                    break
            # n= a+b 중 어림잡아 a가 n의 절반 넘어가면 반복문 그만 돌게했습니다.
            elif i==n//2:
                print("Goldbach's conjecture is wrong.")    
                break