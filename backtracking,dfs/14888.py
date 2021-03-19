import sys
input=sys.stdin.readline

n=int(input())

A=list(map(int,input().split()))
# + , - , * , // 순서
flag = list(map(int,input().split()))
max_size=sys.maxsize
min_size= -1000000001


