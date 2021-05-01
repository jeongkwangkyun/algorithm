# 걍 for문 개돌리면 느릴듯
stones=[2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
k=3

import copy

INF=2000000

# 이분탐색
# rigth를 스톤 요소 중 가장 큰값으로 두고
# cnt(점프해야할 연속된 값)갯수에 따라서 check 값을 나눠주고
# check값이 True -> rigth 값 변화 cnt값이 커서
# False left 변화

def solution(stones, k):
    left=0
    right=INF
    # left랑 right가 같은 값을 가르킬때 stop
    while left<=right:
        mid=(left+right)//2
        tmp=copy.deepcopy(stones)
        for i in range(len(tmp)):
            tmp[i]-=mid
        #cnt는 점프해야할 연속적인 칸이 몇개인지 세주고 k랑 같아지면 break
        cnt=0
        check=False
        for i in range(len(tmp)):
            if tmp[i]<=0:
                cnt+=1
            
            else:
                cnt=0
            if cnt>=k:
                check=True
                break
        if check is True:
            right=mid-1
        else:
            left=mid+1
    return left

solution(stones,k)

