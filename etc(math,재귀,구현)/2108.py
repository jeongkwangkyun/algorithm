import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())
lst=[]

for i in range(n):
    a=int(input())
    lst.append(a)

lst.sort()
#산술평균
avg=0

for i in range(n):
    avg+=lst[i]
avg/=n
print(round(avg))

#중앙값
center=lst[int((n+1)/2)-1]
print(center)

#최빈값
if n>1:
    cnt=Counter(lst).most_common(2)
    if cnt[0][1]==cnt[1][1]:
        print(cnt[1][0])
    else:
        print(cnt[0][0])
else:
    print(lst[0])
#범위
rg=abs(lst[n-1]-lst[0])
print(rg)