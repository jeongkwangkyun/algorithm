import sys
import math
input=sys.stdin.readline

m,n = map(int,input().split())

def isPrime(num):
    if num==1:
        return False
    n = int(math.sqrt(num))
    for k in range(2,n+1):
        if num %k ==0:
            return False    
    return True

for k in range(m,n+1):
    if isPrime(k):
        print(k)
                
# 소수 걸러주는거 범위 제곱근까지만 해도 됨
