import sys
input= sys.stdin.readline

n=int(input())

number = list(map(int,input().split()))

total = 0

for i in range(n):
    num= number.pop()
    for j in range(2,num+1):
        if num==1:
            continue

        if num %j==0:
            if j==num:
                total+=1
            else:
                break

print(total)