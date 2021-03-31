# 골드바흐의 추측
# 에라토스테네스의 체 
# 조건문 줄이기

import sys
import math
input=sys.stdin.readline

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
                if i==n:
                    print("Goldbach's conjecture is wrong.")    
                    break
                else :
                    print("{0} = {1} + {2}".format(n,i,n-i))
                    frag=True
                    break

            elif i==n//2:
                print("Goldbach's conjecture is wrong.")    
                break