# 다음 순열
# permutations 쓰면 메모리 초과
from itertools import permutations
import sys
input=sys.stdin.readline

n=int(input())

total=list(map(int,input().split()))
# 앞에 픽스하고 뒷자리 최종자리 수열인거 찾아서 바로 앞자리 바꿔주고 최초 수열로 바꾸기!!
# 1. 다음 순열을 구하기 위해 뒤에서 부터 비교해 a[i-1] - a[i] 에서 a[i-1]이 더 작은 값 i 로 체크
# 2. a[i-1] 뒤에 값중 제일 a[i-1]보다 큰 값중 제일 작은 값 체크 한뒤 바꿔주기
# 3. a[i-1]뒤에 있는 값은 모두 내림차순으로 정렬돼있는 상태이기 때문에 뒤집어 주기 
def next(total):
    n=len(total)-1
    i=n
    # i > i-1 찾기
    while i>0 and total[i-1]>=total[i]:
        i-=1
    
    if i==0: # 마지막 순열
        return False
    
    # i-1를 오른쪽에서 가장 큰 값 바꿔주기
    j=n
    while total[i-1]>=total[j]: # 오른쪽에 있으면서 a[i-1]보다 큰 수
        j-=1

    total[i-1],total[j] = total[j],total[i-1]
    j=n
    
    # i부터 내림차순 정렬
    while i <j:
        total[i], total[j] = total[j], total[i] # a[i]부터 순열 뒤집기
        i += 1
        j -= 1
    return True

if next(total) is True:
    for i in total:
        print(i , end=' ')

else:
    print(-1)