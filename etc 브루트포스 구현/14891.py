#구현
# 시물레이션
from collections import deque
import sys
input=sys.stdin.readline


first=deque(map(int,input().strip()))
second=deque(map(int,input().strip()))
third=deque(map(int,input().strip()))
fourth=deque(map(int,input().strip()))

n=int(input())
cnt=0

for i in range(n):
    num,direction=map(int,input().split())

    #첫번째
    if num==1:
        #시계 방향
        if direction==1:
            #1,2,3,4 정 반 정 반
            if first[2] != second[6] and second[2]!=third[6] and third[2] != fourth[6]:
                first.appendleft(first.pop())
                second.append(second.popleft())
                third.appendleft(third.pop())
                fourth.append(fourth.popleft())
            #1 2 3
            elif first[2] != second[6] and second[2]!=third[6]:
                first.appendleft(first.pop())
                second.append(second.popleft())
                third.appendleft(third.pop())
            # 1 2
            elif first[2] != second[6]:
                first.appendleft(first.pop())
                second.append(second.popleft())
            # 1
            else:
                first.appendleft(first.pop())
        #반시계
        else:
            # 1 2 3 4 반 정 반 정
            if first[2] != second[6] and second[2]!=third[6] and third[2] != fourth[6]:
                first.append(first.popleft())
                second.appendleft(second.pop())
                third.append(third.popleft())
                fourth.appendleft(fourth.pop())
            # 12 3
            elif first[2] != second[6] and second[2]!=third[6]:
                first.append(first.popleft())
                second.appendleft(second.pop())
                third.append(third.popleft())
            # 12
            elif first[2] != second[6]:
                first.append(first.popleft())
                second.appendleft(second.pop())
            # 1
            else:
                first.append(first.popleft())

    #두번째
    elif num==2:
        # 두번째 정방향
        if direction==1:
            # 1 2 3 4 반정반정
            if first[2] != second[6] and second[2]!=third[6] and third[2] != fourth[6]:
                first.append(first.popleft())
                second.appendleft(second.pop())
                third.append(third.popleft())
                fourth.appendleft(fourth.pop())
            # 1 2 3 반 정 반
            elif first[2] != second[6] and second[2]!=third[6] :
                first.append(first.popleft())
                second.appendleft(second.pop())
                third.append(third.popleft())
            # 2 34 정 반 정
            elif second[2]!=third[6] and third[2] != fourth[6]:
                second.appendleft(second.pop())
                third.append(third.popleft())
                fourth.appendleft(fourth.pop())
            # 1 2 반 정
            elif first[2] != second[6]:
                first.append(first.popleft())
                second.appendleft(second.pop())
            # 23 정 반
            elif second[2]!=third[6] :
                second.appendleft(second.pop())
                third.append(third.popleft())
            # 2 정
            else:
                second.appendleft(second.pop())
        #역방향
        else:
            #1,2,3,4 정 반 정 반
            if first[2] != second[6] and second[2]!=third[6] and third[2] != fourth[6]:
                first.appendleft(first.pop())
                second.append(second.popleft())
                third.appendleft(third.pop())
                fourth.append(fourth.popleft())
            #1 2 3
            elif first[2] != second[6] and second[2]!=third[6]:
                first.appendleft(first.pop())
                second.append(second.popleft())
                third.appendleft(third.pop())
            # 234
            elif second[2]!=third[6] and third[2] != fourth[6]:
                second.append(second.popleft())
                third.appendleft(third.pop())
                fourth.append(fourth.popleft())
            # 1 2
            elif first[2] != second[6]:
                first.appendleft(first.pop())
                second.append(second.popleft())
            # 23
            elif second[2]!=third[6]:
                second.append(second.popleft())
                third.appendleft(third.pop())  
            # 2
            else:
                second.append(second.popleft())
    #세번째
    elif num==3:
        if direction==1:
            #1,2,3,4 정 반 정 반
            if first[2] != second[6] and second[2]!=third[6] and third[2] != fourth[6]:
                first.appendleft(first.pop())
                second.append(second.popleft())
                third.appendleft(third.pop())
                fourth.append(fourth.popleft())
            # 2 3 4 반 정 반
            elif second[2]!=third[6] and third[2] != fourth[6]:
                second.append(second.popleft())
                third.appendleft(third.pop())
                fourth.append(fourth.popleft())
            # 123 정반정
            elif first[2] != second[6] and second[2]!=third[6] :
                first.appendleft(first.pop())
                second.append(second.popleft())
                third.appendleft(third.pop())
            # 23
            elif second[2]!=third[6] :
                second.append(second.popleft())
                third.appendleft(third.pop())
            # 3 4
            elif third[2] != fourth[6]:
                third.appendleft(third.pop())
                fourth.append(fourth.popleft())
            # 3
            else:
                third.appendleft(third.pop())
        else :
            # 1 2 3 4 반 정 반 정
            if first[2] != second[6] and second[2]!=third[6] and third[2] != fourth[6]:
                first.append(first.popleft())
                second.appendleft(second.pop())
                third.append(third.popleft())
                fourth.appendleft(fourth.pop())
            # 234
            elif second[2]!=third[6] and third[2] != fourth[6]:
                second.appendleft(second.pop())
                third.append(third.popleft())
                fourth.appendleft(fourth.pop())
            # 123
            elif first[2] != second[6] and second[2]!=third[6] :
                first.append(first.popleft())
                second.appendleft(second.pop())
                third.append(third.popleft())
            # 23
            elif second[2]!=third[6] :
                second.appendleft(second.pop())
                third.append(third.popleft())
            #34
            elif third[2] != fourth[6]:
                third.append(third.popleft())
                fourth.appendleft(fourth.pop())
            # 3
            else:
                third.append(third.popleft())

            
    #네번째
    else:
        # 두번째 정방향
        if direction==1:
            # 1 2 3 4 반정반정
            if first[2] != second[6] and second[2]!=third[6] and third[2] != fourth[6]:
                first.append(first.popleft())
                second.appendleft(second.pop())
                third.append(third.popleft())
                fourth.appendleft(fourth.pop())
            #  2 3 4 정반 정
            elif second[2]!=third[6] and third[2] != fourth[6]:
                second.appendleft(second.pop())
                third.append(third.popleft())
                fourth.appendleft(fourth.pop())
            # 34 반 정
            elif third[2] != fourth[6]:
                third.append(third.popleft())
                fourth.appendleft(fourth.pop())
            # 4 정
            else:
                fourth.appendleft(fourth.pop())
        #역방향
        else:
            #1,2,3,4 정 반 정 반
            if first[2] != second[6] and second[2]!=third[6] and third[2] != fourth[6]:
                first.appendleft(first.pop())
                second.append(second.popleft())
                third.appendleft(third.pop())
                fourth.append(fourth.popleft())
            #234
            elif second[2]!=third[6] and third[2] != fourth[6]:
                second.append(second.popleft())
                third.appendleft(third.pop())
                fourth.append(fourth.popleft())
            # 34
            elif third[2] != fourth[6]:
                third.appendleft(third.pop())
                fourth.append(fourth.popleft())
            # 4
            else:
                fourth.append(fourth.popleft())
if first[0]==1:
    cnt+=1
if second[0]==1:
    cnt+=2
if third[0]==1:
    cnt+=4
if fourth[0]==1:
    cnt+=8
print(cnt)