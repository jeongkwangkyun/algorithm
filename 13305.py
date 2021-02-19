import sys
input=sys.stdin.readline

n=int(input())

degree=list(map(int,input().split()))
gas=list(map(int,input().split()))

total =0
minGas=sys.maxsize

for i in range(len(degree)):
    if i==0:
        total+=degree[0]*gas[0]
        minGas=min(minGas,gas[i])
    else:
        minGas=min(minGas,gas[i])
        total+=minGas*degree[i]
print(total)