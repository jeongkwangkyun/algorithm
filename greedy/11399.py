import sys
input=sys.stdin.readline

n = int(input())
lst=list(map(int,input().split()))
total=0
num=n
lst.sort()


for i in range(n):
    total+=lst[i]*num
    num-=1
print(total)