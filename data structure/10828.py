import sys

stack = []
final=[]

n = int(sys.stdin.readline())
top=0

for i in range(n):
  
  inpu=sys.stdin.readline().split()
  if inpu[0]=='push':
    stack.append(inpu[1])
    top+=1  

  elif inpu[0]=='pop':
    if top==0:
      final.append(-1)
    else:
      final.append(stack.pop())
      top-=1

  elif inpu[0]=='size':
    final.append(top)

  elif inpu[0]=='empty':
    if top==0:
      final.append(1)
    else:
      final.append(0)

  elif inpu[0]=='top':
    if top==0:
      final.append(-1)
    else: 
      top1=stack[-1]
      final.append(top1)

for i in range(len(final)):
  print(int(final[i]))