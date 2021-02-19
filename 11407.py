import sys
input = sys.stdin.readline

n,k = map(int,input().split())

coins=[]

total=0

for i in range(n):
    coins.insert(0,int(input()))

for i in range(n):
    if coins[0]<=k:
        coin=coins.pop(0)
        total+= (k//coin)
        k%=coin
        
        
    else:
        coins.pop(0)
print(total)