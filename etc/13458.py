# 시험감독
# 문제를 잘보자...
import sys
from collections import deque
input=sys.stdin.readline

n=int(input())

tmp=list(input().split())
room_num=deque()
total=0

for i in range(n):
    room_num.append(int(tmp[i]))

b,c=map(int,input().split())
 
for i in range(n):
    cnt=room_num.pop()

    if cnt<=b:
        total+=1

    else:

        total+=1
        cnt=cnt-b
        if cnt<c:
            total+=1
        else:
            if cnt%c==0:
                total+=cnt//c
            else:
                total+=(cnt//c)+1
print(total)