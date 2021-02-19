import sys
input=sys.stdin.readline

n,m = map(int, input().split())

card = list(map(int,input().split()))

max =0

for x in range(n):
    for y in range(1,n):
        for z in range(2,n):
            if x==y or x==z or y==z:
                continue
            num = card[x]+card[y]+card[z]
            if max<num and num<=m:
                    max=num
print(max)