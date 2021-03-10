import sys

input=sys.stdin.readline
a = int(input())
if a==0:
    print(0)
else:
    def fibo(n):
        return fibo(n-1) + fibo(n-2) if n >= 2 else n

    for n in range(a+1):
        if n==a:
            print(fibo(n))
        