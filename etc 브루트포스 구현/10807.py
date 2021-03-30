a = int(input())
b=list(map(int,input().split()))
c=int(input())
total=0
for i in range(a):
  if b[i]==c:
    total+=1

print(total)