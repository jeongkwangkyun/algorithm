from collections import deque
k=10
room_number=[1,3,4,1,3,1]


answer = []
check=[False]*(k+1)
queue=deque()
for _ in range(len(room_number)):
    queue.appendleft(room_number.pop())

while queue:
    room=queue.popleft()
    
    if check[room]==False:
        answer.append(room)
        check[room]=True
    else:
        queue.appendleft(room+1)

print(answer)

# 효율성 통과 -> 카카오테크 정석
# 해쉬맵을 사용해야 에러 안뜸 -> 10^12 이기 때문
k=10
room_number=[1,3,4,1,3,1]

import sys
sys.setrecursionlimit(10000) # 재귀 리미트- 설정할 시 범위까지만 재귀 돈다

def find(chk,rooms):
    if chk not in rooms:
        rooms[chk]=chk+1
        return chk

    empty=find(rooms[chk],rooms)
    # 빈방이 나오기 전 방문했던 부모 노드 바꿔줌
    rooms[chk]=empty+1
    return empty

def solution1(k,room_number):
    answer=[]
    # 해당 value는 다음 방 번호 값
    rooms=dict()

    for i in room_number:
        chk_in=find(i,rooms)
        answer.append(chk_in)

    return answer

solution1(k,room_number)