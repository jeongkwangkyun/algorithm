import sys
input=sys.stdin.readline

n = int(input())
lst=[]
total=[]

for i in range(n):
    time = list(map(int,input().split()))
    time.reverse()
    lst.append(time)

lst.sort()
total.append(lst.pop(0))

for i in range(len(lst)):
    if total[0][0]<=lst[0][1]:
        total.insert(0,lst.pop(0))
    else:
        lst.pop(0)
print(len(total))