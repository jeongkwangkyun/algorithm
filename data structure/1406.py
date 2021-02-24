import sys

strings = sys.stdin.readline().rstrip()
commands = int(sys.stdin.readline().rstrip())
left=[]
right=[]

for i in range(len(strings)):
  left.append(strings[i])

for i in range(commands):
  command=sys.stdin.readline().rstrip().split()

  if command[0]=='P':
    left.append(command[1])

  elif command[0]=='B':
    if len(left):
      left.pop()

  elif command[0]=='L':
    if len(left):
      right.append(left.pop())

  elif command[0]=='D':
    if len(right):
      left.append(right.pop())

print(''.join(left+right[::-1]))