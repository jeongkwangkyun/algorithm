# 프로그래머스 lv1
# 구현
numbers=[2,1,3,4,1]	

def solution(numbers):
    answer = set()
    n=len(numbers)
    for i in range(n):
        for j in range(i+1,n):
            answer.add(numbers[i]+numbers[j])
    answer=list(answer)
    answer.sort()
    return answer

solution(numbers)