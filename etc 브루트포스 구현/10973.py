# 이전 순열

import sys
input=sys.stdin.readline

n=int(input())

total=list(map(int,input().split()))
def before(total):
    n=len(total)-1
    i=n
    # i < i-1 찾기
    while i>0 and total[i-1]<=total[i]:
        i-=1
    
    if i==0: # 마지막 순열
        return False
    
    # i-1를 오른쪽에서 값 바꿔주기
    j=n
    while total[i-1]<=total[j]: # 오른쪽에 있으면서 a[i-1]보다 작은 수
        j-=1

    total[i-1],total[j] = total[j],total[i-1]
    j=n

    # i부터 내림차순 정렬 - > 순열은 다 내림차순으로 
    while i<j:
        total[i], total[j] = total[j], total[i] # a[i]부터 순열 뒤집기
        i += 1
        j -= 1
    return True

if before(total) is True:
    for i in total:
        print(i , end=' ')

else:
    print(-1)