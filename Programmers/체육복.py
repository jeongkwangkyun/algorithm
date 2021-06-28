# 프로그래머스 lv1
# 그리디
# 고려 안한 tc 1 자기 자신이 잃어버릴때
# tc2 앞에서 빌릴지 뒤에서 빌릴지

import copy
def solution(n, lost, reserve):
    tmp_lost=copy.deepcopy(lost)
    tmp_reserve=[]

    for i in reserve:
        if i not in lost:
            tmp_reserve.append(i)
        else:
            tmp_lost.remove(i)
    reserve=copy.deepcopy(tmp_reserve)
    lost=copy.deepcopy(tmp_lost)

    for i in tmp_reserve:
        if i+1 in tmp_lost:
            tmp_lost.remove(i+1)
            continue
        if i-1 in tmp_lost:
            tmp_lost.remove(i-1)
    
    for i in reserve:
        if i-1 in lost:
            lost.remove(i-1)
            continue
        if i+1 in lost:
            lost.remove(i+1)
    
    answer=max(n-len(tmp_lost),n-len(lost))

    return answer
solution(n,lost,reserve)