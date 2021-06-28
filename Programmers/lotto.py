# 프로그래머스
# 로또의 최고 순위와 최저 순위
# 구현
def solution(lottos, win_nums):
    answer = []
    min_result=0
    max_result=0

    for i in range(6):
        if lottos[i]==0:
            max_result+=1
        else:  
            if lottos[i] in win_nums:
                min_result+=1
                max_result+=1
        
    max_result=7-max_result
    min_result=7-min_result
    
    if max_result >=6:
        max_result=6
    if min_result>=6:
        min_result=6

    answer.append(max_result)
    answer.append(min_result)

    return answer

solution(lottos,win_nums)