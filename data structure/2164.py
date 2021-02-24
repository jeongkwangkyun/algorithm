import sys
from queue import deque

n=int(sys.stdin.readline())
arr= deque()

for i in range(n):
  arr.append(i+1)

cnt=0
while len(arr)>1:
  arr.popleft()
  arr.append(arr.popleft())
    
  cnt+=1

print(arr.pop())