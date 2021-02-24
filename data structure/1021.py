import sys
from collections import deque

deq=deque()
total=0

n,m=map(int,input().split())
for i in range(n):
  deq.append(i+1)  

number=list(map(int,input().split()))

for i in range(m):
  while 1:
    if deq[0]==number[i]:
      deq.popleft()
      break
    
    else:
      if len(deq)//2>=deq.index(number[i]):
        deq.rotate(-1)
        total+=1
      else:
        deq.rotate(1)
        total+=1

print(total)