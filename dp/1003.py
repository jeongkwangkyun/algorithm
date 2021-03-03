# dp 문젠데 피보나치 수열 낚시같음
# n이 1,2,3,4,5, 일때마다
# zero  1,0,1,1,2,3
# one   0,1,1,2,3,5 
# 다음 제로 값은 원에서 가져오고 다음 원 값은 제로 더하기 원
import sys
input=sys.stdin.readline

for _ in range(int(input())):
    n=int(input())    
    zero=1
    one=0
    tmp=0
    for _ in range(n):
        tmp=one
        one=zero+one
        zero=tmp
    print(zero,one)