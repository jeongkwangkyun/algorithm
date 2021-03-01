import sys

stack = []
total=0

n = int(sys.stdin.readline())
top=0

for i in range(n):
  
  inpu=int(sys.stdin.readline())

  if inpu==0:
    total-=stack.pop()
  else:
    stack.append(inpu)
    total+=inpu

print(total)