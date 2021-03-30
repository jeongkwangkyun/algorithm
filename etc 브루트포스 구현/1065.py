import sys

inpu=int(sys.stdin.readline())
total=0

for i in range(1,inpu+1):
  n=list(map(int,str(i)))
  if len(n)<=2:
    total+=1
  else:
      if n[0]-n[1] ==n[1]-n[2]:
        total+=1

print(total)