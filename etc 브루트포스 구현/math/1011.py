import sys
import math
n =int(sys.stdin.readline())


for i in range(n):
    x,y=map(int,input().split())
    degree=y-x
    max=int(math.sqrt(degree))
    if max==math.sqrt(degree):
        print(2*max-1)
    elif math.sqrt(degree)-max<=0.5:
        print(2*max)
    else:
        print(2*max+1)