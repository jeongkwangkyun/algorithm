# 프로그래머스 lv 1
# 구현, combination 쓰는거
from itertools import combinations


def solution(nums):
    answer = -1
    lst=list(combinations(nums,3))
    for num in lst:
        cnt=0
        for i in num:
            cnt+=i
        flag=False
        for j in range(2,cnt):
            if cnt%j==0:
                flag=True
                break
        if flag==False:
            answer+=1


    return answer