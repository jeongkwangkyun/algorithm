# 연산자 끼워넣기
# 브루트 포스
import sys
from collections import deque
input=sys.stdin.readline

n=int(input())

a=list(map(int,input().split()))
# + , - , * , // 순서
flag = list(map(int,input().split()))
max_size=-sys.maxsize
min_size=sys.maxsize

def dfs(cnt):
    global max_size,min_size
    if cnt==n-1:
        res=a[0]
        for i in range(n-1):
            if q[i]==0:
                res += a[i+1]
            elif q[i]==1:
                res -= a[i+1]
            elif q[i]==2:
                res*=a[i+1]
            else:
                res=int(res/a[i+1])

        max_size=max(max_size,res)
        min_size=min(min_size,res)

    # 순열 쓰는 파트
    for i in range(4):
        if select[i]==flag[i]:
            continue
        select[i]+=1
        q.append(i)
        dfs(cnt+1)
        select[i]-=1
        q.pop()
# 빈 리스트 순열용
select=[0 for _ in range(4)]

# 덱 사용해서 0,1,2,3 넣어서 dfs
q=deque()
dfs(0)
print(max_size)
print(min_size)