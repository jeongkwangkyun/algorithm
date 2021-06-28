# 프로그래머스 lv1
# 폰켓몬
# 굳이 콤비네이션 안돌려도 생각으로 푸는 문제

nums=[3,3,3,2,2,2]	

def solution(nums):
    answer = 0
    max=len(nums)//2

    nums=set(nums)
    answer=max
    if max>len(nums):
        answer=len(nums)

    return answer

solution(nums)