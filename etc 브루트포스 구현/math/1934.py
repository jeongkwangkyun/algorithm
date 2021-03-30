import math

tc=int(input())

for i in range(tc):
    a,b=map(int,input().split())

    print(a*b//math.gcd(a,b))