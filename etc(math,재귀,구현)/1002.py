import sys
import math
input=sys.stdin.readline

total=[]

T=int(input())

for i in range(T):
    x1,y1,r1,x2,y2,r2 = map(int,input().split())

    d=math.sqrt(pow(abs(x1-x2),2)+pow(abs(y1-y2),2))

    if x1==x2 and y1==y2 and r1==r2:
        print(-1)
    elif abs(r1-r2)<d and d<r1+r2:
        print(2)
    elif r1+r2==d:
        print(1)
    elif abs(r1-r2)==d:
        print(1)
    elif r1+r2<d or abs(r1-r2)>d or d==0:
        print(0)
        