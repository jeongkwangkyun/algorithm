import sys
from queue import deque

n=int(sys.stdin.readline())
arr= deque()
total=[]

for i in range(n):
  line=list(sys.stdin.readline().split())

  if line[0]=='push_front':
    arr.appendleft(line[1])

  elif line[0]=='push_back':
    arr.append(line[1])

  elif line[0]=='pop_front':
    if len(arr)==0:
      total.append(-1)
    else:
      total.append(arr.popleft())

  elif line[0]=='pop_back':
    if len(arr)==0:
      total.append(-1)
    else:
      total.append(arr.pop())
      
  elif line[0]=='size':
    total.append(len(arr))

  elif line[0]=='empty':
    if len(arr)==0:
      total.append(1)
    else:
      total.append(0)

  elif line[0]=='front':
    if len(arr)==0:
      total.append(-1)
    else:
      total.append(arr[0])

  elif line[0]=='back':
    if len(arr)==0:
      total.append(-1)
    else:
      total.append(arr[len(arr)-1])

for i in range(len(total)):
  print(total[i])